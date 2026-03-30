package upeu.edu.pe.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "alumno")
public class Alumno extends PanacheEntity {

    @Column(nullable = false, unique = true, length = 20)
    public String codigo;

    @Column(nullable = false, length = 100)
    public String nombres;

    @Column(nullable = false, length = 100)
    public String apellidos;

    @Column(nullable = false, unique = true, length = 120)
    public String email;

    @Column(length = 20)
    public String telefono;

    @Column(nullable = false)
    public Boolean estado;
}