package mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.repository;

import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.models.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductosRepository extends JpaRepository<Productos, Integer> {
    //SELECT * FROM productos WHERE productcategory = category;
    List<Productos> findByProductCategory(String category);
    //SELECT * FROM productos WHERE productid = id;
    List<Productos> findByProductID(Integer id);
}