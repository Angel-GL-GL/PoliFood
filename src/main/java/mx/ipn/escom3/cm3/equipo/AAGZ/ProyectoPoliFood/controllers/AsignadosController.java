package mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.controllers;

import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.models.Asignados;
import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.models.Empleados;
import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.models.Pedidos;
import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.service.AsignadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AsignadosController {
    @Autowired
    private AsignadosService service;
    //Todos los asignados
    @RequestMapping(value = "asignados", method = RequestMethod.GET)
    private ResponseEntity<List<Asignados>> getAll(){
        return ResponseEntity.ok(service.getAllAssigned());
    }
    //Asignados de un empleado
    @RequestMapping(value = "empleado/asignados/{id}", method = RequestMethod.GET)
    private ResponseEntity<List<Asignados>> get(@PathVariable Integer id){
        return ResponseEntity.ok(service.getAllAssignedEmployee(id));
    }
    //Asignar
    @RequestMapping(value = "asignar", method = RequestMethod.POST)
    private void set(@RequestBody Asignados asignado){
        service.setAssigned(asignado);
    }
}
