package upeu.edu.pe.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso extends PanacheEntity {

    @Column(nullable = false, unique = true, length = 20)
    public String codigo;

    @Column(nullable = false, length = 120)
    public String nombre;

    @Column(nullable = false)
    public Integer creditos;

    @Column(length = 120)
    public String docente;

    @Column(nullable = false)
    public Boolean estado;
}