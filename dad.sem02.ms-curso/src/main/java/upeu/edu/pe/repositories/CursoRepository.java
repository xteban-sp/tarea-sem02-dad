package upeu.edu.pe.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import upeu.edu.pe.entities.Curso;

@ApplicationScoped
public class CursoRepository implements PanacheRepository<Curso> {

    public Curso findByCodigo(String codigo) {
        return find("codigo", codigo).firstResult();
    }
}