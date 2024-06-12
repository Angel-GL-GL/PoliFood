package mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.repository;

import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.models.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpleadosRepository extends JpaRepository<Empleados, Integer> {
    //SELECT * FROM empleados WHERE employeetype = type;
    List<Empleados> findByEmployeeType(String type);
    //SELECT * FROM empleados WHERE employeeid = id;
    List<Empleados> findByEmployeeID(Integer id);
    //SELECT * FROM empleados WHERE employeeuserid = id;
    Empleados findByEmployeeUserID(Integer id);
}