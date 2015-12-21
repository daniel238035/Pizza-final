package Entidades;

public class Producto {
    private Integer id;
    private String cod;
    private String nombre;
    private String desc;
    private String imagen;
    private Double preUni;

    public Producto() {
    }

    public Producto(Integer id) {
        this.id = id;
    }

    public Producto(Integer id, String cod, String nombre, String desc, String imagen, Double preUni) {
        this.id = id;
        this.cod = cod;
        this.nombre = nombre;
        this.desc = desc;
        this.imagen = imagen;
        this.preUni = preUni;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Double getPreUni() {
        return preUni;
    }

    public void setPreUni(Double preUni) {
        this.preUni = preUni;
    }

    
    
}
