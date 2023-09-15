<%-- 
    Document   : add
    Created on : 30-ago-2018, 19:58:16
    Author     : Joel
--%>

<%@page import="java.util.HashSet"%>
<%@ page import="com.example.crudmvcjavaprograii.Modelo.Genero" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Iterator" %>
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
                <h1>Agregar Persona</h1>
                <form action="Controlador" class="was-validated">

                    <div class="form-outline mb-4">
                        <label class="form-label" for="dni">DNI</label>
                        <input type="text" id="dni" class="form-control" name="txtDpi" maxlength="10" required />
                    </div><br>

                    <div class="form-outline mb-4">
                        <label class="form-label" for="name">Nombres</label>
                        <input type="text" id="name" class="form-control" name="txtNom" required />
                    </div><br>

                    <div class="form-outline mb-4">
                    <label class="form-label" for="gender">Genero</label>
                    <select class="form-control mb-3" name="txtGen" id="gender" >
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
