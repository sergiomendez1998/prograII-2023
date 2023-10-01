package com.example.crudmvcjavaprograii.Controlador;


import com.example.crudmvcjavaprograii.ModeloDAO.GeneroDAO;
import com.example.crudmvcjavaprograii.ModeloDAO.LoginDAO;
import com.example.crudmvcjavaprograii.ModeloDAO.PersonaDAO;
import com.example.crudmvcjavaprograii.Modelo.Persona;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


public class Controlador extends HttpServlet {

    String listar = "vistas/listar.jsp";
    String add = "vistas/add.jsp";
    String edit = "vistas/edit.jsp";
    Persona p = new Persona();
    PersonaDAO dao = new PersonaDAO();
    GeneroDAO generoDAO = new GeneroDAO();
    LoginDAO loginDAO = new LoginDAO();
    String login = "vistas/login.jsp";
    int id;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        boolean currentSession = session.getAttribute("login") != null;
        String acceso = "";
        String action = request.getParameter("accion");
        System.out.println(action);

        if (GeneroDAO.LISTA_GENEROS.size() == 0) {
            generoDAO.addGenerosToList();
        }

        if (action.equalsIgnoreCase("listar")) {
            acceso = currentSession ? listar : login;
        } else if (action.equalsIgnoreCase("add")) {
            acceso = currentSession ? add : login;
        } else if (action.equalsIgnoreCase("Agregar")) {
            Validator validator = new Validator();
            String dpi = request.getParameter("txtDpi");
            String nom = request.getParameter("txtNom");
            int idGenero = Integer.parseInt(request.getParameter("txtGen"));
            p.setDpi(dpi);
            p.setNom(nom);

            if(idGenero != 0) {
                p.setGenero(generoDAO.getGeneroById(idGenero));
            }
            validator.validate(p);
            if(!Validator.hasErrors()) {
                dao.add(p);
                acceso = listar;
            } else {
                request.setAttribute("errors", Validator.errors);
                acceso = add;
            }
        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("idper", request.getParameter("id"));
            acceso = edit;
        } else if (action.equalsIgnoreCase("Actualizar")) {
            id = Integer.parseInt(request.getParameter("txtid"));
            String dni = request.getParameter("txtDpi");
            String nom = request.getParameter("txtNom");
            int idGenero = Integer.parseInt(request.getParameter("txtGen"));
            p.setId(id);
            p.setDpi(dni);
            p.setNom(nom);
            p.setGenero(generoDAO.getGeneroById(idGenero));
            dao.edit(p);
            acceso = listar;
        } else if (action.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("id"));
            p.setId(id);
            dao.eliminar(id);
            acceso = listar;
        } else if (action.equalsIgnoreCase("login")) {
            acceso = currentSession ? listar : login;
        } else if (action.equalsIgnoreCase("inicio")) {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            System.out.println(loginDAO.validar(username, password) + " respuesta en el login");
            if (loginDAO.validar(username, password)) {
                session.setAttribute("login", username);
                acceso = listar;
            } else {
                acceso = login;
            }
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
