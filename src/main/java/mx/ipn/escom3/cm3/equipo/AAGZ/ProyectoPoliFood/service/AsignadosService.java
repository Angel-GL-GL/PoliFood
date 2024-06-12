package mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.service;

import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.models.Asignados;
import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.models.Pedidos;
import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.repository.AsignadosRepository;
import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AsignadosService {

    @Autowired
    private AsignadosRepository repository;
    @Autowired
    private PedidosRepository oRepository;

    public List<Asignados> getAllAssigned(){return repository.findAll();}

    public List<Asignados> getAllAssignedEmployee(Integer id){
        List<Asignados> res = repository.findByAssignedEmployeeID(id);
        if(!res.isEmpty()) {
            List<Asignados> asignados = new ArrayList<>();
            //Solo los que siguen siendo asignados y no tienen otro estado
            for(Asignados a: res){
                Pedidos pedido = oRepository.findByOrderID(a.getAssignedOrderID()).get(0);
                if(pedido.getOrderState().equals("Asignada")) asignados.add(a);
            }
            return asignados;
        }else return new ArrayList<Asignados>();
    }

    public void setAssigned(Asignados asignado){
        repository.save(asignado);
    }
}
