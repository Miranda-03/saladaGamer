package com.salada.api;

public class Procesador extends ComponenteInterno{

    private String generacion;
    private boolean graficaIntegrada;
    private  String marca;

    public Procesador(Integer id, String nombre, String foto, Integer precio, float consumo, String generacion, boolean graficaIntegrada, String marca) {
        super(id, nombre, foto, precio, consumo);
        this.generacion = generacion;
        this.graficaIntegrada = graficaIntegrada;
        this.marca = marca;
    }



    public String getGeneracion() {
        return generacion;
    }

    public void setGeneracion(String generacion) {
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

    @Override
    public String obetenerDescripcion() {
        String grafica ;
        if(this.graficaIntegrada){
            grafica = " Tiene grafica integrada";
        }
        else{
            grafica = " no tiene grafica integrada";
        }

        String descripcion = "generacion " + this.getGeneracion() + grafica;

        return descripcion;
    }
}
