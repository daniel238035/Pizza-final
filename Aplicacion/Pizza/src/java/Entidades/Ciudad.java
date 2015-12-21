package Entidades;

public class Ciudad {
    private Integer id;
    private String cod;
    private String nombre;
    private String prefijo;

    public Ciudad() {
    }

    public Ciudad(Integer id) {
        this.id = id;
    }
    

    public Ciudad(Integer id, String cod, String nombre, String prefijo) {
        this.id = id;
        this.cod = cod;
        this.nombre = nombre;
        this.prefijo = prefijo;
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

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }
    
    
    
}
