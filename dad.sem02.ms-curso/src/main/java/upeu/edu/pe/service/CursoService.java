package upeu.edu.pe.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import upeu.edu.pe.dtos.CursoCreateDTO;
import upeu.edu.pe.dtos.CursoDTO;
import upeu.edu.pe.entities.Curso;
import upeu.edu.pe.mappers.CursoMapper;
import upeu.edu.pe.repositories.CursoRepository;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CursoService {

    @Inject
    CursoRepository cursoRepository;

    public List<CursoDTO> listar() {
        return cursoRepository.listAll()
                .stream()
                .map(CursoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CursoDTO buscarPorId(Long id) {
        Curso curso = cursoRepository.findById(id);

        if (curso == null) {
            throw new WebApplicationException("Curso no encontrado", Response.Status.NOT_FOUND);
        }

        return CursoMapper.toDTO(curso);
    }

    @Transactional
    public CursoDTO crear(CursoCreateDTO dto) {
        if (cursoRepository.findByCodigo(dto.codigo) != null) {
            throw new WebApplicationException("Ya existe un curso con ese código", Response.Status.CONFLICT);
        }

        Curso curso = CursoMapper.toEntity(dto);
        cursoRepository.persist(curso);

        return CursoMapper.toDTO(curso);
    }

    @Transactional
    public CursoDTO actualizar(Long id, CursoCreateDTO dto) {
        Curso curso = cursoRepository.findById(id);

        if (curso == null) {
            throw new WebApplicationException("Curso no encontrado", Response.Status.NOT_FOUND);
        }

        Curso cursoCodigo = cursoRepository.findByCodigo(dto.codigo);
        if (cursoCodigo != null && !cursoCodigo.id.equals(id)) {
            throw new WebApplicationException("Ya existe otro curso con ese código", Response.Status.CONFLICT);
        }

        CursoMapper.updateEntity(curso, dto);

        return CursoMapper.toDTO(curso);
    }

    @Transactional
    public void eliminar(Long id) {
        Curso curso = cursoRepository.findById(id);

        if (curso == null) {
            throw new WebApplicationException("Curso no encontrado", Response.Status.NOT_FOUND);
        }

        cursoRepository.delete(curso);
    }
}
