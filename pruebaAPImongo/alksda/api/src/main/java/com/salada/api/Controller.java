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


    @RequestMapping(value = "/datos/alumnos", method = RequestMethod.GET)
    public ResponseEntity<Object> obtenerPaginas()  {
        HashMap<String, String> datos = new HashMap<>();
        datos.put("fun", "ciona");
        return new ResponseEntity<>(datos, HttpStatus.OK);
    }

    @RequestMapping(value = "/datos/alumnos/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> obtenerAlumno(@PathVariable int id)  {
        HashMap<String, Object> datos = new HashMap<>();
        return new ResponseEntity<>(datos, HttpStatus.OK);
    }

    @RequestMapping(value = "/datos/alumnos/{id}", method = RequestMethod.POST)
    public ResponseEntity<Object> agregarPagina(@RequestBody HashMap alumno, @PathVariable int id){

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