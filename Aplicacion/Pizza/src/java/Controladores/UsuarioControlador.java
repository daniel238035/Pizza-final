package Controladores;
import Entidades.Acceso;
import Entidades.Ciudad;
import Entidades.Pedido;
import Entidades.Producto;
import Entidades.Usuario;
import Servicios.CiudadServicio;
import Servicios.PedidoServicio;
import Servicios.ProductoServicio;
import Servicios.UsuarioServicio;
import java.sql.Date;
import java.util.List;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailParseException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("user")
public class UsuarioControlador  {
    
    @Autowired
    UsuarioServicio usuarioServicio;
    
    @Autowired
    private JavaMailSender mailSender;
    
    @Autowired
    CiudadServicio ciudadServicio;
    
    @Autowired
    ProductoServicio productoServicio;
    
    @Autowired
    PedidoServicio pedidoServicio;
    
     
     
     
    @RequestMapping(value = "/perfil_usuario", method = RequestMethod.GET)
    public ModelAndView Login(
            HttpSession sesion
    ){
        String user = (String) sesion.getAttribute("user");
        ModelAndView modelView;        
         if (user!=null) {             
             modelView = new ModelAndView("perfil_usuario");
             Usuario usuario = usuarioServicio.obtenerUsuario(user);
             modelView.addObject("usuario", usuario);
             String rol = usuarioServicio.obtenerRol(user);
             switch (rol) {
                 case "S": modelView.addObject("rol", "Administrador del sistema");break;
                 case "R": modelView.addObject("rol", "Operador de recepción de pedido");break;
                 case "D": modelView.addObject("rol", "Operador de despacho de pedido");break;
                 case "A": modelView.addObject("rol", "Administrador del negocio");break;             
             }
         }else{
             modelView = new ModelAndView("index");
         }
        return modelView;        
    }
    
    @RequestMapping(value = "/perfil_usuario", method = RequestMethod.POST)
    public ModelAndView cambiarContraseña(
            HttpSession sesion,
            HttpServletRequest parametros
    ){
        String pass = parametros.getParameter("txtPassword");
        String npass = parametros.getParameter("txtNewPassword");
        String user= (String) sesion.getAttribute("user");
        
        
        ModelAndView modelView ;
        
        Usuario usuario = usuarioServicio.obtenerUsuario(user);
        
        
        if(usuario!=null){
            
            pass = DigestUtils.md5Hex(pass);
            String aux = usuario.getPassword();            
            if (pass.equals(aux)) {
                usuario.setPassword(DigestUtils.md5Hex(npass));
                usuarioServicio.cambiarContraseña(usuario);
                modelView = new ModelAndView("index");
            }else{
                 modelView = new ModelAndView("perfil_usuario");
                usuario = usuarioServicio.obtenerUsuario(user);
                 modelView.addObject("usuario", usuario);
                 String rol = usuarioServicio.obtenerRol(user);
                 switch (rol) {
                    case "S": modelView.addObject("rol", "Administrador del sistema");break;
                    case "R": modelView.addObject("rol", "Operador de recepción de pedido");break;
                    case "D": modelView.addObject("rol", "Operador de despacho de pedido");break;
                    case "A": modelView.addObject("rol", "Administrador del negocio");break;             
                }  
                 modelView.addObject("mensaje","Contraseña incorrecta");
            }
             
        }else{
                modelView = new ModelAndView("perfil_usuario");
                usuario = usuarioServicio.obtenerUsuario(user);
                modelView.addObject("usuario", usuario);
                String rol = usuarioServicio.obtenerRol(user);
                switch (rol) {
                    case "S": modelView.addObject("rol", "Administrador del sistema");break;
                    case "R": modelView.addObject("rol", "Operador de recepción de pedido");break;
                    case "D": modelView.addObject("rol", "Operador de despacho de pedido");break;
                    case "A": modelView.addObject("rol", "Administrador del negocio");break;             
                }
        }
        
       
        return modelView;
        
    }
    
   @RequestMapping(value = "/index", method = RequestMethod.POST)
    public ModelAndView Login(
            HttpServletRequest parametros
    ) throws Exception {
        //Preguntar si está logeado        
        String txtUsuario = parametros.getParameter("txtUsuario");
        String txtPassword = parametros.getParameter("txtPassword");
        String[] cboAcceso = parametros.getParameterValues("cboRol");
        
        Usuario usuario;   
        
        
        ModelAndView mv=null;
        if (!txtUsuario.equals("") && !txtPassword.equals("")) {                
        usuario = usuarioServicio.obtenerUsuario(txtUsuario);  
            if (usuario!=null) {
               
               
               Acceso acceso = usuarioServicio.obtenerAcceso(usuario.getId());
                System.out.println(acceso.getFech_in());
                System.out.println(acceso.getFech_out());
                
                //Calcular fecha actual
                java.util.Calendar cal = java.util.Calendar.getInstance();
                java.util.Date utilDate = cal.getTime();
                java.sql.Date sqlDate = new Date(utilDate.getTime());
                //Calcular fecha actual
                
                
            
               String pass = DigestUtils.md5Hex(txtPassword);
               if(usuario.getPassword().equals(pass)){    
                   String rol = usuarioServicio.obtenerRol(txtUsuario);
                   if(cboAcceso[0].equals(rol)){   
                        if(
                        (sqlDate.after(acceso.getFech_in()) || sqlDate.equals(acceso.getFech_in())) &&
                        (sqlDate.before(acceso.getFech_out()) || sqlDate.equals(acceso.getFech_out()))
                        ){
                       
                       
                            switch (cboAcceso[0]) {
                                case "S":

                                       mv = new ModelAndView("registrar_usuario");
                                       mv.addObject("user",usuario.getUser());
                                       mv.addObject("usuario",usuario);
                                    break;
                                case "R":

                                   List<Ciudad> ciudades = ciudadServicio.obtenerCiudad("");
                                   List<Producto> productos = productoServicio.ConsultarGeneral(""); 
                                   mv = new ModelAndView("registrar_pedido");
                                   mv.addObject("ciudades",ciudades);
                                   mv.addObject("productos",productos);
                                   mv.addObject("user",usuario.getUser());
                                   mv.addObject("usuario",usuario);   

                                   break;

                                case "D":
                                    mv = new ModelAndView("despachar_pedido");        

                                    List<Pedido> pedidos = pedidoServicio.SeleccionarPedido("C");
                                    mv.addObject("usuario", usuario);
                                    mv.addObject("pedidos", pedidos);
                                    mv.addObject("user",usuario.getUser());
                                    break;
                                case "A":break;
                                default: mv = new ModelAndView("index");break;
                         }
                        }else{
                             mv = new ModelAndView("index");    
                             mv.addObject("mensaje", "Revise su fecha de acceso");
                        }
                   }else{
                       mv = new ModelAndView("index");    
                       mv.addObject("mensaje", "Rol incorrecto");
                   }
                    
               }else{
                   mv = new ModelAndView("index");    
                   mv.addObject("mensaje", "Contraseña incorrecta");
               }

            }else{
                mv = new ModelAndView("index");    
                mv.addObject("mensaje", "Usuario no existe");
            }       
        } else{
            mv = new ModelAndView("index");
            mv.addObject("mensaje", "Ingrese usuario y contraseña");
        }
        return mv;
    }
    
     
    
    
     @RequestMapping(value = "/recuperar", method = RequestMethod.GET)
    public ModelAndView Recuperar() {        
        //Preguntar si está logeado        
        ModelAndView mv = new ModelAndView("recuperar");
        return mv;
    }
    
    
    @RequestMapping(value = "/recuperar", method = RequestMethod.POST)
    public ModelAndView Recuperar(
             @RequestParam(value="correo") String correo
    ) {        
        //Recuperar contraseña       
        
        try{
        
        Usuario usuario= usuarioServicio.recuperarContraseña(correo);
        
        //Enviar correo
        if(usuario!=null){
        
            
                String cadena= "";
                
                cadena+="<html>";
                cadena+="<head>";
                cadena+="<tittle>Se le ha generado una nueva contraseña</tittle>";
                cadena+="</head>";
                cadena+="<body>";
                cadena+="<table>";
                cadena+="<tr>";
                cadena+="<td>CONTRASEÑA: "+usuario.getPassword()+ "</td>";                       
                cadena+="</tr>";
                cadena+="<tr></tr>";
                cadena+="<tr></tr>";
                cadena+="<tr></tr>";
                cadena+="<tr></tr>";
                cadena+="<tr>Gracias por usar este servicio</tr>";
                cadena+="</table>";
                cadena+="<body>";
                cadena+="</html>";
                
                

                
                MimeMessage m = mailSender.createMimeMessage();
                m.setContent(cadena,"text/html");              
		
                MimeMessageHelper helper = new MimeMessageHelper(m,true);
		                                
		helper.setFrom("pizzeriafastfood@outlook.com");
		helper.setTo(correo);
		helper.setSubject("Recuperar Contraseña ");
		helper.setText(cadena,true);
                
                //m.setHeader("Content-ID","<logo>");
                
		
                
                mailSender.send(m);
                }
	     }
             catch (MessagingException e) {
		throw new MailParseException(e);
	     }
        
        
        //Enviar correo
        
        
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
    
    
    
    
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView Index(
            HttpSession sesion
    ) {        
        sesion.removeAttribute("user");
        //Preguntar si estÃ¡ logeado        
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
    
    @RequestMapping(value = "/registrar_usuario", method = RequestMethod.GET)
    public ModelAndView Registrar_Usuario(
            HttpSession sesion, HttpServletRequest parametros            
    ) {        
        //Preguntar si estÃ¡ logeado        
        String user = (String) sesion.getAttribute("user");
        ModelAndView mv;
        String vista = parametros.getPathTranslated();
        System.out.println(vista);
        String rol = usuarioServicio.obtenerRol(user);
        if (user!=null && rol.equals("S")) {
            Usuario usuario = usuarioServicio.obtenerUsuario(user);
            mv = new ModelAndView("registrar_usuario");
            mv.addObject("usuario",usuario);
        }else{
            mv = new ModelAndView("index");
        }
        
        return mv;
    }
    
    
    
    
    @RequestMapping(value = "/registrar_usuario", method = RequestMethod.POST)
    public ModelAndView RegistrarUsuario(
           HttpServletRequest parametros, HttpSession sesion
        ){               
        String nom = parametros.getParameter("nom");
        String apePat = parametros.getParameter("ape_pat");
        String apeMat = parametros.getParameter("ape_mat");
        String correo = parametros.getParameter("correo");
        String rol[] = parametros.getParameterValues("cboRol");
        String tiempoini = parametros.getParameter("tiempoini");
        String tiempofin = parametros.getParameter("tiempofin");
        
      
        try{
            
                    Acceso a = new Acceso();
                    Usuario u = new Usuario();

                    u.setAp_mat(apeMat);
                    u.setAp_pat(apePat);       
                    u.setCorreo(correo);
                    u.setNom(nom);
                    
                    a.setRol(rol[0]);
                    
                    java.sql.Date fechaIn=java.sql.Date.valueOf(tiempoini);
                    java.sql.Date fechaFin = java.sql.Date.valueOf(tiempofin);
                    a.setFech_in(fechaIn);
                    a.setFech_out(fechaFin);
                    a.setoUsuario(u);
                   

                    String pass = usuarioServicio.RegistrarUsuario(u,a);
                    //Logins

                    //Enviar correo
              
                    
                String mensaje="";

                mensaje +=  "<html>";
                mensaje +=  "<head>";
                mensaje +=    "<meta charset='utf-8'>";
                mensaje +=    "<title>Bienvenido a Fast Food</title>";
                mensaje +=    "<link href='https://fonts.googleapis.com/css?family=Lato:400,400italic,700,700italic' rel='stylesheet' type='text/css'>";
                mensaje +=  "</head>";
                mensaje +=  "<body style='font-family:'Lato', sans-serif;'>";
                mensaje +=    "<section style='color:white; width:50%; background: #429b66; text-align:center; padding:1px 0px;'>";
                mensaje +=      "<h3>BIENVENIDO A PIZZERIA FASTFOOD</h3>";
                mensaje +=    "</section>";
                mensaje +=    "<section style='width:50%; '>";
                mensaje +=      "<p style='padding:1px;'>"+u.getNom()+" "+u.getAp_pat()+" "+u.getAp_mat()+"</p>";
                mensaje +=      "<p style='padding:3px;'>Ahora es parte del gran grupo humano de Fast Food.<br>Por consiguiente tendra acceso a nuestra aplicaciÃ³n dependiendo de su rol.</p>";
                mensaje +=      "<section style='width:30%; display:inline-block; font-weight:bold;'>USUARIO:</section>";
                mensaje +=      "<section style='width:50%; display:inline-block; '>"+u.getUser()+"</section>";
                mensaje +=      "<section style='width:30%; display:inline-block; font-weight:bold; '>CLAVE:</section>";
                mensaje +=      "<section style='width:50%; display:inline-block; '>"+pass+"</section>";
                mensaje +=      "<section style='width:100%'>";
                mensaje +=        "<h4>Ingrese al sistema:</h4>";
                mensaje +=        "<a href='#'><h4>www.pagina/pizza/login</h4></a>";
                mensaje +=      "</section>";
                mensaje +=    "</section>";
                mensaje +=  "</body>";
                mensaje += "</html>";
                
                
                MimeMessage m = mailSender.createMimeMessage();
                m.setContent(mensaje,"text/html");              
		
                MimeMessageHelper helper = new MimeMessageHelper(m,true);
		
		helper.setFrom("pizzeriafastfood@outlook.com");
		helper.setTo(u.getCorreo());
		helper.setSubject("Bienvenido Usuario "+u.getNom() );
		helper.setText(mensaje,true);
                
                //m.setHeader("Content-ID","<logo>");
                
		
                
                mailSender.send(m);
                
	     }
             catch (MessagingException e) {
		
	     }
        //Enviar correo
        
        
        ModelAndView mv = new ModelAndView("index");          
        
        return mv;
    }
       
}
