package mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.repository;

import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.models.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidosRepository extends JpaRepository<Pedidos, Integer> {
    //SELECT * FROM pedidos WHERE orderid = id;
    List<Pedidos> findByOrderID(Integer id);
    //SELECT * FROM pedidos WHERE orderuserid = id;
    List<Pedidos> findByOrderUserID(Integer id);
    //SELECT * FROM pedidos WHERE orderstate = state;
    List<Pedidos> findByOrderState(String state);
}