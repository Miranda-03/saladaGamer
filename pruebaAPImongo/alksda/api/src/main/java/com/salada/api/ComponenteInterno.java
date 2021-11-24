package com.salada.api;

public abstract class ComponenteInterno extends Componente{
    private  float consumo;

    public ComponenteInterno(Integer id, String nombre, String foto, Integer precio, float consumo) {
        super(id, nombre, foto, precio);
        this.consumo = consumo;
    }

    public float getConsumo() {
        return consumo;
    }

    public void setConsumo(float consumo) {
        this.consumo = consumo;
    }
}
