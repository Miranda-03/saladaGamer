package com.salada.api;

public class Fuente extends Componente{
 private Integer watts;
 private String tamaño;

    public Fuente(Integer id, String nombre, String foto, Integer precio, Integer watts, String tamaño) {
        super(id, nombre, foto, precio);
        this.watts = watts;
        this.tamaño = tamaño;
    }



    public Integer getWatts() {
        return watts;
    }

    public void setWatts(Integer watts) {
        this.watts = watts;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    @Override
    public String obetenerDescripcion() {
        String descripcion = "Provee una energia de " + this.getWatts() + " y tiene un tamaño de " + this.getTamaño();
        return descripcion;
    }
}
