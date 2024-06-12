package mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "asignados")
public class Asignados {
    @Getter @Setter
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "assignedid")
    private Integer assignedID;
    @Getter @Setter
    @Column(name = "assigneddate")
    private String assignedDate;
    @Getter @Setter
    @Column(name = "assignedorderid")
    private Integer assignedOrderID;
    @Getter @Setter
    @Column(name = "assignedemployeeid")
    private Integer assignedEmployeeID;
}
