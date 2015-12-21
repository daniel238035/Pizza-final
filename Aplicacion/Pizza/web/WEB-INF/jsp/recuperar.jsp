<%-- 
    Document   : recuperar
    Created on : 13/12/2015, 09:49:13 AM
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang ="es">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link href='https://fonts.googleapis.com/css?family=Lato:400,400italic,700,700italic' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="<c:url value="/src/Css/bootstrap.css"/>">
    <link rel="stylesheet" href="<c:url value="/src/Css/css-recuperar.css"/>">
    <link rel='shortcut icon' href="<c:url value="/src/Imagenes/logo-final.png"/>" type='image/png'>
  </head>

  <body>
    <section class="contenedor  container-fluid">
      <section class="fila row">
        <section class="columna-izq col-xs-12 col-md-8">
          <div class="contenedor-izq container col-xs-12 col-md-8">
            <div class="row vertical-align">
              <p class="col-xs-12 texto1">"10 AÑOS llevando la </p>
              <p class="col-xs-12 texto2">mejor pizza hasta donde estès"</p>
            </div>
          </div>
        </section>
        <section class="columna-der col-xs-12 col-md-3">
          <div class="contenedor-der row ">
            <div class="logo col-xs-12">
              <figure class="imagen_logo">
                  <img src="<c:url value="/src/Imagenes/logo-final.png"/>" class="img-responsive">
              </figure>
            </div>
            <div class="seccion-recuperar col-xs-12">
              <h1>Recuperar Contraseña</h1>
              <form class="formulario form" action="/Pizza/recuperar" method="post">
                <div class="form-group has-success has-feedback contenedor-correo">
                  <div class="input-group">
                    <span class="input-group-addon">@</span>
                    <input type="text" class="form-control" id="inputGroupSuccess4" style="margin:0" placeholder="e-mail" name="correo">
                  </div>
                  <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                  <span id="inputGroupSuccess4Status" class="sr-only">(success)</span>
                </div>
                <input type="submit" class="btn btn-primary btn-lg btn-block boton-enviar " value="ENVIAR">
                <a href="/Pizza/index.html"><input type="button" class="btn btn-primary btn-lg btn-block boton-login" value="LOGIN"></a>
              </form>
            </div>
            <footer class="container col-xs-12">
              <h4 class="text-center">Fast Food | CopyRight 2015 </h4>
            </footer>
          </div>
        </section>
      </section>
    </section>

    <script type="js/jquery.js"></script>
    <script type="js/bootstrap.js"></script>
  </body>

</html>
