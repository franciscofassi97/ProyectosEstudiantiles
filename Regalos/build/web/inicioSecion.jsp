

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

        <h3 class="display-3 text-center">Iniciar Secion</h3>


        <form method="POST" action="inicioSecion">

            <div class="container" >

                <div class="form-group row justify-content-md-center">
                    <label for="nombre" class="col-sm-2 col-form-label">Usuario:</label>
                    <div >
                        <input type="text" class="form-control" id="txtUsuario"  name="txtUsuario" required>
                    </div>
                </div>

                <div class="form-group row justify-content-md-center">
                    <label for="pass" class="col-sm-2 col-form-label">Contraseña:</label>
                    <div>
                        <input type="password" class="form-control" id="txtPrecioArticulo"  name="txtContrasenia" required>
                    </div>
                </div>

                <div class="form-group row justify-content-md-center">
                    <div >
                        <button type="submit" class="btn btn-primary">Aceptar</button>
                    </div>
                </div>

                <div class="text-center">
                    <img src="http://www.disenadorlogotipos.es/images/logotipos/muebles-tiendas-diseno-logos-web.png"  class="rounded" alt="...">
                </div>
            </div>    
        </form>



    </body>
    <%@include file="Footer.jsp" %>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>

</html>
