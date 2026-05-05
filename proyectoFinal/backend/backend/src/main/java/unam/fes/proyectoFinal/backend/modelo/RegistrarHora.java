package unam.fes.proyectoFinal.backend.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class RegistrarHora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;
    private int horasDiferencia;
    private String actividades;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Alumno alumno;
}
