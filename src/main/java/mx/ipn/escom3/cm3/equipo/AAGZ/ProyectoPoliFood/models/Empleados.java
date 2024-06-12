package mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "empleados")
public class Empleados {
    @Getter @Setter
    @Id
    @Column(name = "employeeid")
    private Integer employeeID;
    @Getter @Setter
    @Column(name = "employeetype")
    private String employeeType;
    @Getter @Setter
    @Column(name = "employeeuserid")
    private Integer employeeUserID;
}
