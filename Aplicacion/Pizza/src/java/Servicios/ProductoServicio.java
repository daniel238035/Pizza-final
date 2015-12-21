package Servicios;

import Entidades.Producto;
import Mapeadores.ProductoMapeador;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServicio {
    @Autowired
    private ProductoMapeador productoMapeador;

    public List<Producto> ConsultarGeneral(String nombre) {
        return productoMapeador.SeleccionarGeneral(nombre + "%");
    }
    
    public Producto ConsultarProducto(Integer a){
        return productoMapeador.SeleccionarPorId(a);
    }
}