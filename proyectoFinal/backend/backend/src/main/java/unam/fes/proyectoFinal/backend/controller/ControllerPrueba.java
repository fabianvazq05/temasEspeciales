package unam.fes.proyectoFinal.backend.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerPrueba {
    @GetMapping("/prueba/")
    public String prueba(){
        return "he is aliveee";
    }

}
