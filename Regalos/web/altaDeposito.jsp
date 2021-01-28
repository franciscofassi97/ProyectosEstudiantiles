<%-- 
    Document   : altaDeposito
    Created on : 1 nov. 2020, 22:04:14
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <%@include file="Menu.jsp" %>
    
    <body>
        

        <h3 class="display-4 text-center">Alta Deposito </h3>
        <form method="POST" action="altaDeposito">
            <div class="container">


                <div class="md-form mt-0">
                    <label for="cboPareja">Parejas:</label>
                    <select class="form-control"  name="cboPareja" >

                        <c:forEach var="p" items="${listaComboParejas}">
                            <option value="${p.idPareja}">${p.nombrePareja}
                            </c:forEach>
                    </select>
                </div>
                
                <div class="form-group">
                    <label for="fecha">Fecha:</label>
                    <input type="date" class="form-control" id="txtFecha" name="txtFecha" required>

                </div>

                <div class="form-group">
                    <label for="nombreInvitado">Nombre Invitado:</label>
                    <input type="text" class="form-control" id="txtNombre" aria-describedby="nombreEjemplo" name="txtNombreInvitado" required>
                    
                </div>

                <div class="form-group">
                    <label for="Direccion">Direccion Invitado:</label>
                    <input type="text" class="form-control" id="txtDireccion" name="txtDireccion" required>
                    
                </div>

                <div class="form-group">
                    <label for="contacto">Telefono: </label>
                    <input type="text" class="form-control" id="txtContacto"  name="txtContacto" required>
                </div>
                
                
                <div class="form-group">
                    <label for="Deposito">Monto a Depositar: </label>
                    <input type="text" class="form-control" id="txtDeposito"  name="txtDeposito" required>
                </div>

                <div class="row row justify-content-md-center"> 
                    <button type="submit" class="btn btn-primary " value= "Alta Deposito">Aceptar</button>
                </div>
            </div>    
        </form>


    </body>
    <%@include file="Footer.jsp" %>
</html>
