package mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.controllers;

import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.models.Contenidos;
import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.models.Pedidos;
import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.service.ContenidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContenidosController {
    @Autowired
    private ContenidosService service;
    //Contenido del pedido
    @RequestMapping(value = "contenido/{id}", method = RequestMethod.GET)
    private ResponseEntity<List<Contenidos>> get(@PathVariable Integer id){
        return ResponseEntity.ok(service.getContByOrder(id));
    }
    //Total del pedido
    @RequestMapping(value = "contenido/{id}/total", method = RequestMethod.GET)
    private ResponseEntity<Double> getTotal(@PathVariable Integer id){
        return ResponseEntity.ok(service.getTotal(id));
    }
    //Agregar contenido a un pedido
    @RequestMapping(value = "contenido", method = RequestMethod.POST)
    private void set(@RequestBody Contenidos contenido){
        service.setCont(contenido);
    }
}
