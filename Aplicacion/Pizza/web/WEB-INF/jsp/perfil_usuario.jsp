<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Perfil de Usuario</title>
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link href='https://fonts.googleapis.com/css?family=Lato:400,400italic,700,700italic' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="<c:url value="/src/fonts_fontello/style.css"/>" >
    <link rel="stylesheet" href="<c:url value="/src/Css/bootstrap.css"/>">
    <link rel="stylesheet" href="<c:url value="/src/Css/css_perfil_usuario.css"/>">
    <link href="<c:url value='/src/Imagenes/logo-final.png'/>" rel='shortcut icon' type='image/png'>
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
              <li><a href="perfil_usuario"> ${usuario.nom} ${usuario.ap_pat} ${usuario.ap_mat}</a></li>
              <li><a href="#">Chiclayo</a></li>
              <li role="separator" class="divider"></li>
              <li><a href="/Pizza/index">Salir</a></li>
            </ul>
          </section>
        </nav>
      </header>
      <section class="fila row">
        <section class="titulo col-xs-12">
          <h3 class="text-center">MI PERFIL DE USUARIO</h3>
        </section>
        <section class="imagen col-xs-12">
          <figure class="imagen_principal">
              <img src="<c:url value="/src/Imagenes/portada_perfil_usuario.png"/>" class="img-responsive">
          </figure>
        </section>
        <section class="seccion1 col-xs-12">
          <form class="" action="/Pizza/perfil_usuario" method="post">
            <section class="datos container">

            <div class="form-1" action="" method="post">
              <section class="col-xs-12">
                <h3>Mis Datos Personales</h3>
                <section class="form-group col-xs-12">
                  <label class="col-sm-2 control-label">Nombre</label>
                  <div class=" cuadro col-sm-10">
                    <p class="form-control-static">${usuario.nom}</p>
                  </div>
                </section>

                <section class="form-group col-xs-12">
                  <label class="col-sm-2 control-label">Apellidos</label>
                  <div class=" cuadro col-sm-10">
                    <p class="form-control-static">${usuario.ap_pat} ${usuario.ap_mat}</p>
                  </div>
                </section>
              </section>
              <section class="col-xs-12">
                <h3>Mi Función en la Empresa</h3>
                <section class="form-group col-xs-12">
                  <label class="col-sm-2 control-label">Rol en la Empresa</label>
                  <div class="cuadro col-sm-10">
                    <p class="form-control-static">${rol}</p>
                  </div>
                </section>
                <section class="form-group col-xs-12">
                  <label class="col-sm-2 control-label">Intervalo de tiempo</label>
                  <div class="cuadro col-sm-10">
                    <p class="form-control-static">10-agos-2015 - 15-sep-2016</p>
                  </div>
                </section>
              </section>
              <section class="col-xs-12">
                <h3>Mi Cuenta</h3>
                <section class="form-group col-xs-12">
                  <label class="col-sm-2 control-label">Usuario</label>
                  <div class="cuadro col-sm-10">
                    <p class="form-control-static">${usuario.user}</p>
                  </div>
                </section>
              </section>

            </div>
            <section class="col-xs-12">

            <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
              <div class="panel panel-default">
                <div class="panel-titulo panel-heading " role="tab" id="headingOne">
                  <h4 class="panel-title ">
                    <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                      Cambiar mi Contraseña
                    </a>
                  </h4>
                </div>
                <div id="collapseOne" class="panel panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                  <div class="panel-cuerpo panel-body">
                    <h5 class="col-xs-12">Si deseas cambiar tu contraseña, primero tendras que ingresar la contraseña actual</h5>
                    <div class="form-group col-xs-12">
                      <label for="inputPassword" class="col-sm-2 control-label">Contraseña Actual</label>
                      <div class=" col-xs-10 col-sm-6">
                        <input type="password" class="form-control" id="inputPassword" placeholder="Contraseña" name="txtPassword">
                        <p class="error">${mensaje}</p>
                      </div>
                    </div>
                    <div class="form-group col-xs-12">
                      <label for="inputPassword" class="col-sm-2 control-label">Nueva Contraseña</label>
                      <div class=" col-xs-10 col-sm-6">
                        <input type="password" class="form-control" id="inputPassword" placeholder="Nueva Contraseña" name="txtNewPassword">
                      </div>
                    </div>
                    <button type="submit" class=" btn-confirmar col-xs-12 btn ">CONFIRMAR</button>
                  </div>

                </div>
              </div>
            </div>

            </section>
          </section>

          </form>
        </section>
        </section>

      </section>

      <footer class="container-fluid">
        <div class="container text-center">
          <span class="icon-facebook2"></span>
          <span class="icon-twitter2"></span>
          <h4 class="">Fast Food | CopyRight 2015 </h4>
          <span class="icon-youtube"></span>
          <span class="icon-github3"></span>
        </div>
      </footer>

    </section>


  <!-- JQUERY AND SCRIP bootstrap-->
  <script src="<c:url value="http://code.jquery.com/jquery-latest.js"/>"></script>
  <script src="<c:url value="/src/js/bootstrap.min.js"/>"></script>
  </body>
</html>
