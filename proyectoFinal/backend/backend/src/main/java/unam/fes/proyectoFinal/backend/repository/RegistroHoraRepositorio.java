package unam.fes.proyectoFinal.backend.repository;

import unam.fes.proyectoFinal.backend.modelo.RegistrarHora;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RegistroHoraRepositorio extends JpaRepository<RegistrarHora, Long> {
    // Aquí es donde vive este método
    List<RegistrarHora> findByAlumnoId(Long alumnoId);
    }
