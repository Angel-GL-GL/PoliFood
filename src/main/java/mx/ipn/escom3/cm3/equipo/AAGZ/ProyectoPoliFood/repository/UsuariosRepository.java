package mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.repository;

import mx.ipn.escom3.cm3.equipo.AAGZ.ProyectoPoliFood.models.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {
    //SELECT * FROM usuarios WHERE userid = id;
    Usuarios  findByUserID(Integer id);
    //SELECT * FROM usuarios WHERE useremail = email AND userpasword = password;
    List<Usuarios> findByUserEmailAndUserPassword(String email, String password);
    //SELECT * FROM usuarios WHERE userid = id AND userpassword = password;
    List<Usuarios>  findByUserIDAndUserPassword(Integer id, String password);
    //Verifica que exista el email
    Boolean existsByUserEmail(String email);
}