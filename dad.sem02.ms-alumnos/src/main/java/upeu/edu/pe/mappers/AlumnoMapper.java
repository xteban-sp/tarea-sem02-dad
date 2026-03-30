package upeu.edu.pe.mappers;

import upeu.edu.pe.dtos.AlumnoCreateDTO;
import upeu.edu.pe.dtos.AlumnoDTO;
import upeu.edu.pe.entities.Alumno;

public class AlumnoMapper {

    public static AlumnoDTO toDTO(Alumno alumno) {
        if (alumno == null) return null;

        AlumnoDTO dto = new AlumnoDTO();
        dto.id = alumno.id;
        dto.codigo = alumno.codigo;
        dto.nombres = alumno.nombres;
        dto.apellidos = alumno.apellidos;
        dto.email = alumno.email;
        dto.telefono = alumno.telefono;
        dto.estado = alumno.estado;
        return dto;
    }

    public static Alumno toEntity(AlumnoCreateDTO dto) {
        if (dto == null) return null;

        Alumno alumno = new Alumno();
        alumno.codigo = dto.codigo;
        alumno.nombres = dto.nombres;
        alumno.apellidos = dto.apellidos;
        alumno.email = dto.email;
        alumno.telefono = dto.telefono;
        alumno.estado = dto.estado;
        return alumno;
    }

    public static void updateEntity(Alumno alumno, AlumnoCreateDTO dto) {
        alumno.codigo = dto.codigo;
        alumno.nombres = dto.nombres;
        alumno.apellidos = dto.apellidos;
        alumno.email = dto.email;
        alumno.telefono = dto.telefono;
        alumno.estado = dto.estado;
    }
}