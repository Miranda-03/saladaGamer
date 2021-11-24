package com.salada.api;

public class memoriaRam extends ComponenteInterno{
    private Integer capacidad;
    private float frecuencia;
    private String tipo;

    public memoriaRam(Integer id, String nombre, String foto, Integer precio, float consumo, Integer capacidad, float frecuencia, String tipo) {
        super(id, nombre, foto, precio, consumo);
        this.capacidad = capacidad;
        this.frecuencia = frecuencia;
        this.tipo = tipo;
    }


    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public float getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(float frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String obetenerDescripcion() {
        String descripcion = "Es de " + this.getCapacidad() + " con una frecuencia de " + this.getFrecuencia() +
                " y es de tipo " + this.getTipo();

        return descripcion;
    }
}
