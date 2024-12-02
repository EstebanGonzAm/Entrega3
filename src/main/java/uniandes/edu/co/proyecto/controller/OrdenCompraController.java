package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.OrdenCompraEntity;
import uniandes.edu.co.proyecto.repositorio.OrdenCompraRepository;

@RestController
public class OrdenCompraController {

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    // Obtener todas las órdenes de compra
    @GetMapping("/ordenes")
    public Collection<OrdenCompraEntity> ordenesCompra() {
        return ordenCompraRepository.darOrdenesCompra();
    }

    // Guardar una nueva orden de compra
    @PostMapping("/ordenes/new/save")
    public ResponseEntity<String> ordenCompraGuardar(@RequestBody OrdenCompraEntity ordenCompra) {
        try {
            ordenCompraRepository.insertarOrdenCompra(ordenCompra.getFechaCreacion(), ordenCompra.getEstado(), ordenCompra.getFechaEntrega(), ordenCompra.getId_infoextraorden());
            return new ResponseEntity<>("Orden de compra creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la orden de compra", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // actualizar una orden de compra existente
    @PutMapping("ordenes/{id_ordencompra}/edit/save")
    public ResponseEntity<String> actualizarOrdenCompra(@PathVariable("id_ordencompra") int id_ordencompra, @RequestBody OrdenCompraEntity ordenCompra) {
        try {
            ordenCompraRepository.actualizarOrdenCompra(id_ordencompra,
            ordenCompra.getFechaCreacion(),
            ordenCompra.getEstado(),
            ordenCompra.getFechaEntrega(),
            ordenCompra.getId_infoextraorden());
            return new ResponseEntity<>("ProveedorEntity actualizado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el proveedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar una orden de compra
    @GetMapping("/ordenesCompra/{id}/delete")
    public ResponseEntity<String> ordenCompraEliminar(@PathVariable("id") int id) {
        try {
            ordenCompraRepository.eliminarOrdenCompra(id);
            return new ResponseEntity<>("Orden de compra eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la orden de compra", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
