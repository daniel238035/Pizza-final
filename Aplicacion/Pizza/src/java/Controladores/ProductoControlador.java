package Controladores;

import Entidades.Acceso;
import Entidades.Ciudad;

import Entidades.Producto;
import Entidades.Usuario;
import Servicios.CiudadServicio;

import Servicios.ProductoServicio;
import Servicios.UsuarioServicio;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductoControlador {
    
    @Autowired
    private CiudadServicio ciudadServicio;
    @Autowired
    private ProductoServicio productoServicio;    
    @Autowired
    private UsuarioServicio usuarioServicio;
    
   
 
    
    //Login
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView Index() {        
        //Preguntar si está logeado        
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
    
    
    //registrar pedido
    /*@RequestMapping(value = "/registrar_pedido", method = RequestMethod.GET)
    public ModelAndView registrarPedido() {        
              
        ModelAndView mv = new ModelAndView("registrar_pedido");
        
        List<Producto> productos = productoServicio.ConsultarGeneral("");
        List<Ciudad> ciudades= ciudadServicio.obtenerCiudad("");
        
        mv.addObject("ciudades",ciudades);
        mv.addObject("productos",productos);
        
        return mv;
    }*/
    
    
    @RequestMapping(value = "/registrar_pedido", method = RequestMethod.GET)
    public ModelAndView NuevaVenta(
            HttpSession session
    ) {
        String user= (String) session.getAttribute("user");
        String rol = usuarioServicio.obtenerRol(user);
        ModelAndView modelAndView;
        System.out.println(user);
        System.out.println(rol);
        if(user!=null && rol.equals("R")){
            modelAndView = new ModelAndView("registrar_pedido");
            Usuario usuario = usuarioServicio.obtenerUsuario(user);
            List<Ciudad> ciudades = ciudadServicio.obtenerCiudad("");
            List<Producto> productos = productoServicio.ConsultarGeneral("");

            modelAndView.addObject("ciudades",ciudades);
            modelAndView.addObject("productos",productos);
            modelAndView.addObject("usuario",usuario);
        }else{
            modelAndView = new ModelAndView("index");
        }
        return modelAndView;
    }
    
    //Primer pantallazo     
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView Bienvenido(            
            @RequestParam(value="txtUser") String user,
            @RequestParam(value="txtPassword") String password,
            @RequestParam(value="cboRol") String rol
        ){               
                
        Usuario u = new Usuario();
        Acceso a = new Acceso();
        
        a.setRol(rol);
        
        u.setUser(user);
        u.setPassword(password);
        u.setoAcceso(a);
        
        Usuario usuario = usuarioServicio.Login(u);
        
        //Consultar Rol vía MySQL               
        /*
        Si operadorRegistro --> registrar_pedido
           operadorDespacho --> confirmar_pedido, despacho_pedido
           administrador --> monitoreo_ventas
           operadorSistemas --> emp_sistema        
        */

        //Logins
        ModelAndView mv;
        if(usuario != null){
            //operadorRegistro
            mv = new ModelAndView("login");            
        }else{
            mv = new ModelAndView("no");
        }          
        
        return mv;
    }        
}
