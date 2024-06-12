package mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.service;

import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.models.Usuarios;
import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository repository;

    public List<Usuarios> getAllUsers(){return repository.findAll();}

    public Usuarios getUser(String email, String pass){
        List<Usuarios> res = repository.findByUserEmailAndUserPassword(email,pass);
        if(!res.isEmpty()) return res.get(0);
        else return new Usuarios();
    }

    public Usuarios getUser(Integer id, String pass){
        List<Usuarios> res = repository.findByUserIDAndUserPassword(id,pass);
        if(!res.isEmpty()) return res.get(0);
        else return new Usuarios();
    }

    public void setUser(Usuarios usuario){

        if(!repository.existsByUserEmail(usuario.getUserEmail()))
            repository.save(usuario);
    }
}
