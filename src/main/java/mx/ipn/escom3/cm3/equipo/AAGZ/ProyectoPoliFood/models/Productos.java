package mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "productos")
public class Productos {
    @Getter @Setter
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "productid")
    private Integer productID;
    @Getter @Setter
    @Column(name = "productname")
    private String productName;
    @Getter @Setter
    @Column(name = "productprice")
    private Double productPrice;
    @Getter @Setter
    @Column(name = "productquantity")
    private Integer productQuantity;
    @Getter @Setter
    @Column(name = "productcategory")
    private String productCategory;
    @Getter @Setter
    @Column(name = "productimage")
    private String productImage;
    @Getter @Setter
    @Column(name = "productdescription")
    private String productDescription;
}
