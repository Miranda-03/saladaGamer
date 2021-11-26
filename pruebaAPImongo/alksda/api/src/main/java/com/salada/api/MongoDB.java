package com.salada.api;

import com.mongodb.MongoClient;
import com.mongodb.client.*;
import org.bson.Document;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.*;

@Service
class MongoDB {

    private MongoDatabase baseDeDatos;
    private MongoCollection coleccion;

    private HashMap<String, Object> componenteActual;

    public MongoDB() {
        this.conectar("saladaGamer","procesador");
        this.componenteActual = new HashMap<>();
    }

    public void conectar(String baseDeDatos,String coleccion){
        this.conectarABaseDeDatos(baseDeDatos);
        this.conectarAColeccion(coleccion);
    }

    public MongoDatabase getBaseDeDatos() {
        return baseDeDatos;
    }

    public void setBaseDeDatos(MongoDatabase baseDeDatos) {
        this.baseDeDatos = baseDeDatos;
    }

    public MongoCollection getColeccion() {
        return coleccion;
    }

    public void setColeccion(MongoCollection coleccion) {
        this.coleccion = coleccion;
    }

    public void conectarABaseDeDatos(String nombreBaseDeDatos){
        MongoClient mongo = new MongoClient("localhost",27017);
        this.baseDeDatos = mongo.getDatabase(nombreBaseDeDatos);
    }

    public void conectarAColeccion(String nombreDeColeccion){
        if (this.existeLaColeccion(nombreDeColeccion)){
            this.coleccion = baseDeDatos.getCollection(nombreDeColeccion);
        } else {
            baseDeDatos.createCollection(nombreDeColeccion);
            this.coleccion = baseDeDatos.getCollection(nombreDeColeccion);
        }
    }

    public boolean existeLaColeccion(String nombreDeColeccion){

        MongoIterable<String> nombresDeColecciones = baseDeDatos.listCollectionNames();
        boolean existe = false;

        for (String nombre : nombresDeColecciones) {
            if (nombre.equals(nombreDeColeccion)){
                existe = true;
            }
        }
        return existe;
    }

    public HashMap<String,Object> obtenerDatos(String componente, int cantidad){
        HashMap<String,Object> datos = new HashMap<>();
        ArrayList<Componente> componentes = new ArrayList<>();

        FindIterable resultado = coleccion.find();
        MongoCursor iterador = resultado.iterator();
        int contador = 0;
        while (iterador.hasNext()) {
            if(cantidad > 0){
                if(contador == cantidad){
                    break;
                }
            }
            Document documento = (Document) iterador.next();
            Integer id = documento.getInteger("id");
            String nombre = documento.getString("nombre");
            String foto = documento.getString("foto");
            Integer precio = documento.getInteger("precio");

            if(componente.equals("fuente")){
                Integer watts = documento.getInteger("wats");
                String tamaño = documento.getString("tamaño");
                Fuente fuente = new Fuente(id, nombre, foto, precio, watts, tamaño);
                componentes.add(fuente);
            }
            else if(componente.equals("gabinete")){
                String tamañoFuente = documento.getString("tamañoFuente");
                ArrayList<String> tamañoMother = (ArrayList<String>) documento.get("tamañoMother");
                Gabinete gabinete = new Gabinete(id, nombre, foto, precio, tamañoFuente, tamañoMother);
                componentes.add(gabinete);
            }
            else if(componente.equals("gpu")){
                Integer memoria = documento.getInteger("memoria");
                Integer velocidadMemoria = documento.getInteger("velocidadMemoria");
                Integer velicidadProcesamiento = documento.getInteger("velocidadProcesamiento");
                Integer consumo =  documento.getInteger("consumo");
                gpu gpu = new gpu(id, nombre, foto, precio, consumo, memoria, velocidadMemoria, velicidadProcesamiento);
                componentes.add(gpu);
            }
            else if(componente.equals("memoriaRam")){
                Integer capacidad = documento.getInteger("capacidada");
                Integer frecuencia = documento.getInteger("frecuencia");
                String tipo = documento.getString("tipo");
                Integer consumo =  documento.getInteger("consumo");
                memoriaRam ram = new memoriaRam(id, nombre, foto, precio, consumo, capacidad, frecuencia, tipo);
                componentes.add(ram);
            }
            else if(componente.equals("mother")){
                String tamaño = documento.getString("tamaño");
                Integer cantM2 = documento.getInteger("cantM2");
                Integer cantSatas = documento.getInteger("cantSatas");
                ArrayList<String> generaciones = (ArrayList<String>) documento.get("generaciones");
                Integer slotsRam = documento.getInteger("slotsRam");
                String tipoRam = documento.getString("tipoRam");
                Integer consumo =  documento.getInteger("consumo");
                String marca = documento.getString("marca");
                Mother mother = new Mother(id, nombre, foto, precio, consumo, tamaño, cantM2, cantSatas, generaciones, slotsRam, tipoRam, marca);
                componentes.add(mother);
                System.out.println("funciona");
            }
            else if(componente.equals("procesador")){
                String generacion = documento.getString("generacion");
                boolean GraficaIntegrada = documento.getBoolean("graficaIntegrada");
                String marca =  documento.getString("marca");
                Integer consumo =  documento.getInteger("consumo");
                Procesador procesador = new Procesador(id, nombre, foto, precio, consumo, generacion, GraficaIntegrada, marca);
                componentes.add(procesador);
            }
            else if(componente.equals("cooler")){
                Integer consumo =  documento.getInteger("consumo");
                Cooler cooler =  new Cooler(id, nombre, foto, precio, consumo );
                componentes.add(cooler);
            }
            else if(componente.equals("almacenamiento")){
                Integer capacidad = documento.getInteger("capacidad");
                String velocidad = documento.getString("velocidad");
                String tipo = documento.getString("tipo");
                Integer consumo =  documento.getInteger("consumo");
                Almacenamiento almacenamiento = new Almacenamiento(id, nombre, foto, precio, consumo, capacidad, velocidad, tipo);
                componentes.add(almacenamiento);
            }
            contador++;
        }

        datos.put("componente",componentes);
        return datos;
    }

    public HashMap<String, Object> procesadoresMarca(boolean marca){
        // True = Intel, False = AMD
        String filtro;
        if(marca){
            filtro = "{marca : \"Intel\"}";
        }
        else{
            filtro = "{marca : \"AMD\"}";
        }
        Document filtroJSon = Document.parse(filtro);

        HashMap<String, Object> datosProcesadores = new HashMap<>();
        ArrayList<Procesador> procesadores = new ArrayList<>();

        FindIterable resultado = coleccion.find(filtroJSon);
        MongoCursor iterador = resultado.iterator();

        while (iterador.hasNext()){
            Document documento = (Document) iterador.next();
            Integer id = documento.getInteger("id");
            String nombre = documento.getString("nombre");
            String foto = documento.getString("foto");
            Integer precio = documento.getInteger("precio");
            String generacion = documento.getString("generacion");
            boolean graficaIntegrada = documento.getBoolean("graficaIntegrada");
            String marcaProcesador = documento.getString("marca");
            Integer consumo =  documento.getInteger("consumo");

            Procesador procesador  = new Procesador(id, nombre, foto, precio, consumo, generacion, graficaIntegrada, marcaProcesador);

            procesadores.add(procesador);

        }

        datosProcesadores.put("componente", procesadores);
        this.setComponenteActual(datosProcesadores);
        return datosProcesadores;
    }

    public HashMap<String, Object> siguienteComponente(String componente, Integer id){
        HashMap<String, Object> datos = new HashMap<>();
        ArrayList<Componente> componentes = new ArrayList<>();
        if(componente.equals("procesador")){
            String filtro = "{id : "+  id.toString() + " }";
            Document filtroJSon = Document.parse(filtro);
            this.conectar("saladaGamer", "procesador");
            FindIterable resultado = coleccion.find(filtroJSon);
            MongoCursor iterador = resultado.iterator();
            Procesador procesador = null;
            while (iterador.hasNext()){
                Document documento = (Document) iterador.next();
                Integer id1 = documento.getInteger("id");
                String nombre = documento.getString("nombre");
                String foto = documento.getString("foto");
                Integer precio = documento.getInteger("precio");
                String generacion = documento.getString("generacion");
                boolean graficaIntegrada = documento.getBoolean("graficaIntegrada");
                String marcaProcesador = documento.getString("marca");
                Integer consumo =  documento.getInteger("consumo");

                procesador  = new Procesador(id1, nombre, foto, precio, consumo, generacion, graficaIntegrada, marcaProcesador);

            }
            this.conectar("saladaGamer", "motherboard");

            String filtroMother = "{marca: " + '"' +procesador.getMarca() + '"' +", " + "generaciones : "+ '"' + procesador.getGeneracion() + '"' +"}";
            Document jsonFiltro = Document.parse(filtroMother);
            System.out.println(jsonFiltro);
            FindIterable resultadoMothers = coleccion.find(jsonFiltro);
            MongoCursor iteradorMother = resultadoMothers.iterator();
            while(iteradorMother.hasNext()){
                Document documento = (Document) iteradorMother.next();
                Integer id1 = documento.getInteger("id");
                String nombre = documento.getString("nombre");
                String foto = documento.getString("foto");
                Integer precio = documento.getInteger("precio");
                String tamaño = documento.getString("tamaño");
                Integer cantM2 = documento.getInteger("cantM2");
                Integer cantSatas = documento.getInteger("cantSatas");
                ArrayList<String> generaciones = (ArrayList<String>) documento.get("generaciones");
                Integer slotsRam = documento.getInteger("slotsRam");
                String tipoRam = documento.getString("tipoRam");
                Integer consumo =  documento.getInteger("consumo");
                String marca = documento.getString("marca");
                Mother mother = new Mother(id, nombre, foto, precio, consumo, tamaño, cantM2, cantSatas, generaciones, slotsRam, tipoRam, marca);
                componentes.add(mother);
                System.out.println(componentes);
            }

        }
        else if(componente.equals("motherboard")){
            this.conectar("saladaGamer", "motherboard");
            String filtroRamMother = "{id : "+ id +"}";
            Document filtroJsonMotherRam = Document.parse(filtroRamMother);
            FindIterable resultadoMotherRam = coleccion.find(filtroJsonMotherRam);
            MongoCursor iteradorMotherRam = resultadoMotherRam.iterator();
            Document documento = (Document) iteradorMotherRam.next();
            Integer id1 = documento.getInteger("id");
            String nombre = documento.getString("nombre");
            String foto = documento.getString("foto");
            Integer precio = documento.getInteger("precio");
            String tamaño = documento.getString("tamaño");
            Integer cantM2 = documento.getInteger("cantM2");
            Integer cantSatas = documento.getInteger("cantSatas");
            ArrayList<String> generaciones = (ArrayList<String>) documento.get("generaciones");
            Integer slotsRam = documento.getInteger("slotsRam");
            String tipoRam = documento.getString("tipoRam");
            Integer consumo =  documento.getInteger("consumo");
            String marca = documento.getString("marca");
            Mother mother = new Mother(id, nombre, foto, precio, consumo, tamaño, cantM2, cantSatas, generaciones, slotsRam, tipoRam, marca);

            this.conectar("saladaGamer", "memoriaRam");

            String filtroRam = "{tipo :"+ '"' +mother.getTipoRam()+ '"'  + "}";
            Document filtroJsonRam = Document.parse(filtroRam);
            FindIterable resultadoRam = coleccion.find(filtroJsonRam);
            MongoCursor iteradorRam  = resultadoRam.iterator();

            while(iteradorRam.hasNext()){
                Document documento1 = (Document) iteradorRam.next();
                Integer id2 = documento.getInteger("id");
                String nombre1 = documento.getString("nombre");
                String foto1 = documento.getString("foto");
                Integer precio1 = documento.getInteger("precio");
                Integer capacidad = documento.getInteger("capacidada");
                Integer frecuencia = documento.getInteger("frecuencia");
                String tipo = documento.getString("tipo");
                Integer consumo1 =  documento.getInteger("consumo");
                memoriaRam ram = new memoriaRam(id2, nombre1, foto1, precio1, consumo1, capacidad, frecuencia, tipo);
                componentes.add(ram);
            }
        }
        else if(componente.equals("memoriaRam")){
            this.setComponenteActual(this.obtenerDatos("gpu", 0));
            return this.obtenerDatos("gpu", 0);
        }
        else if(componente.equals("gpu")){
            this.setComponenteActual(this.obtenerDatos("fuente", 0));
            return  this.obtenerDatos("fuente", 0);
        }
        else if(componente.equals("fuente")){
            this.setComponenteActual(this.obtenerDatos("cooler", 0));
            return this.obtenerDatos("cooler", 0);
        }
        else if(componente.equals("cooler")){
            this.setComponenteActual(this.obtenerDatos("almacenamiento", 0));
            return this.obtenerDatos("almacenamiento", 0);
        }

        datos.put("componentes", componentes);
        this.setComponenteActual(datos);
        return datos;
    }



    public HashMap<String, Object> getComponenteActual() {
        return componenteActual;
    }

    public void setComponenteActual(HashMap<String, Object> componenteActual) {
        this.componenteActual = componenteActual;
    }


    /**
     * documentación de clase Document
     * http://mongodb.github.io/mongo-java-driver/3.6/javadoc/org/bson/Document.html
     */

}
