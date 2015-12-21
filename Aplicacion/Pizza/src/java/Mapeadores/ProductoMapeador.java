package Mapeadores;

import Entidades.Producto;
import java.util.List;

public interface ProductoMapeador {
    public List<Producto> SeleccionarGeneral(String nombre);
    public Producto SeleccionarPorId(Integer id);
}
