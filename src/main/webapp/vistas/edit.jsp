
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@ page import="com.example.crudmvcjavaprograii.ModeloDAO.PersonaDAO" %>
<%@ page import="com.example.crudmvcjavaprograii.Modelo.Persona" %>
<%@ page import="com.example.crudmvcjavaprograii.Modelo.Genero" %>
<%@ page import="com.example.crudmvcjavaprograii.ModeloDAO.GeneroDAO" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
                <%
                    PersonaDAO dao = new PersonaDAO();
                    int id = Integer.parseInt((String) request.getAttribute("idper"));
                    Persona p = (Persona) dao.list(id);
                %>
                <h1>Modificar Persona</h1>
                <form action="Controlador">

                    <div class="form-outline mb-4">
                        <label class="form-label" for="dni">DNI</label>
                        <input type="text" id="dni" class="form-control" name="txtDpi" maxlength="10" value="<%= p.getDpi()%>"/>
                    </div><br>
                    <div class="form-outline mb-4">
                        <label class="form-label" for="name">Nombres</label>
                        <input type="text" id="name" class="form-control" name="txtNom" value="<%= p.getNom()%>"/>
                    </div><br>

                    <div class="form-outline mb-4">
                        <label class="form-label" for="gender">Genero</label>
                        <select class="form-control mb-3" name="txtGen" id="gender" >
                        <%
                            Set<Genero> generos = new HashSet<>(GeneroDAO.LISTA_GENEROS);
                            for (Genero genero : generos) {
                                String selected = "";
                                if (p.getGenero() != null && p.getGenero().getId() == genero.getId()) {
                                    selected = "selected";
                                }
                        %>
                        <option value="<%= genero.getId()%>" <%= selected%>><%= genero.getNombre()%></option>
                        <%
                            }
                        %>
                    </select>
                    </div><br>

                    <input type="hidden" name="txtid" value="<%= p.getId()%>">
                    <input class="btn btn-primary" type="submit" name="accion" value="Actualizar">
                    <a class="btn btn-warning" href="Controlador?accion=listar">Regresar</a>
                </form>
            </div>

        </div>
    </body>
</html>
