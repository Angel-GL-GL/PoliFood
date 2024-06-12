package mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pedidos")
public class Pedidos {
    @Getter @Setter
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "orderid")
    private Integer orderID;
    @Getter @Setter
    @Column(name = "orderdate")
    private String orderDate;
    @Getter @Setter
    @Column(name = "orderaddress")
    private String orderAddress;
    @Getter @Setter
    @Column(name = "orderstate")
    private String orderState;
    @Getter @Setter
    @Column(name = "ordertotal")
    private Double orderTotal;
    @Getter @Setter
    @Column(name = "orderdelivereddate")
    private String orderDeliveredDate;
    @Getter @Setter
    @Column(name = "orderextrainfo")
    private String orderExtraInfo;
    @Getter @Setter
    @Column(name = "orderuserid")
    private Integer orderUserID;
}
