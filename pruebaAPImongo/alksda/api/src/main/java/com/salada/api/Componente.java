package com.salada.api;

public abstract class Componente implements InterfazComponente{
    private Integer id;
    private String nombre;
    private String foto;//Url de la foto
    private Integer precio;

    public Componente(Integer id, String nombre, String foto, Integer precio) {
        this.id = id;
        this.nombre = nombre;
        this.foto = foto;
        this.precio = precio;
    }
    
    @Override
    public String getComponente() {
        return null;
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public abstract String obetenerDescripcion();
}
