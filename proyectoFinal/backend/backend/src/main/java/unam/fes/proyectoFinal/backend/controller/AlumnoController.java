package unam.fes.proyectoFinal.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unam.fes.proyectoFinal.backend.modelo.Alumno;
import unam.fes.proyectoFinal.backend.modelo.RegistrarHora;
import unam.fes.proyectoFinal.backend.repository.RegistroHoraRepositorio;
import unam.fes.proyectoFinal.backend.repository.UsuarioRepo;

@RestController
@RequestMapping("/api/alumno")
public class AlumnoController {

    @Autowired
    private RegistroHoraRepositorio registroRepo;

    @GetMapping("/{id}/total-horas")
    public Integer obtenerTotalHoras(@PathVariable Long id) {
        // Buscamos todos los registros de ese alumno y sumamos la diferencia
        return registroRepo.findByAlumnoId(id)
                .stream()
                .mapToInt(RegistrarHora::getHorasDiferencia)
                .sum();
    }

    @PostMapping("/{id}/registrar")
    public RegistrarHora guardarRegistro(@PathVariable Long id, @RequestBody RegistrarHora registro) {
        // 1. Calculamos la diferencia de tiempo
        long minutos = java.time.Duration.between(registro.getFechaEntrada(), registro.getFechaSalida()).toMinutes();

        // 2. Guardamos el cálculo (regla de negocio: no se permiten horas negativas)
        if (minutos > 0) {
            registro.setHorasDiferencia((int) (minutos / 60));
        }

        return registroRepo.save(registro);
    }

    @Autowired
    private UsuarioRepo usuarioRepo; // Asegúrate de tener este Autowired arriba

    @PostMapping("/registro/estudiante")
    public Alumno registrarAlumno(@RequestBody Alumno nuevoAlumno) {
        nuevoAlumno.setRol("ALUMNO");
        nuevoAlumno.setEstado("ACTIVO");
        return usuarioRepo.save(nuevoAlumno);
    }
}