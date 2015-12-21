<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Login</title>
      <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
      <link href='https://fonts.googleapis.com/css?family=Lato:400,400italic,700,700italic' rel='stylesheet' type='text/css'>
      <link rel="stylesheet" href="fonts_fontello/style.css" >
    <link rel="stylesheet" href="<c:url value="/src/Css/bootstrap.css"/>">
        <link rel="stylesheet" href="<c:url value="/src/Css/css-login.css"/>">
        <link rel='shortcut icon' href="<c:url value="/src/Imagenes/logo-final.png"/>" type='image/png'>
  </head>
  <body>

    <section class="contenedor  container-fluid">
      <section class="fila row">
        <section class="columna-izq col-xs-12 col-md-8">
          <div class="contenedor-izq container col-xs-12 col-md-8">
            <div class="row vertical-align contenedro-texto">
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
            <div class="seccion-login col-xs-12">
              <h1>Login</h1>
               <form class="formulario form" action="/Pizza/index" method="post">
                <div class="formulario-usuario form-group">
                  <label class="sr-only">Usuario</label>
                  <input type="text" class="form-control" id="usuario" placeholder="Introduce tu usuario" name="txtUsuario">
                </div>
                <div class="formulario-contraseña form-group">
                  <label class="sr-only" >Contraseña</label>
                  <input type="password" class="form-control" id="contraseña"  placeholder="Contraseña" name="txtPassword">
                </div>
                <select class="opciones form-control input-lg" name="cboRol">
                  <option value="S">Administrador del sistema</option>
                  <option value="R">Operador de recepción de pedido</option>
                  <option value="D">Operador de despacho de pedido</option>
                  <option value="A">Administrador del negocio</option>
                </select>

                <input type="submit" class="btn btn-primary btn-lg btn-block" value="INGRESAR">
              </form>
              <p class="error">${mensaje}</p>
              <div class="olvide text-center">
                <!--modifique la siguiente linea!-->
                <a href="/Pizza/recuperar.html"><h3>Olvidé mi contraseña</h3></a>
              </div>
            </div>
            <footer class="container col-xs-12">
              <h4 class="text-center">Fast Food | CopyRight 2015 </h4>
            </footer>
          </div>
        </section>
      </section>
    </section>

     <script src="<c:url value="js/jquery.js"/>"></script>
     <script src="<c:url value="js/bootstrap.js"/>"></script>
  </body>
</html>