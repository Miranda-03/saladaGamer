package com.salada.api;

import java.util.ArrayList;

public class Gabinete extends Componente{
    private String tamañoFuente;
    private ArrayList<String> tamañoMother;

    public Gabinete(Integer id, String nombre, String foto, Integer precio, String tamañoFuente, ArrayList<String> tamañoMother) {
        super(id, nombre, foto, precio);
        this.tamañoFuente = tamañoFuente;
        this.tamañoMother = tamañoMother;
    }

    public String getTamañoFuente() {
        return tamañoFuente;
    }

    public void setTamañoFuente(String tamañoFuente) {
        this.tamañoFuente = tamañoFuente;
    }

    public ArrayList<String> getTamañoMother() {
        return tamañoMother;
    }

    public void setTamañoMother(ArrayList<String> tamañoMother) {
        this.tamañoMother = tamañoMother;
    }

    @Override
    public String obetenerDescripcion() {
        String descripcion = "Es compatible con los siguientes tamaños de fuentes: " + this.getTamañoFuente() +
                ", y con los siguientes tamaños de fuente: " + this.getTamañoMother();

        return descripcion;
    }
}
