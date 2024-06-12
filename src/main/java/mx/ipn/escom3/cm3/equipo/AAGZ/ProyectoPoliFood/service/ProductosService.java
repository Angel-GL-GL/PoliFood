package mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.service;

import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.models.Productos;
import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductosService {

    @Autowired
    private ProductosRepository repository;

    public List<Productos> getAllProducts(){return repository.findAll();}

    public Productos getProduct(Integer id){
        List<Productos> res = repository.findByProductID(id);
        if(!res.isEmpty()) return res.get(0);
        else return new Productos();
    }

    public List<Productos> getProduct(String category){
        List<Productos> res = repository.findByProductCategory(category);
        if(!res.isEmpty()) return res;
        else return new ArrayList<Productos>();
    }
}
