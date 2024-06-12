package mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
public class Usuarios {
    @Getter @Setter
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "userid")
    private Integer userID;
    @Getter @Setter
    @Column(name = "username")
    private String userName;
    @Getter @Setter
    @Column(name = "useremail")
    private String userEmail;
    @Getter @Setter
    @Column(name = "userphone")
    private String userPhone;
    @Getter @Setter
    @Column(name = "userpassword")
    private String userPassword;
}
