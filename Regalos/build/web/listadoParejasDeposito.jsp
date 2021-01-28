<%-- 
    Document   : ReporteParejasDeposito
    Created on : 4 nov. 2020, 9:23:30
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
        <!--REPORTE N° 1 LISTADO DE PAREJAS REGISTARDAS, IDICANDO CANTIDAD DE DEPOSITOS RECIBIDOS Y SUMA TOTAL DE LOS MISMOS ---> 
        <!---------------------------------------------------------------------------------------------------------------------->         

        <h5 class="text-center text-primary">Listado de Parejas con sus Depositos</h5>

        <div class="container">
            <div class="row justify-content-md-center">
                <table class="table table-bordered table-hover">
                    <thead>
                        <tr>
                            <th scope="col" class="text-center text-primary font-weight-normal">Nombre Las Parejas</th>
                            <th scope="col" class="text-center text-primary font-weight-normal">Cantidad de Depositos</th>
                            <th scope="col" class="text-center text-primary font-weight-normal">Monto total</th>
                        </tr>
                    </thead>

                    <c:forEach items="${gestor.listaParejasXDepositos()}" var = "DTOParejasDepositos"  >
                        <tbody>
                            <tr class="table-primary text-center">
                                <td> ${DTOParejasDepositos.nombrePareja} </td>
                                <td> ${DTOParejasDepositos.cantidadDepositos} </td>
                                <td> ${DTOParejasDepositos.montoDepositado} </td>

                            </tr> 
                        </tbody>
                    </c:forEach>
                </table>
            </div>
        </div>
        <br>
        <br>
        <br>
        
        <!---------------------------------------------------------------------------------------------------------------------->         
        <!--REPORTE N°3 LISTADO DE LOS 5 ARTICULOS MAS SOLICITADOS,INDICANDO LA CANTIDAD DE PAREJAS QUE PIDIERON A CADA ARTICULO--> 
        <!---------------------------------------------------------------------------------------------------------------------->         

        <h5 class="text-center text-primary">Top 5 Articulos Mas Vendidos y Cantidad Parejas Cantidad De Parejas Que Los Compraron</h5>
        <div class="container">
            <div class="row justify-content-md-center">

                <table class="table table-bordered table-hover  ">
                    <thead>
                        <tr>
                            <th scope="col" class="text-center text-primary font-weight-normal">Articulos</th>
                            <th scope="col" class="text-center text-primary font-weight-normal">Cantidad Articulos</th>
                            <th scope="col" class="text-center text-primary font-weight-normal">Nº Parejas que compraron</th>
                        </tr>
                    </thead>
                    <c:forEach items="${gestor.listaArticulosMasComprados()}" var = "DTOArticulosMasComprados"  >      
                        <tbody>
                            <tr class="table-primary text-center">
                                <td> ${DTOArticulosMasComprados.nombreArticulo} </td>  
                                <td> ${DTOArticulosMasComprados.canitdadArticulo} </td> 
                                <td> ${DTOArticulosMasComprados.canitdadParejas} </td>
                            </tr>
                        </tbody>
                    </c:forEach>
                </table>

            </div>
        </div>
        <br>
        <br>
        <br>


        <!---------------------------------------------------------------------------------------------------------------------->         
        <!------------------------- REPORTE N° 2 TOTAL FACTURADO POR TODOS LOS REGALOS DE TODAS LAS PAREJAS --------------------> 
        <!---------------------------------------------------------------------------------------------------------------------->         


        <h5 class="text-center text-primary" >Total Monto Recaudado Por artuculos vendidos</h5>

        <h6 class="text-center text-primary">${gestor.totalFacturado()}</h6>
        
        <br>
        <br>
        <br>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>

        <%@include file="Footer.jsp" %>
    </body>
</html>
