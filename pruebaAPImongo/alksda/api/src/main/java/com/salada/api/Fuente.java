package com.salada.api;

public class Fuente extends Componente{
 private Integer watts;
 private String tamaño;

    public Fuente(String id, String nombre, String foto, Integer precio, Integer watts, String tamaño) {
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
}