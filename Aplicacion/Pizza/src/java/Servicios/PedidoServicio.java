/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Pedido;
import Mapeadores.DetallePedidoMapeador;
import Mapeadores.PedidoMapeador;
import java.sql.Timestamp;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author daniel
 */
@Service
public class PedidoServicio {
    @Autowired
    private PedidoMapeador pedidoMapeador;
    @Autowired
    private DetallePedidoMapeador detalleMapeador;
    
    @Transactional(rollbackOn = {RuntimeException.class,Exception.class})
    public void registrarPedido(Pedido pedido)throws Exception {
        
        
	 java.util.Date date= new java.util.Date();
	 Timestamp fechor = new Timestamp(date.getTime());
         pedido.setFech_hor(fechor);
    
        
        
        pedidoMapeador.registrarPedido(pedido);
        
        for (int i = 0; i < pedido.getlDetallePedido().size(); i++) {
            pedido.getlDetallePedido().get(i).setoPedido(new Pedido(pedidoMapeador.Id()));
            detalleMapeador.registrarDetallePedido(pedido.getlDetallePedido().get(i));    
        }
    }  
    
    @Transactional(rollbackOn = {RuntimeException.class,Exception.class})
    public void modificarPedido(Pedido pedido)throws Exception {
        int id= pedido.getId();
        detalleMapeador.eliminarDetalles(id);
        pedidoMapeador.modificarPedido(pedido);
        for (int i = 0; i < pedido.getlDetallePedido().size(); i++) {
            pedido.getlDetallePedido().get(i).setoPedido(new Pedido(id));
            detalleMapeador.registrarDetallePedido(pedido.getlDetallePedido().get(i));    
        }        
    }
    
 
    public List<Pedido> SeleccionarPedido(String estado){
        return  pedidoMapeador.SeleccionarPedido(estado);
    }
    
    public void UpdateEstadoPedido(Integer id){
        pedidoMapeador.updatePorId(id);
    }
    public void anularEstadoPedido(Integer id){
        pedidoMapeador.anularPorId(id);
    }
    public void despacharEstadoPedido(Integer id){
        pedidoMapeador.despacharPorId(id);
    }
    
    public Pedido obtenerPorId(Integer id){
        return pedidoMapeador.obtenerPorId(id);
    }
    
    
}
