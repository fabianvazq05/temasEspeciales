package unam.fes.proyectoFinal.backend.modelo;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "usuarios")
@Data
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String cuenta; // Número de cuenta para login

    private String nombre;
    private String password;

    @Column(nullable = false)
    private String rol; // Aquí guardaremos: ADMIN, PROFESOR o ALUMNO

    private String estado; // ACTIVO, BAJA, CONCLUIDO
}
