<%-- 
    Document   : registrar_pedido
    Created on : 08-dic-2015, 11:17:31
    Author     : jr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Registrar Pedido</title>
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link href='https://fonts.googleapis.com/css?family=Lato:400,400italic,700,700italic' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="<c:url value="/src/fonts_fontello/style.css"/>"> 
    <link rel="stylesheet" href="<c:url value="/src/Css/bootstrap.css"/>">
    <link rel="stylesheet" href="<c:url value="/src/Css/css-registrar.css"/>">
    <link rel='shortcut icon' href="<c:url value="/src/Imagenes/logo-final.png"/>" type='image/png'>
  </head>
  <body>
      <div class="notificacion ${clase}">
          <p>¡Pedido Realizado!</p>
      </div>
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
               <input type="hidden" name="txtIdUsuario" value="${usuario.id}">
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
              <img src="<c:url value="/src/Imagenes/portada_registrar.png"/>" class="img-responsive">
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
                <li class="col-sm-3 col-md-3"><a class="text-center" href="/Pizza/registar_pedido">REGISTRAR PEDIDO</a></li>
                <li class="col-sm-3 col-md-3 "><a class="text-center" href="/Pizza/confirmar_pedido">CONFIRMAR PEDIDO</a></li>
                <li class="col-sm-3 col-md-3 disabled"><a class="text-center" href="#">DESPACHO PEDIDO</a></li>
                <li class="col-sm-3 col-md-3 disabled"><a class="text-center" href="#">MONITOREO VENTAS</a></li>
              </ul>
            </section>
          </nav>
        </section>
        <form action="/Pizza/pedido" method="post">
        <section class="seccion1 col-xs-12 ">
          
          <div class="container">
            <h1>DATOS DEL CLIENTE</h1>
            <section class="formulario-cont container-fluid">
             
              <div class="form-1 row" >
                <section class="form-group col-xs-12 col-md-8">
                  <label for="nom"><span class="icon-user"></span>Nombre</label>
                  <input type="text" class="form-control input-lg" name="txtCliente" placeholder="Ingresa tu nombre">
                </section>
                <section class="form-group col-xs-12 col-md-6">
                  <label for="ciud"><span class="icon-compass2"></span>Ciudad</label>
                  <select class="opciones form-control input-lg" name="cboCiudad">
                      
                      <!-- Todas las ciudades de la base de datos -->
                      <c:forEach items="${ciudades}" var="ciudad">                          
                          <option value="${ciudad.id}">${ciudad.nombre} </option>
                      </c:forEach>
                    
                   
                     <!-- Todas las ciudades de la base de datos -->
                    
                  </select>
                </section>
                <section class="form-group col-xs-12 col-md-6">
                  <label for="direc"><span class="icon-ubicacion"></span>Dirección</label>
                  <input type="text" class="form-control input-lg" name="txtDireccion" placeholder="Ingresa tu dirección">
                </section>
                <section class="form-group col-xs-12 col-md-4">
                  <label for="telef"><span class="icon-telefono"></span>Telefono</label>
                  <input type="number" class="form-control input-lg" name="txtTelefono" placeholder="Ingresa tu telefono">
                </section>
              </div>
            </section>
          </div>
        </section>
            
        <section class="seccion2 col-xs-12">
          <div class="container">
            <h1>NUESTROS PRODUCTOS</h1>
            <section class="container-fluid ">
              
                  
                  
              <!-- Cada producto sacado de la base de datos -->
              <c:set var="i" value="0"/>
              <c:set var="j" value="0"/>
              <c:set var="k" value="0"/>
               <c:forEach items="${productos}" var="producto">
              
              <section class="columna-producto col-xs-12 col-sm-6 col-md-4 ">
                <section class="">
                  <figure class="foto-producto col-xs-12">
                     
                    <img src="<c:url value="${producto.imagen}"/>"  class="img-responsive" />
                  </figure>
                  <section class="nombre-pizza col-xs-12">
                    <h2 class="text-center">${producto.nombre}</h2>
                  </section>
                  <section class="desc-pizza col-xs-12">
                    <p class="text-center">
                      ${producto.desc}
                    </p>
                  </section>
                  <section class="col-xs-12">
                    <section class="precio-pizza row">
                      <h2 class="col-xs-6">Precio:</h2>
                      <h2 class="col-xs-6 text-center">S/. ${producto.preUni}</h2>
                        <input type="hidden" id="prec${i = i + 1}" value="${producto.preUni}" onchange="calcular_subtotal();">
                    </section>
                  </section>
                  <section class="cantidad col-xs-6">
                    <div class="" >
                      <section class="form-group">
                        <label for="cantidad">Cant:</label>                        
                        <input type="number" min="0" class="form-control input-lg" id="cant${j = j + 1}" name="txtCantidad" value="0" onchange="calcular_subtotal();">
                      </section>
                    </div>
                  </section>
                  <section class="subtotal col-xs-6">
                    <div class="">
                      <section class="form-group">
                        <label for="subtotal">SubTotal:</label>
                        <input type="number" class="form-control input-lg" id="sub${k = k + 1}" name="txtSubTotal"  value="0"   readonly="">                        
                        <input type="hidden" name="txtPrecioUnitario" value="${producto.preUni}">
                        <input type="hidden" name="txtIdProducto" value="${producto.id}">
                      </section>
                    </div>
                  </section>
                </section>
              </section>
               </c:forEach>
             <!-- Cada producto sacado de la base de datos -->   
                  
            </section>
          </div>
        </section>
        <section class="seccion3 col-xs-12 ">
          <div class="container">
            <h1>MONTOS DEL PEDIDO</h1>
            <section class="formulario-cont container-fluid">
              <div class="form-3 row">
                <section class="form-group col-xs-12 col-md-6">
                  <label for="importe">Importe Total</label>
                  <input id="importe" type="text" class="form-control" name="txtImporte"  readonly="" onchange="calcular_vuelto();">
                </section>
                <section class="form-group col-xs-12 col-md-6">
                  <label for="efect">Efectivo</label>
                  <input type="number"  step="any"  class="form-control" name="txtPago" id="efectivo" value="0" onchange="calcular_vuelto();">
                </section>
                <section class="form-group col-xs-12 col-md-6">
                  <label for="vuelto">Vuelto</label>
                  <input id="vuelto" type="text" class="form-control" name="txtVuelto" readonly="">
                </section>
                <div class="col-xs-12">
                  <div class="container">
                    <input type="submit" class="boton-ing  col-xs-12 col-md-5 input-lg " name="ingresar" value="INGRESAR PEDIDO">
                    <a href="/Pizza/registrar_pedido"><input type="button" class="boton-can  col-xs-12 col-md-5 col-md-offset-1 input-lg" id="cancelar" name="cancelar" value="CANCELAR PEDIDO"></a>
                  </div>
                </div>

              </div>
            </section>
          </div>
        </section>
        </form>
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

    <!-- JQUERY AND SCRIP bootstrap -->
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="<c:url value="http://code.jquery.com/jquery-latest.js"/>"></script>
    <script src="<c:url value="/src/js/registrar_pedido.js"/>"></script>
    <script src="<c:url value="js/bootstrap.min.js"/>"></script>

    <!-- JQUERY AND SCRIP bootstrap
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script> -->
  </body>
</html>
