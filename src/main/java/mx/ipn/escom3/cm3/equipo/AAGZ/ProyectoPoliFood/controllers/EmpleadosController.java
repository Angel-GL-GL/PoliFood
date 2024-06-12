package mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.controllers;

import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.models.Empleados;
import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.models.Usuarios;
import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.service.EmpleadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadosController {
    @Autowired
    private EmpleadosService service;
    //Obtener todos los empleados
    @RequestMapping(value = "empleados", method = RequestMethod.GET)
    private ResponseEntity<List<Empleados>> getAll(){
        return ResponseEntity.ok(service.getAllUsers());
    }
    //Empleado por su id
    @RequestMapping(value = "empleado/{id}", method = RequestMethod.GET)
    private ResponseEntity<Empleados> get(@PathVariable Integer id){
        return ResponseEntity.ok(service.getUser(id));
    }
    //Información del empleado
    @RequestMapping(value = "empleado/{id}", method = RequestMethod.POST)
    private ResponseEntity<Usuarios> get(@RequestBody Usuarios usuario,@PathVariable Integer id){
        return ResponseEntity.ok(service.getUser(id,usuario.getUserPassword()));
    }
    //Empleado por tipo
    @RequestMapping(value = "empleado/tipo/{type}", method = RequestMethod.GET)
    private ResponseEntity<List<Usuarios>> get(@PathVariable String type){
        return ResponseEntity.ok(service.getEmployeesType(type));
    }
}
