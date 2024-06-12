package mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "contenidos")
public class Contenidos {
    @Getter @Setter
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "containsid")
    private Integer containsID;
    @Getter @Setter
    @Column(name = "containsorderid")
    private Integer containsOrderID;
    @Getter @Setter
    @Column(name = "containsproductid")
    private Integer containsProductID;
    @Getter @Setter
    @Column(name = "containsquantity")
    private Integer containsQuantity;
}
