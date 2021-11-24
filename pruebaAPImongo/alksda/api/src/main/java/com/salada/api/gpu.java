package com.salada.api;

public class gpu extends ComponenteInterno{

    private Integer memoria;
    private Integer velocidadMemoria;
    private  Integer velocidadProcesamiento;

    public gpu(Integer id, String nombre, String foto, Integer precio, float consumo, Integer memoria, Integer velocidadMemoria, Integer velocidadProcesamiento) {
        super(id, nombre, foto, precio, consumo);
        this.memoria = memoria;
        this.velocidadMemoria = velocidadMemoria;
        this.velocidadProcesamiento = velocidadProcesamiento;
    }

    public Integer getMemoria() {
        return memoria;
    }

    public void setMemoria(Integer memoria) {
        this.memoria = memoria;
    }

    public Integer getVelocidadMemoria() {
        return velocidadMemoria;
    }

    public void setVelocidadMemoria(Integer velocidadMemoria) {
        this.velocidadMemoria = velocidadMemoria;
    }

    public Integer getVelocidadProcesamiento() {
        return velocidadProcesamiento;
    }

    public void setVelocidadProcesamiento(Integer velocidadProcesamiento) {
        this.velocidadProcesamiento = velocidadProcesamiento;
    }


}
