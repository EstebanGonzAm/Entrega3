package uniandes.edu.co.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.OrdenCompra;
import uniandes.edu.co.proyecto.repositorio.OrdenCompraRepository;


@RestController
@RequestMapping("/ordenes_compra")
public class OrdenCompraController {

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    //Obtener las ordenes de compra
    @GetMapping("")
    public ResponseEntity<List<OrdenCompra>> obtenerTodasLasOrdenesCompra() {
        try {
            List<OrdenCompra> ordenesCompra = ordenCompraRepository.buscarTodasLasOrdenesCompra();
            return ResponseEntity.ok(ordenesCompra);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}