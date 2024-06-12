package mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.controllers;

import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.models.Usuarios;
import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuariosController {
    @Autowired
    private UsuariosService service;
    //Login
    @RequestMapping(value = "usuario", method = RequestMethod.POST)
    private ResponseEntity<Usuarios> get(@RequestBody Usuarios usuario){
        return ResponseEntity.ok(service.getUser(usuario.getUserEmail(),usuario.getUserPassword()));
    }
    //Registrar usuario
    @RequestMapping(value = "usuario/registro", method = RequestMethod.POST)
    private void set(@RequestBody Usuarios usuario){
        service.setUser(usuario);
    }
}
