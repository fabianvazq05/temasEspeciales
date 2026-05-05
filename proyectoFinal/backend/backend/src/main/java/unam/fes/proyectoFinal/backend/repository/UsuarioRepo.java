package unam.fes.proyectoFinal.backend.repository;

import unam.fes.proyectoFinal.backend.modelo.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo extends JpaRepository<Alumno, Long> {
    // Spring Data JPA hará todo el trabajo de guardar y buscar por nosotros
}