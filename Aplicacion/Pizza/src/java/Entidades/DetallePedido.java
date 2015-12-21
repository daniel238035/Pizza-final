package Entidades;

public class DetallePedido {
    private Integer id;
    private Double cant;
    private Double preUni;
    private Double subTotal;
    private Pedido oPedido;
    private Producto oProducto;
    
    public DetallePedido() {
    }

    public DetallePedido(Integer id) {
        this.id = id;
    }

    public DetallePedido(Integer id, Double cant, Double preUni, Double subTotal, Pedido oPedido, Producto oProducto) {
        this.id = id;
        this.cant = cant;
        this.preUni = preUni;
        this.subTotal = subTotal;
        this.oPedido = oPedido;
        this.oProducto = oProducto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCant() {
        return cant;
    }

    public void setCant(Double cant) {
        this.cant = cant;
    }

    public Double getPreUni() {
        return preUni;
    }

    public void setPreUni(Double preUni) {
        this.preUni = preUni;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Pedido getoPedido() {
        return oPedido;
    }

    public void setoPedido(Pedido oPedido) {
        this.oPedido = oPedido;
    }

    public Producto getoProducto() {
        return oProducto;
    }

    public void setoProducto(Producto oProducto) {
        this.oProducto = oProducto;
    }

    
    
}
