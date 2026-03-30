package upeu.edu.pe.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import upeu.edu.pe.dtos.AlumnoCreateDTO;
import upeu.edu.pe.dtos.AlumnoDTO;
import upeu.edu.pe.entities.Alumno;
import upeu.edu.pe.mappers.AlumnoMapper;
import upeu.edu.pe.repositories.AlumnoRepository;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class AlumnoService {

    @Inject
    AlumnoRepository alumnoRepository;

    public List<AlumnoDTO> listar() {
        return alumnoRepository.listAll()
                .stream()
                .map(AlumnoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AlumnoDTO buscarPorId(Long id) {
        Alumno alumno = alumnoRepository.findById(id);

        if (alumno == null) {
            throw new WebApplicationException("Alumno no encontrado", Response.Status.NOT_FOUND);
        }

        return AlumnoMapper.toDTO(alumno);
    }

    @Transactional
    public AlumnoDTO crear(AlumnoCreateDTO dto) {
        if (alumnoRepository.findByCodigo(dto.codigo) != null) {
            throw new WebApplicationException("Ya existe un alumno con ese código", Response.Status.CONFLICT);
        }

        if (alumnoRepository.findByEmail(dto.email) != null) {
            throw new WebApplicationException("Ya existe un alumno con ese email", Response.Status.CONFLICT);
        }

        Alumno alumno = AlumnoMapper.toEntity(dto);
        alumnoRepository.persist(alumno);

        return AlumnoMapper.toDTO(alumno);
    }

    @Transactional
    public AlumnoDTO actualizar(Long id, AlumnoCreateDTO dto) {
        Alumno alumno = alumnoRepository.findById(id);

        if (alumno == null) {
            throw new WebApplicationException("Alumno no encontrado", Response.Status.NOT_FOUND);
        }

        Alumno alumnoCodigo = alumnoRepository.findByCodigo(dto.codigo);
        if (alumnoCodigo != null && !alumnoCodigo.id.equals(id)) {
            throw new WebApplicationException("Ya existe otro alumno con ese código", Response.Status.CONFLICT);
        }

        Alumno alumnoEmail = alumnoRepository.findByEmail(dto.email);
        if (alumnoEmail != null && !alumnoEmail.id.equals(id)) {
            throw new WebApplicationException("Ya existe otro alumno con ese email", Response.Status.CONFLICT);
        }

        AlumnoMapper.updateEntity(alumno, dto);

        return AlumnoMapper.toDTO(alumno);
    }

    @Transactional
    public void eliminar(Long id) {
        Alumno alumno = alumnoRepository.findById(id);

        if (alumno == null) {
            throw new WebApplicationException("Alumno no encontrado", Response.Status.NOT_FOUND);
        }

        alumnoRepository.delete(alumno);
    }
}