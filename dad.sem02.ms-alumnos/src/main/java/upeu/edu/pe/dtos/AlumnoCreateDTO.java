package upeu.edu.pe.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AlumnoCreateDTO {

    @NotBlank(message = "El código es obligatorio")
    @Size(max = 20, message = "El código no debe exceder 20 caracteres")
    public String codigo;

    @NotBlank(message = "Los nombres son obligatorios")
    @Size(max = 100, message = "Los nombres no deben exceder 100 caracteres")
    public String nombres;

    @NotBlank(message = "Los apellidos son obligatorios")
    @Size(max = 100, message = "Los apellidos no deben exceder 100 caracteres")
    public String apellidos;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email no es válido")
    @Size(max = 120, message = "El email no debe exceder 120 caracteres")
    public String email;

    @Size(max = 20, message = "El teléfono no debe exceder 20 caracteres")
    public String telefono;

    @NotNull(message = "El estado es obligatorio")
    public Boolean estado;
}