package uniandes.edu.co.proyecto.controller;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.Sucursal;
import uniandes.edu.co.proyecto.repositorio.SucursalInventarioRepository;
import uniandes.edu.co.proyecto.repositorio.SucursalRepository;

@RestController
@RequestMapping("/sucursales")
public class SucursalesController {

    @Autowired
    private SucursalRepository sucursalRepository;

    @Autowired
    private SucursalInventarioRepository sucursalInventarioRepository;

    // Crear una nueva sucursal
    @PostMapping("/new/save")
    public ResponseEntity<String> crearSucursal(@RequestBody Sucursal sucursal) {
        try {
            sucursalRepository.save(sucursal);
            return new ResponseEntity<>("Sucursal creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {;
            return new ResponseEntity<>("Error al crear la sucursal: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Añadir una bodega a una sucursal (crear bodega)
    @PostMapping("/{id}/edit/addBodega")
    public ResponseEntity<String> actualizarSucursalBodega(@PathVariable("id") int id, @RequestBody Sucursal sucursal) {
        try {
            sucursalRepository.actualizarBodegaEnSucursal(
                id,
                sucursal.getNombre(),
                sucursal.getDireccion(),
                sucursal.getTelefono(),
                sucursal.getCiudad(),
                sucursal.getLista_bodegas(),
                sucursal.getNivel_reorden()
            );
            return new ResponseEntity<>("Bodega creada/añadida exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la sucursal con la nueva bodega: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Añadir una bodega a una sucursal (crear bodega)
    @PostMapping("/{id}/edit/deleteBodega")
    public ResponseEntity<String> eliminarSucursalBodega(@PathVariable("id") int id, @RequestBody Sucursal sucursal) {
        try {
            sucursalRepository.actualizarBodegaEnSucursal(
                id,
                sucursal.getNombre(),
                sucursal.getDireccion(),
                sucursal.getTelefono(),
                sucursal.getCiudad(),
                sucursal.getLista_bodegas(),
                sucursal.getNivel_reorden()
            );
            return new ResponseEntity<>("Bodega eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la sucursal con la nueva bodega: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("")
    public ResponseEntity<List<Sucursal>> obtenerTodosLasSucursales() {
        try {
            List<Sucursal> sucursales = sucursalRepository.buscarTodasLasSucursales();
            return ResponseEntity.ok(sucursales);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}/inventario")
    public ResponseEntity<List<Document>> ObtenerInformacionProductosSucursal(@PathVariable("id") int id) {
        try {
            List<Document> resultado = sucursalInventarioRepository.ObtenerInformacionProductosSucursal(id);
            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}
