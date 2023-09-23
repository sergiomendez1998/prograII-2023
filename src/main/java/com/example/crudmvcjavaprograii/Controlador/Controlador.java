package com.example.crudmvcjavaprograii.Controlador;


import com.example.crudmvcjavaprograii.Modelo.Estudiante;
import com.example.crudmvcjavaprograii.Modelo.Sede;
import com.example.crudmvcjavaprograii.ModeloDAO.*;


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
    String login = "vistas/Login.jsp";


    EstudianteDAO estudianteDAO = new EstudianteDAO();
    Estudiante estudiante = new Estudiante();
    SedeDAO sedeDAO = new SedeDAO();
    LoginDAO loginDAO = new LoginDAO();
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
        if(SedeDAO.LISTA_SEDES.isEmpty()){
            sedeDAO.llenarListadoSedes();
        }
        if (action.equalsIgnoreCase("listar")) {
            acceso = currentSession  ?  listar : login;
        } else if (action.equalsIgnoreCase("add")) {
            acceso = currentSession  ?  add : login;
        } else if (action.equalsIgnoreCase("Agregar")) {
            String carnet = request.getParameter("txtCarnet");
            String nombre = request.getParameter("txtNombre");
            String apellido = request.getParameter("txtApellido");
            int  edad = Integer.parseInt(request.getParameter("txtEdad"));
            int sede_id = Integer.parseInt(request.getParameter("txtSede"));

            Sede sede = SedeDAO.LISTA_SEDES.stream()
                    .filter(sede1 -> sede1.getId() == sede_id)
                    .findFirst()
                    .orElse(null);

            estudiante.setCarnet(carnet);
            estudiante.setNombre(nombre);
            estudiante.setApellido(apellido);
            estudiante.setEdad(edad);
            estudiante.setSede(sede);
            estudianteDAO.add(estudiante);

            acceso = currentSession ?  listar : login;
        } else if (action.equalsIgnoreCase("login")) {
            acceso = currentSession ?  listar : login;
        }else if (action.equalsIgnoreCase("inicio")) {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            System.out.println(loginDAO.validar(username, password) + " respuesta en el login");
            if (loginDAO.validar(username, password)) {
                // Guardar una variable en la sesión
                session.setAttribute("login", username);
                acceso = listar;
            }else{
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
