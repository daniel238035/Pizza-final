package Entidades;

import java.util.List;

public class Usuario {
    private Integer id;
    private String cod;
    private String ap_pat;
    private String ap_mat;
    private String nom;
    private String user;
    private String password;
    private String correo;
    private Acceso oAcceso;

    public Usuario() {
    }

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario(Integer id, String cod, String ap_pat, String ap_mat, String nom, String user, String password, String correo, Acceso oAcceso) {
        this.id = id;
        this.cod = cod;
        this.ap_pat = ap_pat;
        this.ap_mat = ap_mat;
        this.nom = nom;
        this.user = user;
        this.password = password;
        this.correo = correo;
        this.oAcceso = oAcceso;
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

    public String getAp_pat() {
        return ap_pat;
    }

    public void setAp_pat(String ap_pat) {
        this.ap_pat = ap_pat;
    }

    public String getAp_mat() {
        return ap_mat;
    }

    public void setAp_mat(String ap_mat) {
        this.ap_mat = ap_mat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Acceso getoAcceso() {
        return oAcceso;
    }

    public void setoAcceso(Acceso oAcceso) {
        this.oAcceso = oAcceso;
    }
    
       
    
}
