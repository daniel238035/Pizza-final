package Entidades;

import java.sql.Timestamp;
import java.util.List;

public class Pedido {
    private Integer id;
    private Timestamp fech_hor;
    private String cliente;
    private String direccion;
    private String telf;
    private Double importe;
    private Double pago;
    private Double vuelto;
    private String estado;
    private Usuario oUsuario;
    private Ciudad oCiudad;
    private List<DetallePedido> lDetallePedido;

    public Pedido() {
    }

    public Pedido(Integer id) {
        this.id = id;
    }

    public Pedido(Integer id, Timestamp fech_hor, String cliente, String direccion, String telf, Double importe, Double pago, Double vuelto, String estado, Usuario oUsuario, Ciudad oCiudad, List<DetallePedido> lDetallePedido) {
        this.id = id;
        this.fech_hor = fech_hor;
        this.cliente = cliente;
        this.direccion = direccion;
        this.telf = telf;
        this.importe = importe;
        this.pago = pago;
        this.vuelto = vuelto;
        this.estado = estado;
        this.oUsuario = oUsuario;
        this.oCiudad = oCiudad;
        this.lDetallePedido = lDetallePedido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getFech_hor() {
        return fech_hor;
    }

    public void setFech_hor(Timestamp fech_hor) {
        this.fech_hor = fech_hor;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelf() {
        return telf;
    }

    public void setTelf(String telf) {
        this.telf = telf;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Double getPago() {
        return pago;
    }

    public void setPago(Double pago) {
        this.pago = pago;
    }

    public Double getVuelto() {
        return vuelto;
    }

    public void setVuelto(Double vuelto) {
        this.vuelto = vuelto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getoUsuario() {
        return oUsuario;
    }

    public void setoUsuario(Usuario oUsuario) {
        this.oUsuario = oUsuario;
    }

    public Ciudad getoCiudad() {
        return oCiudad;
    }

    public void setoCiudad(Ciudad oCiudad) {
        this.oCiudad = oCiudad;
    }

    public List<DetallePedido> getlDetallePedido() {
        return lDetallePedido;
    }

    public void setlDetallePedido(List<DetallePedido> lDetallePedido) {
        this.lDetallePedido = lDetallePedido;
    }

    
    

    
    
}
