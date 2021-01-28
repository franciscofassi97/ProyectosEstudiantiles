<%-- 
    Document   : altaPareja
    Created on : 1 nov. 2020, 19:49:01
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <%@include file="Menu.jsp" %>
    <body>

        <h3 class="display-3 text-center">Inscripcion De Parejas </h3>
        <form method="POST" action="altaPareja">
            <div class="container">
                
                    <div class="form-group">
                        <label for="nombrePareja">Nombre:</label>
                        <input type="text" class="form-control" id="nombrePareja" aria-describedby="nombreEjemplo" name="nombrePareja">
                        <small id="nombreEjemplo" class="form-text text-muted">Ingresen los nombres EJ: Lucas y Ana</small>
                    </div>
                

                
                    <div class="form-group">
                        <label for="fechaPareja">Fecha:</label>
                        <input type="date" class="form-control" id="fechaPareja" name="fechaPareja" required>

                    </div>
                
                
                    <div class="form-group">
                        <label for="telefonoPareja">Telefono de Contacto:</label>
                        <input type="text" class="form-control" id="TelefonoPareja" name="telefonoPareja" required>
                        <small id="nombreEjemplo" class="form-text text-muted">3525-4380156</small>
                    </div>
                   
                 
                    <div class="form-group">
                        <label for="direccionPareja">Direccion:</label>
                        <input type="text" class="form-control" id="DireccionPareja"  name="direccionPareja" required>
                    </div>
                

                <div class="row row justify-content-md-center"> 
                    <button type="submit" class="btn btn-primary " value= "Alta pareja">Aceptar</button>
                </div>
            </div>  
            <input type="hidden" name="txtEstadoPareja" value="1" />
        </form>
    </body>

    <%@include file="Footer.jsp" %>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>

</html>
