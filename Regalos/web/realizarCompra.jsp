<%-- 
    Document   : realizarCompra
    Created on : 8 nov. 2020, 16:31:46
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="gestorRegalos" scope="request" class="GestorBD.GestorRegalos" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="Menu.jsp" %>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

    </head>
    <body>
        <h4 class="display-4 text-center text-info"> Realizar Compra</h4>
        
        <div class="container">
            <div class="row justify-content-md-center">
        
        <form method="POST" action="realizarCompra"> 
            <table class="table table-bordered table-hover">
                <label>Numero de compra</label>
                <input type="number" class="form-control" name="txtIdCompra" min="15000">
                <thead>
                    <tr>
                        <th scope="col" class="text-center text-primary font-weight-normal">Pareja</th>
                        <th scope="col" class="text-center text-primary font-weight-normal">Monto disponible</th>
                        <th scope="col" class="text-center text-primary font-weight-normal"  ></th>
                    </tr>

                </thead>


                <c:forEach items="${gestorRegalos.listaParejas}" var = "pareja" > 

                    <tr>
                        <td> ${pareja.nombrePareja} </td>
                        <td> ${gestorRegalos.totalDeposito(pareja.idPareja)} </td>


                        <td><button type="submit" class="btn btn-primary" value="${pareja.idPareja}"  name="txtIdPareja">RealizarCompra</button></td>


                    </tr>
                </c:forEach>
                    <br>
                Fecha compra:<input type="date" name="txtFecha" required/> 

            </table> 
        </form>
        </div>
        </div>

    </body>
    <%@include file="Footer.jsp" %>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>

</html>
