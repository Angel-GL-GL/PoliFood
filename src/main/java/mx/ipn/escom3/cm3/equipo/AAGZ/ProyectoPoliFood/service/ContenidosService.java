package mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.service;

import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.models.Contenidos;
import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.models.Productos;
import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.repository.ContenidosRepository;
import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.repository.PedidosRepository;
import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContenidosService {

    @Autowired
    private ContenidosRepository repository;
    @Autowired
    private ProductosRepository pRepository;

    public List<Contenidos> getContByOrder(Integer id){
        List<Contenidos> res = repository.findByContainsOrderID(id);
        if(!res.isEmpty()) return res;
        else return new ArrayList<Contenidos>();
    }

    public Double getTotal(Integer id){
        List<Contenidos> res = repository.findByContainsOrderID(id);
        if(!res.isEmpty()){
            Double total = 0.0;
            for(Contenidos contenido: res){
                Productos producto = pRepository.findByProductID(contenido.getContainsProductID()).get(0);
                total += contenido.getContainsQuantity() * producto.getProductPrice();
            }
            return total;
        }
        else return 0.0;
    }

    public void setCont(Contenidos contenido){
        repository.save(contenido);
    }
}
