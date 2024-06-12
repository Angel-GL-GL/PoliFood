package mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.controllers;

import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.models.Productos;
import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.models.Usuarios;
import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductosController {
    @Autowired
    private ProductosService service;
    //Obtener todos los productos
    @RequestMapping(value = "productos", method = RequestMethod.GET)
    private ResponseEntity<List<Productos>> getAll(){
        return ResponseEntity.ok(service.getAllProducts());
    }
    //Obtener los productos de una categoria
    @RequestMapping(value = "productos/categoria/{category}", method = RequestMethod.GET)
    private ResponseEntity<List<Productos>> get(@PathVariable String category){
        return ResponseEntity.ok(service.getProduct(category));
    }
    //Obtener un producto
    @RequestMapping(value = "producto/{id}", method = RequestMethod.GET)
    private ResponseEntity<Productos> get(@PathVariable Integer id){
        return ResponseEntity.ok(service.getProduct(id));
    }
}
