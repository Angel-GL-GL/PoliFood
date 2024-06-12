package mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.service;

import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.models.Pedidos;
import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.repository.ContenidosRepository;
import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidosService {

    @Autowired
    private PedidosRepository repository;

    public List<Pedidos> getAllOrders(){return repository.findAll();}

    public Pedidos getOrder(Integer id){
        List<Pedidos> res = repository.findByOrderID(id);
        if(!res.isEmpty()) return res.get(0);
        else return new Pedidos();
    }

    public List<Pedidos> getOrdersUser(Integer id){
        List<Pedidos> res = repository.findByOrderUserID(id);
        if(!res.isEmpty()) return res;
        else return new ArrayList<Pedidos>();
    }

    public List<Pedidos> getOrdersState(String state){
        List<Pedidos> res = repository.findByOrderState(state);
        if(!res.isEmpty()) return res;
        else return new ArrayList<Pedidos>();
    }

    public void saveOrder(Pedidos pedido){
        repository.save(pedido);
    }

}
