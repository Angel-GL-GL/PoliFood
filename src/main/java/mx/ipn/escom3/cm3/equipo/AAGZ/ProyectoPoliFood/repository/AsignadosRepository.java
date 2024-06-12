package mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.repository;

import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.models.Asignados;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AsignadosRepository extends JpaRepository<Asignados, Integer> {
    //SELECT * FROM asignados WHERE assignedemployeeid = employeeid;
    List<Asignados> findByAssignedEmployeeID(Integer employeeID);
}