package Mapeadores;

import Entidades.Acceso;


public interface AccesoMapeador {
    public String seleccionarRol(String user);
    public void insertarAcceso(Acceso acceso);
    public Acceso obtenerAcceso(Integer Id);
}
