<%-- 
    Document   : add
    Created on : 30-ago-2018, 19:58:16
    Author     : Joel
--%>

<%@page import="java.util.HashSet"%>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.example.crudmvcjavaprograii.Modelo.Sede" %>
<%@ page import="com.example.crudmvcjavaprograii.ModeloDAO.SedeDAO" %>
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
                        <label class="form-label" for="carnet">Carnet</label>
                        <input type="text" id="carnet" class="form-control" name="txtCarnet" required />
                    </div><br>

                    <div class="form-outline mb-4">
                        <label class="form-label" for="name">Nombre</label>
                        <input type="text" id="name" class="form-control" name="txtNombre" required />
                    </div><br>


                    <div class="form-outline mb-4">
                        <label class="form-label" for="lastname">Apellido</label>
                        <input type="text" id="lastname" class="form-control" name="txtApellido" required />
                    </div><br>

                    <div class="form-outline mb-4">
                        <label class="form-label" for="edad">Edad</label>
                        <input type="text" id="edad" class="form-control" name="txtEdad" required />
                    </div><br>

                    <div class="form-outline mb-4">
                    <label class="form-label" for="gender">Sede</label>
                    <select class="form-control mb-3" name="txtSede" id="gender" >
                        <%
                            Set<Sede> list = new HashSet<>(SedeDAO.LISTA_SEDES);
                            Iterator<Sede> iter = list.iterator();
                            Sede sede = null;
                            while (iter.hasNext()) {
                                sede = iter.next();
                        %>
                        <option value="<%= sede.getId()%>" ><%= sede.getNombre()%></option>
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
