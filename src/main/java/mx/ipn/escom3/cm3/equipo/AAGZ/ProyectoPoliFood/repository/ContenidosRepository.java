package mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.repository;

import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.models.Contenidos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContenidosRepository extends JpaRepository<Contenidos, Integer> {
    //SELECT * FROM contenidos WHERE containsorderid = orderid;
    List<Contenidos> findByContainsOrderID(Integer orderID);
}