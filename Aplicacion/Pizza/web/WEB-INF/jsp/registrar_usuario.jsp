<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Sistema de la Empresa</title>
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link href='https://fonts.googleapis.com/css?family=Lato:400,400italic,700,700italic' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="<c:url value="/src/Css/bootstrap.css"/>">
        <link rel="stylesheet" href="<c:url value="/src/Css/css_registrar_usuario.css"/>">
        <link href="<c:url value="/src/Imagenes/logo-final.png"/>" rel='shortcut icon' type='image/png'>
    </head>
    <body>
        <section class="contenedor-total container-fluid">
        <header>
        <nav class="navegacion navbar navbar-inverse navbar-fixed-top ">
          <section class="navbar-hader">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navegador1" aria-expanded="false">
                <span class="sr-only">Menu</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#">Fast Food</a>
          </section>

          <section class="collapse navbar-collapse" id="navegador1">
            <ul class="navegador-izq nav navbar-nav navbar-right">
              <li><a href="/Pizza/perfil_usuario.html">${usuario.nom} ${usuario.ap_pat} ${usuario.ap_mat}</a></li>
              <li><a href="#">Chiclayo</a></li>
              <li role="separator" class="divider"></li>
              <li><a href="/Pizza/index">Salir</a></li>
            </ul>
          </section>
        </nav>
      </header>
      <section class="fila row">
        <section class="titulo col-xs-12">
          <h3 class="text-center">REGISTRAR USUARIO</h3>
        </section>
        <section class="imagen col-xs-12">
          <figure class="imagen_principal">
              <img src="<c:url value="/src/Imagenes/imagen-sistema2.png"/>" class="img-responsive">
          </figure>
        </section>

        <section class="paso1 col-xs-12">
          <section class="formulario-cont container-fluid">
            <form class="form-1" action="/Pizza/registrar_usuario" method="post">
              <section class="form-group">
                <label for="ape_pat">Apellido Paterno</label>
                <input type="text" class="form-control" name="ape_pat" placeholder="Escribe tu apellido paterno">
              </section>
              <section class="form-group">
                <label for="ape_mat">Apellido Materno</label>
                <input type="text" class="form-control" name="ape_mat" placeholder="Escribe tu apellido materno">
              </section>
              <section class="form-group">
                <label for="nom">Nombre</label>
                <input type="text" class="form-control" name="nom" placeholder="Escribe tu nombre">
              </section>
              <section class="form-group">
                <label for="correo">Correo Electronico</label>
                <input type="email" class="form-control" name="correo" placeholder="Escribe tu correo">
              </section>

              <h2>Roles</h2>
              <select class="roles form-control input-lg" name="cboRol">
                <option value="S">Administrador del sistema</option>
                <option value="R">Operador de recepción de pedido</option>
                <option value="D">Operador de despacho de pedido</option>
                <option value="A">Administrador del negocio</option>
              </select>
              <br>
              <br>
              <h2>Intervalo de Permiso</h2>
              <br>
              <section class="row">
                <section class="form-group col-xs-12 col-md-6">
                    <label for="tiempo1">Desde</label>
                    <input type="date" class="form-control" name="tiempoini" >
                </section>
                <section class="form-group col-xs-12 col-md-6">
                  <label for="tiempo2">Hasta</label>
                  <input type="date" class="form-control" name="tiempofin" >
                </section>
              </section>
              <input type="submit" class="form-control" name="generar_usuario" value="GENERAR USUARIO">
            </form>

          </section>
        </section>
      </section>
      <footer class="container-fluid">
        <h4 class="text-center">Fast Food | CopyRight 2015 </h4>
      </footer>

    </section>


    <!-- JQUERY AND SCRIPT bootstrap-->
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="<c:url value="/src/js/bootstrap.min.js"/> "></script>
    </body>
</html>