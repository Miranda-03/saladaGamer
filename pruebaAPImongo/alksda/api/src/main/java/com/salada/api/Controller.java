package com.salada.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/** url: http://localhost:8080/api/... **/

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Controller {

    @Autowired
    //private AccesoBaseDeDatos accesoABaseDeDatos;
    private MongoDB accesoMongo;

    public Controller() {
        // this.accesoABaseDeDatos = new AccesoBaseDeDatos("personas","alumnos");
        this.accesoMongo = new MongoDB();
    }


    @RequestMapping(value = "/datos/componente/{coleccion}/{cantidad}", method = RequestMethod.GET)
    public ResponseEntity<Object> obtenerComponenteEspecifico(@PathVariable String coleccion, @PathVariable int cantidad)  {
        HashMap<String, Object> datos = new HashMap<>();
        accesoMongo.conectar("saladaGamer", coleccion);
        datos = accesoMongo.obtenerDatos(coleccion, cantidad);
        return new ResponseEntity<>(datos, HttpStatus.OK);
    }

    @RequestMapping(value = "/datos/procesador/{marca}", method = RequestMethod.GET)
    public ResponseEntity<Object> obtenerAlumno(@PathVariable boolean marca)  {
        HashMap<String, Object> datos = new HashMap<>();
        datos = accesoMongo.procesadoresMarca(marca);
        return new ResponseEntity<>(datos, HttpStatus.OK);
    }

    @RequestMapping(value = "/datos/componenteElegido/{componente}/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> obtenerSiguienteComponente(@PathVariable String componente, @PathVariable int id){
        HashMap<String, Object> datos = new HashMap<>();
        datos = accesoMongo.siguienteComponente(componente, id);
        return  new ResponseEntity<>(datos, HttpStatus.OK);
    }


    @RequestMapping(value = "/datos/componenteActual", method = RequestMethod.GET)
    public ResponseEntity<Object> obtenerActual(){
        HashMap<String, Object> datos;
        datos = accesoMongo.getComponenteActual();
        System.out.println(datos);
        return  new ResponseEntity<>(datos, HttpStatus.OK);
    }




    @RequestMapping(value = "/datos/usuario", method = RequestMethod.POST)
    public ResponseEntity<Object> agregarPagina(@RequestBody HashMap usuario){
        this.accesoMongo.conectar("saladaGamer", "usuario");
        String contraseña = (String) usuario.get("contraseña");
        Integer id = (Integer) usuario.get("id");
        String mail = (String) usuario.get("mail");
        Integer numeroTarjeta = (Integer) usuario.get("numTarjeta");
        String apellido = (String) usuario.get("apellido");
        String nombre = (String) usuatio.get("nombre");
        String domicilio = (String) usuario.get("domicilio");
        Usuario nuevoUsuario = new Usuario(id, nombre, apellido, contraseña, mail, numeroTarjeta, domicilio);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/datos/alumnos/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Object> modificarAlumno(@RequestBody Object dato, @PathVariable int id){

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/datos/alumnos/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> liquidarAlumno(@PathVariable int id){

        return new ResponseEntity<>(HttpStatus.OK);
    }

}