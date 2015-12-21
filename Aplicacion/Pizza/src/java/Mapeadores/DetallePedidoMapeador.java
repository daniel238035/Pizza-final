/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapeadores;

import Entidades.DetallePedido;

/**
 *
 * @author daniel
 */
public interface DetallePedidoMapeador {
    public void registrarDetallePedido(DetallePedido detallePedido);
    public void eliminarDetalles(Integer Id);
}
