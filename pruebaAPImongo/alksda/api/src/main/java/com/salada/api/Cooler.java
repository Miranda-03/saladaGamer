package com.salada.api;

public class Cooler extends ComponenteInterno {

    public Cooler(Integer id, String nombre, String foto, Integer precio, float consumo) {
        super(id, nombre, foto, precio, consumo);
    }


    @Override
    public String obetenerDescripcion() {
        String descripcion = "Ventilador";
        return descripcion;
    }
}
