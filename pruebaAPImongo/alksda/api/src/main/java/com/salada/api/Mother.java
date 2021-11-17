package com.salada.api;

import java.util.ArrayList;

public class Mother extends ComponenteInterno {
    private String tamaño;
    private Integer cantM2;
    private Integer cantSatas;
    private ArrayList<String> generaciones;
    private Integer slotsRam;
    private String tipoRam;

    public Mother(String id, String nombre, String foto, Integer precio, float consumo, String tamaño,
                  Integer cantM2, Integer cantSatas, ArrayList<String> generaciones, Integer slotsRam, String tipoRam) {
        super(id, nombre, foto, precio, consumo);
        this.tamaño = tamaño;
        this.cantM2 = cantM2;
        this.cantSatas = cantSatas;
        this.generaciones = generaciones;
        this.slotsRam = slotsRam;
        this.tipoRam = tipoRam;
    }


    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public Integer getCantM2() {
        return cantM2;
    }

    public void setCantM2(Integer cantM2) {
        this.cantM2 = cantM2;
    }

    public Integer getCantSatas() {
        return cantSatas;
    }

    public void setCantSatas(Integer cantSatas) {
        this.cantSatas = cantSatas;
    }

    public ArrayList<String> getGeneraciones() {
        return generaciones;
    }

    public void setGeneraciones(ArrayList<String> generaciones) {
        this.generaciones = generaciones;
    }

    public Integer getSlotsRam() {
        return slotsRam;
    }

    public void setSlotsRam(Integer slotsRam) {
        this.slotsRam = slotsRam;
    }

    public String getTipoRam() {
        return tipoRam;
    }

    public void setTipoRam(String tipoRam) {
        this.tipoRam = tipoRam;
    }

}
