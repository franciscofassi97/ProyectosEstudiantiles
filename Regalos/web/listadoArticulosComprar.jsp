<%-- 
    Document   : listadoArticulosComprar
    Created on : 4 nov. 2020, 17:54:59
    Author     : Usuario
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="gestorRegalos" scope="request" class="GestorBD.GestorRegalos" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    </head>

    <%@include file="Menu.jsp" %>

    <body>
        <h4 class="display-4 text-center text-primary">Relice Su Compra</h4>
        <div class="container"> 
            <div class="row justify-content-md-center">
                <form method="POST" action="realizarDetalleCompra">

                    <table class="table table-bordered table-hover">

                        <thead>
                            <tr>
                                <th scope="col" class="text-center text-primary font-weight-normal">Nombre Articulos</th>
                                <th scope="col" class="text-center text-primary font-weight-normal">Precio Articulos</th>
                                <th scope="col" class="text-center text-primary font-weight-normal"></th>
                            </tr>

                        </thead>


                        <c:forEach items="${gestorRegalos.listaArticulos()}" var = "articulo"  >
                            <tr>
                                <td> ${articulo.nombreArticulo} </td>
                                <td> ${articulo.precioArticulo} </td>

                                <td><button type="submit" class="btn btn-primary" value="${articulo.idArticulo}" name="txtIdArticulo">RealizarCompra</button></td>

                            </tr>
                        </c:forEach>

                        <input type="hidden" name="txtIdCompra" value="${txtIdCompra}"/> 

                        <input type="hidden" name="txtIdPareja" value="${txtIdPareja}"/>

                        <label>Suma total de Sus Depositos: ${gestorRegalos.totalDeposito(txtIdPareja)}</label>
                        <br>

                        <label> Monto: ${monto}</label>
                        <br>
                        <label>Su saldo no es suficiente le corresponden o puede seguir comprando: ${vuelto}</label>

                    </table>
                    <br>
                    <br>

                </form>

            </div>                    
        </div>                

        <h6 class="display-6 text-center text-info">Su compra</h6>    
        <div class="container"> 
            <div class="row justify-content-md-center">

                <table class="table table-bordered table-hover"> 
                    <thead>
                        <tr>
                            <th scope="col" class="text-center text-primary font-weight-normal">Numero Compra</th>
                            <th scope="col" class="text-center text-primary font-weight-normal">Articulo</th>
                            <th scope="col" class="text-center text-primary font-weight-normal">Precio</th>
                        </tr>

                    </thead>
                    <c:forEach items="${gestorRegalos.obtenerListaDeCompra(txtIdCompra)}" var = "compra"  >
                        <tr>
                            <td> ${compra.idCompra} </td>
                            <td> ${compra.nombreArticulo} </td>
                            <td> ${compra.precioArticulo} </td>


                        </tr>
                    </c:forEach>

                </table>
            </div>    
            <div class="container">
                <div class="row justify-content-md-center">
            <a class="btn-primary" href="/Regalos/principal.jsp">Terminar Compra</a>
            </div>    
            </div>


            <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>

    </body>
    <%@include file="Footer.jsp" %>
</html>
