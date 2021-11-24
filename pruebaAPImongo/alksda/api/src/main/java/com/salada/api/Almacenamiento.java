package com.salada.api;

public class Almacenamiento extends ComponenteInterno{
    private Integer capacidad;
    private String velocidad;
    private String tipo;


    public Almacenamiento(Integer id, String nombre, String foto, Integer precio, float consumo, Integer capacidad, String velocidad, String tipo) {
        super(id, nombre, foto, precio, consumo);
        this.capacidad = capacidad;
        this.velocidad = velocidad;
        this.tipo = tipo;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String obetenerDescripcion() {
        String descripcion = "Tiene una capacidad de " + this.getCapacidad() +
                ", con una velocidad de " + this.getVelocidad() + " y es de tipo " + this.getTipo();
        return descripcion;
    }
}
