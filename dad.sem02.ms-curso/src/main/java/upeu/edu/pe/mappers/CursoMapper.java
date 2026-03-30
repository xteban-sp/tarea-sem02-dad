package upeu.edu.pe.mappers;

import upeu.edu.pe.dtos.CursoCreateDTO;
import upeu.edu.pe.dtos.CursoDTO;
import upeu.edu.pe.entities.Curso;

public class CursoMapper {

    public static CursoDTO toDTO(Curso curso) {
        if (curso == null) return null;

        CursoDTO dto = new CursoDTO();
        dto.id = curso.id;
        dto.codigo = curso.codigo;
        dto.nombre = curso.nombre;
        dto.creditos = curso.creditos;
        dto.docente = curso.docente;
        dto.estado = curso.estado;
        return dto;
    }

    public static Curso toEntity(CursoCreateDTO dto) {
        if (dto == null) return null;

        Curso curso = new Curso();
        curso.codigo = dto.codigo;
        curso.nombre = dto.nombre;
        curso.creditos = dto.creditos;
        curso.docente = dto.docente;
        curso.estado = dto.estado;
        return curso;
    }

    public static void updateEntity(Curso curso, CursoCreateDTO dto) {
        curso.codigo = dto.codigo;
        curso.nombre = dto.nombre;
        curso.creditos = dto.creditos;
        curso.docente = dto.docente;
        curso.estado = dto.estado;
    }
}