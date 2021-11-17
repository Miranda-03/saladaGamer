package com.salada.api;

public class Cooler extends ComponenteInterno {

    public Cooler(String id, String nombre, String foto, Integer precio, float consumo) {
        super(id, nombre, foto, precio, consumo);
    }

    @Override
    public boolean esCompatible() {
        return false;
    }

}
