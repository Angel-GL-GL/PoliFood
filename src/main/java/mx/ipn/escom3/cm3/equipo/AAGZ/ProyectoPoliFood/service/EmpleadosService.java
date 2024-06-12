package mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.service;

import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.models.Empleados;
import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.models.Usuarios;
import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.repository.EmpleadosRepository;
import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadosService {

    @Autowired
    private EmpleadosRepository repository;
    @Autowired
    private UsuariosRepository uRepository;

    public List<Empleados> getAllUsers(){return repository.findAll();}

    public Empleados getUser(Integer id){
        Empleados res = repository.findByEmployeeUserID(id);
        return res;
    }

    public Usuarios getUser(Integer id, String pass){
        List<Empleados> res = repository.findByEmployeeID(id);
        if(!res.isEmpty()) {
            Integer idU = res.get(0).getEmployeeUserID();
            List<Usuarios> r2 = uRepository.findByUserIDAndUserPassword(idU, pass);
            if (!r2.isEmpty()) return r2.get(0);
            else return new Usuarios();
        }else return new Usuarios();
    }

    public List<Usuarios> getEmployeesType(String type){
        List<Empleados> res = repository.findByEmployeeType(type);
        if(!res.isEmpty()) {
            List<Usuarios> usuarios = new ArrayList<>();
            for(Empleados empleado: res){
                Usuarios usuario = uRepository.findByUserID(empleado.getEmployeeUserID());
                usuarios.add(usuario);
            }
            return usuarios;
        }else return new ArrayList<Usuarios>();
    }
}
