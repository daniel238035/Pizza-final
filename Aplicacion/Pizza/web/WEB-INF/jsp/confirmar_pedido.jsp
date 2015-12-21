<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Confirmar Pedido</title>
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link href="https://fonts.googleapis.com/css?family=Lato:400,400italic,700,700italic" rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="<c:url value="/src/fonts_fontello/style.css"/>">
        <link rel="stylesheet" href="<c:url value="/src/Css/bootstrap.css"/>">
        <link rel="stylesheet" href="<c:url value="/src/Css/css_confirmar.css"/>">
        <link rel='shortcut icon' href="<c:url value="/src/Imagenes/logo-final.png"/>" type='image/png'>       
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
              <li><a href="/Pizza/index.html">Salir</a></li>
            </ul>
          </section>
        </nav>
      </header>
      <section class="fila row">
        <section class="imagen col-xs-12">
          <figure class="imagen_principal">
              <img src="<c:url value="/src/Imagenes/portada_confirmar.png"/>" class="img-responsive">
          </figure>
        </section>
        <section class="navegador2 col-xs-12 col-sm-12">
          <nav class="navegacion2_sub navbar navbar-inverse">
            <section class="navbar-hader">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navegador2" aria-expanded="false">
                  <span class="sr-only">Menu</span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#"></a>
            </section>

            <section class=" collapse navbar-collapse " id="navegador2">
              <ul class=" row navegador-acciones nav  nav-justified">
                <li class="col-sm-3 col-md-3"><a class="text-center" href="/Pizza/registrar_pedido">REGISTRAR PEDIDO</a></li>
                <li class="col-sm-3 col-md-3"><a class="text-center" href="/Pizza/confirmar_pedido">CONFIRMAR PEDIDO</a></li>
                <li class="col-sm-3 col-md-3 disabled"><a class="text-center" href="#">DESPACHO PEDIDO</a></li>
                <li class="col-sm-3 col-md-3 disabled"><a class="text-center" href="#">MONITOREO VENTAS</a></li>
              </ul>
            </section>
          </nav>
        </section>
        <section class="seccion1 col-xs-12">
          <div class="container">
            <h1>PEDIDOS RECEPCIONADOS</h1>
            <!-- BOTONES OPCIONALES
            <section class="botones-opciones container-fluid">
              <div class="btn-group btn-group-justified" role="group" aria-label="...">
                <div class="btn-group" role="group">
                  <button type="button" class="btn btn-success"><span class="icon-checkmark"></span>CONFIRMAR</button>
                </div>
                <div class="btn-group" role="group">
                  <button type="button" class="btn btn-danger"><span class="icon-bin"></span>CANCELAR</button>
                </div>
                <div class="btn-group" role="group">
                  <button type="button" class="btn btn-warning"><span class="icon-pencil2"></span>EDITAR</button>
                </div>
              </div>
            </section> -->


            <section class="tabla-cont container-fluid">
              <div class="panel panel-default">
                <div class="table-responsive">
                  <table class="table  table-bordered table-hover table-condensed">
                    <tr class="active">
                      <th>Ver</th>
                      <th>N° Pedido</th>
                      <th>Fecha y Hora</th>
                      <th>Cliente</th>
                      <th>Dirección</th>
                      <th>Telefono</th>
                      <th>Importe</th>
                      <th>Efectivo</th>
                      <th>Estado</th>
                    </tr>
                    
                    <c:forEach items="${pedidos}" var="pedido">
                    <tr>
                      <td>
                        <div class="btn-group" role="group">
                          <a href="#ventana-emergente${pedido.id}" data-toggle="modal"><button type="button" class="btn btn-warning"><span class="icon-plus"></span></button></a>
                        </div>
                      </td>
                      <td>${pedido.id}</td>
                      <td>${pedido.fech_hor}</td>
                      <td>${pedido.cliente}</td>
                      <td>${pedido.direccion}</td>
                      <td>${pedido.telf}</td>
                      <td>${pedido.importe}</td>
                      <td>${pedido.pago}</td>
                      <td class="${pedido.estado == "P"?"alert alert-warning":
                            pedido.estado == "C"?"alert alert-success":
                            pedido.estado == "A"?"alert alert-danger":""}">${pedido.estado == "P"?"Por Confirmar":
                            pedido.estado == "C"?"Confirmado":
                            pedido.estado == "A"?"Anulado":""}</td>
                    </tr>
                    </c:forEach>                    
                </table>
                </div>
              </div>
            </section>


            <!-- VENTANA EMERGENTE-->
            <c:forEach items="${pedidos}" var="pedido">
            <div class="modal fade" id="ventana-emergente${pedido.id}">
              <div class="modal-dialog">
                <div class="modal-content">
                  <!-- HEDADER DE MI VENTANA-->
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="icon-cross"></span></button>
                    <h4 class="modal-title">PEDIDO</h4>
                  </div>

                  <!-- BODY DE MI VENTANA-->
                  <div class="modal-body">
                    <section class="container-fluid">
                      <section class="row">
                        <section class="col-xs-12">
                          <h5 class="col-xs-3">N° Pedido:</h5>
                          <h5 class="col-xs-9">${pedido.id}</h5>
                        </section>
                        <section class="col-xs-12">
                          <h5 class="col-xs-3">Nombre:</h5>
                          <h5 class="col-xs-9">${pedido.cliente}</h5>
                          <h5 class="col-xs-3">Ciudad:</h5>
                          <h5 class="col-xs-9">${pedido.oCiudad.nombre}</h5>
                          <h5 class="col-xs-3">Dirección:</h5>
                          <h5 class="col-xs-9">${pedido.direccion}</h5>
                        </section>
                        <section class="col-xs-12">
                          <h5>Detalle del Pedido</h5>
                          <div class="panel panel-default">
                            <div class="table-responsive">
                              <table class="table table-border table-hover">
                                <tr class="active">
                                  <th>Producto</th>
                                  <th>Cantidad</th>
                                  <th>Precio Unit</th>
                                  <th>Sub Total</th>
                                </tr>
                                <c:forEach items="${pedido.lDetallePedido}" var="detallePedido">
                                <tr>
                                  <td>${detallePedido.oProducto.nombre}</td>
                                  <td>${detallePedido.cant}</td>
                                  <td>${detallePedido.preUni}</td>
                                  <td>${detallePedido.subTotal}</td>
                                </tr>
                                </c:forEach>
                              </table>
                            </div>
                          </div>
                        </section>
                        <section class="col-xs-12">
                            <h5 class="col-xs-3">Importe:</h5>
                            <h5 class="col-xs-9">${pedido.importe}</h5>
                            <h5 class="col-xs-3">Efectivo:</h5>
                            <h5 class="col-xs-9">${pedido.pago}</h5>
                            <h5 class="col-xs-3">Vuelto:</h5>
                            <h5 class="col-xs-9">${pedido.vuelto}</h5>
                        </section>
                      </section>
                    </section>
                  </div>

                  <!-- FOOTER DE MI VENTANA-->
                  <div class="modal-footer">
                    <div class="btn-group btn-group-justified" role="group" aria-label="...">
                        <div class="btn-group" role="group">
                            <a href="/Pizza/confirmar_pe?id=${pedido.id}" type="button" class="btn btn-success"><span class="icon-checkmark"></span>CONFIRMAR</a>
                        </div>
                        <div class="btn-group" role="group">
                            <a href="/Pizza/cancelar_pedido?id=${pedido.id}" type="button" class="btn btn-danger"><span class="icon-bin"></span>CANCELAR</a>
                        </div>
                        <div class="btn-group" role="group">
                            <a href="/Pizza/modificar_pe?id=${pedido.id}" type="button" class="btn btn-warning"><span class="icon-pencil2"></span>EDITAR</button></a>
                        </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            </c:forEach>

        </div>
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

    <!-- JQUERY AND SCRIPT bootstrap -->
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="<c:url value="/src/js/bootstrap.min.js"/> "></script>
    </body>
</html>