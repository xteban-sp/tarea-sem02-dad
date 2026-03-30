package upeu.edu.pe.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CursoCreateDTO {

    @NotBlank(message = "El código es obligatorio")
    @Size(max = 20, message = "El código no debe exceder 20 caracteres")
    public String codigo;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 120, message = "El nombre no debe exceder 120 caracteres")
    public String nombre;

    @NotNull(message = "Los créditos son obligatorios")
    @Min(value = 1, message = "Los créditos deben ser mayor o igual a 1")
    public Integer creditos;

    @Size(max = 120, message = "El docente no debe exceder 120 caracteres")
    public String docente;

    @NotNull(message = "El estado es obligatorio")
    public Boolean estado;
}