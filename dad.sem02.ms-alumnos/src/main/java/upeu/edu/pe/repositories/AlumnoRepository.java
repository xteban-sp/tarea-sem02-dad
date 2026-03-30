package upeu.edu.pe.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import upeu.edu.pe.entities.Alumno;

@ApplicationScoped
public class AlumnoRepository implements PanacheRepository<Alumno> {

    public Alumno findByCodigo(String codigo) {
        return find("codigo", codigo).firstResult();
    }

    public Alumno findByEmail(String email) {
        return find("email", email).firstResult();
    }
}