package com.jmunoz.springboot.app.productos.controllers;

import com.jmunoz.springboot.app.productos.models.entity.Producto;
import com.jmunoz.springboot.app.productos.models.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductoController {

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private IProductoService productoService;

    @GetMapping("/listar")
    public List<Producto> listar() {
        return productoService.findAll().stream().map(p -> {
            p.setPort(port);
            return p;
        }).collect(Collectors.toList());
    }

    @GetMapping("/ver/{id}")
    public Producto detalle(@PathVariable Long id) {
        Producto producto = productoService.findById(id);
        producto.setPort(port);

        // Simulando error para que lo maneje Hystrix en el proyecto de microservicio
        // https://github.com/JoseManuelMunozManzano/springboot-servicio-item-client
        // Commit: Hystrix. Cortocircuito y camino alternativo
        boolean ok = false;
        if (!ok) {
            throw new RuntimeException("No se pudo cargar el producto!");
        }

        return producto;
    }
}
