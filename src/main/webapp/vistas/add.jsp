<%-- 
    Document   : add
    Created on : 30-ago-2018, 19:58:16
    Author     : Joel
--%>

<%@ page import="com.example.crudmvcjavaprograii.Modelo.Genero" %>
<%@ page import="com.example.crudmvcjavaprograii.ModeloDAO.GeneroDAO" %>
<%@ page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Map<String, String> errorsMap = (Map<String, String>) request.getAttribute("errors"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
        <title>JSP Page</title>
    </head>
    <body>
    <% if (errorsMap != null && !errorsMap.isEmpty()) { %>
    <div class="alert alert-danger alert-dismissible fade show" role="alert">
        <ul>
            <% for (Map.Entry<String, String> entry : errorsMap.entrySet()) { %>
            <li><%= entry.getValue() %></li>
            <% } %>
        </ul>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
    <% } %>
        <div class="container">
            <div class="col-lg-6">
                <h1>Agregar Persona</h1>
                <form action="Controlador" class="was-validated">

                    <div class="form-outline mb-4">
                        <label class="form-label" for="dni">DNI</label>
                        <input type="text" id="dni" class="form-control" name="txtDpi" maxlength="10" required />
                    </div>

                    <div class="form-outline mb-4">
                        <label class="form-label" for="name">Nombres</label>
                        <input type="text" id="name" class="form-control" name="txtNom" required />
                    </div>

                    <div class="form-outline mb-4">
                    <label class="form-label" for="gender">Genero</label>
                    <select class="form-control mb-3" name="txtGen" id="gender" >
                        <option value="0"></option>
                        <%
                            Set<Genero> list = new HashSet<>(GeneroDAO.LISTA_GENEROS);
                            Iterator<Genero> iter = list.iterator();
                            Genero genero = null;
                            while (iter.hasNext()) {
                                genero = iter.next();
                        %>
                        <option value="<%= genero.getId()%>" ><%= genero.getNombre()%></option>
                        <%}%>
                    </select>
                    </div><br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a class="btn btn-warning" href="Controlador?accion=listar">Regresar</a>
                </form>
            </div>

        </div>
    </body>

</html>
