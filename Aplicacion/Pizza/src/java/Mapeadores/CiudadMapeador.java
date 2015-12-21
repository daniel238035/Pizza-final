/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapeadores;

import Entidades.Ciudad;
import java.util.List;

/**
 *
 * @author daniel
 */
public interface CiudadMapeador {
    public List<Ciudad> seleccionGeneral(String Nombre);
    
}
