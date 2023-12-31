
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page import="com.example.crudmvcjavaprograii.ModeloDAO.PersonaDAO" %>
<%@ page import="com.example.crudmvcjavaprograii.Modelo.Persona" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <h1>Personas</h1>
            <a class="btn btn-success" href="Controlador?accion=add">
                <i class="bi bi-person-fill-add"></i> Agregar
            </a>
            <br>
            <br>
            <div class="card-body">
                <div class="table-responsive" id="proTeamScroll" tabindex="2" style="height: 400px; overflow: hidden; outline: none;">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">DPI</th>
                        <th class="text-center">NOMBRES</th>
                        <th class="text-center">Genero</th>
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    PersonaDAO dao=new PersonaDAO();
                    List<Persona>list=dao.listar();
                    Iterator<Persona>iter=list.iterator();
                    Persona per=null;
                    while(iter.hasNext()){
                        per=iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= per.getId()%></td>
                        <td class="text-center"><%= per.getDpi()%></td>
                        <td><%= per.getNom()%></td>
                        <td class="text-center"><%= per.getGenero().getNombre() %></td>
                        <td class="text-center">
                            <a href="Controlador?accion=editar&id=<%= per.getId()%>">
    <span style="background-color: orange; padding: 5px; border-radius: 5px; margin-right: 10px;">
        <i class="bi bi-pencil-square" style="color: white;"></i>
    </span>
                            </a>
                            <a href="Controlador?accion=eliminar&id=<%= per.getId()%>">
    <span style="background-color: red; padding: 5px; border-radius: 5px; margin-right: 10px;">
        <i class="bi bi-trash trash3-fill" style="color: white;"></i>
    </span>
                            </a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

                    </div>
            </div>

        </div>
    </body>
</html>
