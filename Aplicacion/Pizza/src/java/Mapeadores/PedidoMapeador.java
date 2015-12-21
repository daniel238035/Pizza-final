/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapeadores;

import Entidades.Pedido;
import java.util.List;

/**
 *
 * @author daniel
 */
public interface PedidoMapeador {
    public void modificarPedido(Pedido pedido);
    public void registrarPedido(Pedido pedido);
    public List<Pedido> SeleccionarPedido(String Estado);
    public Integer Id();
    public Pedido obtenerPorId(Integer id);
    public void updatePorId(Integer id);
    public void anularPorId(Integer id);
    public void despacharPorId(Integer id);
}
