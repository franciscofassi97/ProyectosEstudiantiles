<%-- 
    Document   : listadoParejas
    Created on : 2 nov. 2020, 9:31:28
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="gestor" scope="request" class="GestorBD.GestorRegalos" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    </head>
    <%@include file="Menu.jsp" %>
    <body>
        <!---------------------------------------------------------------------------------------------------------------------->         
        <!----------------------------------------LISTADO DE PAREJAS CRUD/ABM---------------------------------------------------> 
        <!---------------------------------------------------------------------------------------------------------------------->         

        <h1 class="text-info display-4">Listado De Parejas</h1>

        <div class="container">
            <div class="row justify-content-md-center">
                <table class="table table-bordered table-hover">
                    <thead>
                        <tr>
                            <th scope="col" class="text-center text-primary font-weight-normal">Nombre Las Parejas</th>
                            <th scope="col" class="text-center text-primary font-weight-normal">Fecha de alta</th>
                            <th scope="col" class="text-center text-primary font-weight-normal">Contaco</th>
                            <th scope="col" class="text-center text-primary font-weight-normal">Direccion</th>
                            <th scope="col" class="text-center text-primary font-weight-normal" colspan="2" >Acciones</th>
                        </tr>
                    </thead>        

                    <c:forEach items="${gestor.listaParejas}" var = "pareja"  >
                        <tbody>

                            <tr class="table-primary text-center">
                                <td> ${pareja.nombrePareja} </td>
                                <td> ${pareja.fechaPareja} </td>
                                <td> ${pareja.telefonoPareja} </td>
                                <td> ${pareja.direccionPareja} </td>
                                <td><a class="btn btn-info" href="/Regalos/modificarPareja?idPareja=${pareja.idPareja}">Modificar</a></td>
                                <td><a class="btn btn-info" href="/Regalos/eliminarPareja?idPareja=${pareja.idPareja}">Eliminar</a></td>

                            </tr>
                        </tbody>    
                    </c:forEach>
                </table> 
            </div>    
        </div>

        <%@include file="Footer.jsp" %>
        
        
        
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>



    </body>
</html>
