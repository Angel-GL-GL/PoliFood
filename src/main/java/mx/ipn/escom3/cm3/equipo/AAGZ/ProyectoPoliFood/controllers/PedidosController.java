package mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.controllers;

import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.models.Pedidos;
import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PedidosController {
    @Autowired
    private PedidosService service;
    //Todos los pedidos
    @RequestMapping(value = "pedidos", method = RequestMethod.GET)
    private ResponseEntity<List<Pedidos>> getAll(){
        return ResponseEntity.ok(service.getAllOrders());
    }
    //Pedido por id
    @RequestMapping(value = "pedido/{id}", method = RequestMethod.GET)
    private ResponseEntity<Pedidos> get(@PathVariable Integer id){
        return ResponseEntity.ok(service.getOrder(id));
    }
    //Pedidos por id de usuario
    @RequestMapping(value = "usuario/pedidos/{id}", method = RequestMethod.GET)
    private ResponseEntity<List<Pedidos>> getUP(@PathVariable Integer id){
        return ResponseEntity.ok(service.getOrdersUser(id));
    }
    //Pedidos por estado
    @RequestMapping(value = "pedidos/estado/{state}", method = RequestMethod.GET)
    private ResponseEntity<List<Pedidos>> get(@PathVariable String state){
        return ResponseEntity.ok(service.getOrdersState(state));
    }
    //Registrar pedido
    @RequestMapping(value = "pedido", method = RequestMethod.POST)
    private void set(@RequestBody Pedidos pedido){
        service.saveOrder(pedido);
    }
}
