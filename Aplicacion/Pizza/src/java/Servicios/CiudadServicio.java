/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Ciudad;
import Mapeadores.CiudadMapeador;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author daniel
 */
@Service
public class CiudadServicio {
    
    
    @Autowired
    private CiudadMapeador ciudadMapeador;
    
    
    public List<Ciudad> obtenerCiudad(String nombre){
        return ciudadMapeador.seleccionGeneral(nombre+"%");
    }
    
}
