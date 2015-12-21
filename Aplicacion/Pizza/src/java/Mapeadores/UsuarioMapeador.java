package Mapeadores;

import Entidades.Usuario;

public interface UsuarioMapeador {    
   
    public void cambiarContraseña(Usuario usuario);
    public Usuario SeleccionarUsuario(Usuario u);
    public Usuario seleccionarUsuarioPorCorreo(String Correo);
    public Usuario seleccionarPorUser(String User);
    public void Registrar(Usuario ousuario);
    public void ModificarContraseña (Usuario ousuario);
    public int seleccionarMaxID();
}
