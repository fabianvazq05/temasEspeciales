package fes.aragon.unam.mx.compusREST.controlador;

import fes.aragon.unam.mx.compusREST.contenedor.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ClienteRESTcontroller {

    @GetMapping("/ping/")
    public String ping(){
        return "pong";
    }
    @PostMapping("/crear")
    public Producto crearProducto(@RequestBody Producto nuevoProducto) {
        System.out.println("Recibí el producto: " + nuevoProducto.getNombre());
        listaProductos.add(nuevoProducto);
        return nuevoProducto;
    }

    private java.util.List<Producto> listaProductos = new java.util.ArrayList<>();
    @GetMapping("/listar")
    public java.util.List<Producto> listarProductos() {
        return listaProductos;
    }


}
