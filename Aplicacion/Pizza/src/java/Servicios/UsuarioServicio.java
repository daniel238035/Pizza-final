package Servicios;

import Entidades.Acceso;
import Entidades.Usuario;
import Mapeadores.AccesoMapeador;
import Mapeadores.UsuarioMapeador;
import javax.transaction.Transactional;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio {
    @Autowired
    private UsuarioMapeador usuarioMapeador;
    
    @Autowired
    private AccesoMapeador accesoMapeador;
    
    public Usuario Login(Usuario u) {
        u.setPassword(DigestUtils.md5Hex(u.getPassword()));
        Usuario user = usuarioMapeador.SeleccionarUsuario(u);        
        return user;
    }
    
   public String obtenerRol(String user){
       return accesoMapeador.seleccionarRol(user);
   }
   
  
   
   public Usuario obtenerUsuario(String user){
       return usuarioMapeador.seleccionarPorUser(user);
   }
   
   public void cambiarContraseña(Usuario usuario){
       usuarioMapeador.cambiarContraseña(usuario);
   }
   
   public Acceso obtenerAcceso(Integer Id){
       return accesoMapeador.obtenerAcceso(Id);
   }
   
    public Usuario recuperarContraseña(String correo){
        Usuario usuario = usuarioMapeador.seleccionarUsuarioPorCorreo(correo);
        if(usuario!=null){
            String pass="";       
            int tam=12;
            for (int i = 0; i < tam; i++) {
                pass +=(char)(Math.random()*94+33);
            }         
            String encr;
            encr = DigestUtils.md5Hex(pass);
            usuario.setPassword(encr);
            usuario.setCorreo(correo);
            usuarioMapeador.ModificarContraseña(usuario);
            usuario.setPassword(pass);
        }
        return usuario;
    }
    
    
    @Transactional(rollbackOn = {RuntimeException.class,Exception.class})
    public String RegistrarUsuario(Usuario ousuario, Acceso acceso){
         int tam=12;
        String pass="";
        for (int i = 0; i < tam; i++) {
            pass +=(char)(Math.random()*94+33);
        } 
        
        int max = usuarioMapeador.seleccionarMaxID();
        
        String auxmax= String.valueOf(max);
        int tamid = auxmax.length();
        String cad="";
        for (int i = 0; i <4-tamid; i++) {
            cad += "0";
        }
        max+=1;
        cad+= String.valueOf(max);
        ousuario.setCod(cad);
        
        String encr;
        encr = DigestUtils.md5Hex(pass);
        
        ousuario.setUser(generarusuario(ousuario.getNom(), ousuario.getAp_pat(), ousuario.getAp_mat()));
        ousuario.setPassword(encr);
        
        usuarioMapeador.Registrar(ousuario);
        int maxid=usuarioMapeador.seleccionarMaxID();
        acceso.setoUsuario(new Usuario(maxid));
        accesoMapeador.insertarAcceso(acceso);
        return pass;
    }
    
    public static String generarusuario(String nombre,String apaterno, String amaterno){
        String aux;   
        int cont=0;
        
        aux = nombre.substring(0,1);
        aux = aux+apaterno;
        aux = aux+amaterno.substring(0,1);

        aux = aux.toLowerCase();
        aux = aux.replace(" ","");
        String original = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
        String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
        
        for (int i=0; i<original.length(); i++) {
            aux=aux.replace(original.charAt(i), ascii.charAt(i));
        }
        
        return aux;
    }
    
}
