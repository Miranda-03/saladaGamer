package com.salada.api;

public class Usuario {
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer contraseña;
    private String mail;
    private Integer numeroTarjeta;
    private String domicilio;

    public Usuario(){}

    publiv Usuario(Integer id, String nombre, String apellido, Integer contraseña, String mail, Integer numeroTarjeta, String domicilio){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contraseña = contraseña;
        this.mail = mail;
        this.numeroTarjeta = numeroTarjeta;
        this.domicilio = domicilio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getContraseña() {
        return contraseña;
    }

    public void setContraseña(Integer contraseña) {
        this.contraseña = contraseña;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(Integer numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
}
