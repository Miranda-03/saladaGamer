package com.salada.api;

public class procesador extends ComponenteInterno{

    private Integer generacion;
    private boolean graficaIntegrada;
    private  String marca;

    public procesador(String id, String nombre, String foto, Integer precio, float consumo, Integer generacion, boolean graficaIntegrada, String marca) {
        super(id, nombre, foto, precio, consumo);
        this.generacion = generacion;
        this.graficaIntegrada = graficaIntegrada;
        this.marca = marca;
    }



    public Integer getGeneracion() {
        return generacion;
    }

    public void setGeneracion(Integer generacion) {
        this.generacion = generacion;
    }

    public boolean isGraficaIntegrada() {
        return graficaIntegrada;
    }

    public void setGraficaIntegrada(boolean graficaIntegrada) {
        this.graficaIntegrada = graficaIntegrada;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
