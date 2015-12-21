/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import Entidades.Ciudad;
import Entidades.DetallePedido;
import Entidades.Pedido;
import Entidades.Producto;
import Entidades.Usuario;
import Servicios.CiudadServicio;
import Servicios.PedidoServicio;
import Servicios.ProductoServicio;
import Servicios.UsuarioServicio;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author daniel
 */
@Controller
public class PedidoControlador {
    @Autowired
    private PedidoServicio pedidoServicio;
    
    @Autowired
    private UsuarioServicio usuarioServicio;
    
    @Autowired
    private CiudadServicio ciudadServicio;
    
    @Autowired
    private ProductoServicio productoServicio;
    
    @RequestMapping(value = "/pedido", method = RequestMethod.POST)
    public ModelAndView Pedido(HttpServletRequest parametros, HttpSession sesion) throws Exception {
        String cliente = parametros.getParameter("txtCliente");
        String direccion = parametros.getParameter("txtDireccion");
        String telefono = parametros.getParameter("txtTelefono");
        double importe = Double.parseDouble(parametros.getParameter("txtImporte"));
        double pago = Double.parseDouble(parametros.getParameter("txtPago"));
        double vuelto = Double.parseDouble(parametros.getParameter("txtVuelto"));
        
        String[] txtIdProducto = parametros.getParameterValues("txtIdProducto");
        String[] txtCantidad = parametros.getParameterValues("txtCantidad");
        String[] txtPrecioUnitario=parametros.getParameterValues("txtPrecioUnitario");
        String[] cboCiudad=parametros.getParameterValues("cboCiudad");
      
        String user = (String) sesion.getAttribute("user");
      
        Usuario usuario = usuarioServicio.obtenerUsuario(user);
        int id = usuario.getId();
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setDireccion(direccion);
        pedido.setTelf(telefono);
        pedido.setImporte(importe);
        pedido.setPago(pago);
        pedido.setVuelto(vuelto);
        pedido.setEstado("P");  
        pedido.setoUsuario(new Usuario(id));
        pedido.setoCiudad(new Ciudad(Integer.parseInt(cboCiudad[0])));
        
        List<DetallePedido> lDetallePedido = new ArrayList();
        
        DetallePedido odetalle;
        
        for (int i = 0; i < txtIdProducto.length; i++) {
            if (!txtCantidad[i].isEmpty() && Double.parseDouble(txtCantidad[i])>0) {
                odetalle = new DetallePedido();
                odetalle.setCant(Double.parseDouble(txtCantidad[i]));
                odetalle.setPreUni(Double.parseDouble(txtPrecioUnitario[i]));
                odetalle.setSubTotal(Double.parseDouble(txtCantidad[i])*Double.parseDouble(txtPrecioUnitario[i]));
                odetalle.setoProducto(new Producto(Integer.parseInt(txtIdProducto[i])));
                lDetallePedido.add(odetalle);
            }            
        }
        
        pedido.setlDetallePedido(lDetallePedido);
        pedidoServicio.registrarPedido(pedido);
        ModelAndView modelAndView = new ModelAndView("registrar_pedido");
        List<Ciudad> ciudades = ciudadServicio.obtenerCiudad("");
        List<Producto> productos = productoServicio.ConsultarGeneral(""); 
        
        modelAndView.addObject("ciudades",ciudades);
        modelAndView.addObject("productos",productos);
        modelAndView.addObject("usuario",usuario);   
        modelAndView.addObject("clase","correcto");
        
        return modelAndView;
    }   
    
    
    @RequestMapping(value = "/modificar", method = RequestMethod.POST)
    public ModelAndView Modificar(HttpServletRequest parametros, HttpSession sesion) throws Exception {
        String cliente = parametros.getParameter("txtCliente");
        String direccion = parametros.getParameter("txtDireccion");
        String telefono = parametros.getParameter("txtTelefono");
        double importe = Double.parseDouble(parametros.getParameter("txtImporte"));
        double pago = Double.parseDouble(parametros.getParameter("txtPago"));
        double vuelto = Double.parseDouble(parametros.getParameter("txtVuelto"));
        int idpedido = Integer.parseInt(parametros.getParameter("idpedido"));
        
        String[] txtIdProducto = parametros.getParameterValues("txtIdProducto");
        String[] txtCantidad = parametros.getParameterValues("txtCantidad");
        String[] txtPrecioUnitario=parametros.getParameterValues("txtPrecioUnitario");
        String[] cboCiudad=parametros.getParameterValues("cboCiudad");
      
        String user = (String) sesion.getAttribute("user");
        System.out.println(idpedido);
        Usuario usuario = usuarioServicio.obtenerUsuario(user);
        int id = usuario.getId();
        Pedido pedido = new Pedido();
        pedido.setId(idpedido);
        pedido.setCliente(cliente);
        pedido.setDireccion(direccion);
        pedido.setTelf(telefono);
        pedido.setImporte(importe);
        pedido.setPago(pago);
        pedido.setVuelto(vuelto);
        pedido.setEstado("C");  
        pedido.setoUsuario(new Usuario(id));
        pedido.setoCiudad(new Ciudad(Integer.parseInt(cboCiudad[0])));
        
        List<DetallePedido> lDetallePedido = new ArrayList();
        
        DetallePedido odetalle;
        
        for (int i = 0; i < txtIdProducto.length; i++) {
            if (!txtCantidad[i].isEmpty() && Double.parseDouble(txtCantidad[i])>0) {
                odetalle = new DetallePedido();
                odetalle.setCant(Double.parseDouble(txtCantidad[i]));
                odetalle.setPreUni(Double.parseDouble(txtPrecioUnitario[i]));
                odetalle.setSubTotal(Double.parseDouble(txtCantidad[i])*Double.parseDouble(txtPrecioUnitario[i]));
                odetalle.setoProducto(new Producto(Integer.parseInt(txtIdProducto[i])));
                lDetallePedido.add(odetalle);
            }            
        }
        
        pedido.setlDetallePedido(lDetallePedido);
        pedidoServicio.modificarPedido(pedido);
        ModelAndView modelAndView = new ModelAndView("registrar_pedido");
        List<Ciudad> ciudades = ciudadServicio.obtenerCiudad("");
        List<Producto> productos = productoServicio.ConsultarGeneral(""); 
        
        modelAndView.addObject("ciudades",ciudades);
        modelAndView.addObject("productos",productos);
        modelAndView.addObject("usuario",usuario);   
  
        
        return modelAndView;
    }   
    
    
    @RequestMapping(value = "/confirmar_pedido", method = RequestMethod.GET)
    public ModelAndView Index(HttpSession session) {
        //ID User
        String user = (String)session.getAttribute("user");
        
        ModelAndView mv;
        if(user!=null){
        Usuario usuario = usuarioServicio.obtenerUsuario(user);
        mv = new ModelAndView("confirmar_pedido");        
        
        List<Pedido> pedidos = pedidoServicio.SeleccionarPedido("P");
        
        mv.addObject("usuario", usuario);
        mv.addObject("pedidos", pedidos);
        }        
        else{
            mv= new ModelAndView("index");
        }
        return mv;
    }
    
    @RequestMapping(value = "/despachar_pedido", method = RequestMethod.GET)
    public ModelAndView Despachar(HttpSession session) {
        //ID User
        String user = (String)session.getAttribute("user");
        
        ModelAndView mv;
        if(user!=null){
        Usuario usuario = usuarioServicio.obtenerUsuario(user);
        mv = new ModelAndView("despachar_pedido");        
        
        List<Pedido> pedidos = pedidoServicio.SeleccionarPedido("C");
        
        mv.addObject("usuario", usuario);
        mv.addObject("pedidos", pedidos);
        }        
        else{
            mv= new ModelAndView("index");
        }
        return mv;
    }
    
    
    @RequestMapping(value = "/confirmar_pe", method = RequestMethod.GET)
    public ModelAndView ConfirmarConId(
            HttpSession session,
            @RequestParam(value="id") String id) {
                
        //Username
        String user = (String)session.getAttribute("user");
        
        ModelAndView mv;
        
        if(user != null){
            Usuario usuario = usuarioServicio.obtenerUsuario(user);
            
            mv = new ModelAndView("confirmar_pedido");
        
        //Id
        Integer Id = Integer.parseInt(id);        
        pedidoServicio.UpdateEstadoPedido(Id);
        
        List<Pedido> pedidos = pedidoServicio.SeleccionarPedido("P");                
       
        mv.addObject("usuario", usuario);
        mv.addObject("pedidos", pedidos);
        }        
        else{
            mv= new ModelAndView("index");
        }
        return mv;
    }
    
    
    @RequestMapping(value = "/despachar_pe", method = RequestMethod.GET)
    public ModelAndView DespacharConId(
            HttpSession session,
            @RequestParam(value="id") String id) {
                
        //Username
        String user = (String)session.getAttribute("user");
        
        ModelAndView mv;
        
        if(user != null){
            Usuario usuario = usuarioServicio.obtenerUsuario(user);
            
            mv = new ModelAndView("despachar_pedido");
        
        //Id
        Integer Id = Integer.parseInt(id);        
        pedidoServicio.despacharEstadoPedido(Id);
        
        List<Pedido> pedidos = pedidoServicio.SeleccionarPedido("C");                
       
        mv.addObject("usuario", usuario);
        mv.addObject("pedidos", pedidos);
        }        
        else{
            mv= new ModelAndView("index");
        }
        return mv;
    }
    
            
            
    @RequestMapping(value = "/cancelar_pedido", method = RequestMethod.GET)
    public ModelAndView CancelarConId(
            HttpSession session,
            @RequestParam(value="id") String id) {
                
        //Username
        String user = (String)session.getAttribute("user");
        
        ModelAndView mv;
        
        if(user != null){
            Usuario usuario = usuarioServicio.obtenerUsuario(user);
            
            mv = new ModelAndView("confirmar_pedido");
        
        //Id
        Integer Id = Integer.parseInt(id);        
        pedidoServicio.anularEstadoPedido(Id);
        
        List<Pedido> pedidos = pedidoServicio.SeleccionarPedido("P");                
       
        mv.addObject("usuario", usuario);
        mv.addObject("pedidos", pedidos);
        }        
        else{
            mv= new ModelAndView("index");
        }
        return mv;
    }
    
    
    @RequestMapping(value = "/modificar_pe", method = RequestMethod.GET)
    public ModelAndView modificar(HttpSession session, HttpServletRequest parametros){
        String user = (String) session.getAttribute("user");
        String id= parametros.getParameter("id");
        Pedido pedido = pedidoServicio.obtenerPorId(Integer.parseInt(id));
        ModelAndView mv = new ModelAndView("modificar_pedido");
        Usuario usuario = usuarioServicio.obtenerUsuario(user);
        List<Ciudad> ciudades = ciudadServicio.obtenerCiudad("");
        List<Producto> productos = productoServicio.ConsultarGeneral("");

        mv.addObject("ciudades",ciudades);
        mv.addObject("pedido",pedido);
        mv.addObject("productos",productos);
        mv.addObject("usuario",usuario);
        return mv;
    }

    
    }
    
   