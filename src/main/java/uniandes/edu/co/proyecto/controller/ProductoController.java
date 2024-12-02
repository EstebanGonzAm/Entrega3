package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.ProductoEntity;
import uniandes.edu.co.proyecto.repositorio.ProductoRepository;

@RestController
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/productos")
    public Collection<ProductoEntity> darproductos() {
        return productoRepository.darProductos();
    }

    // Obtener todos los productos
    @GetMapping("/algo")
    public ResponseEntity<Collection<ProductoEntity>> prueba() {
        try {
            Collection<ProductoEntity> productos = productoRepository.darProductos();
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener un producto por código de barras
    @GetMapping("/{codigoBarras}")
    public ResponseEntity<ProductoEntity> darProducto(@PathVariable("codigoBarras") String codigoBarras) {
        try {
            ProductoEntity producto = productoRepository.darProducto(codigoBarras);
            if (producto != null) {
                return new ResponseEntity<>(producto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Insertar un nuevo producto
    @PostMapping("productos/new/save")
    public ResponseEntity<String> insertarProducto(@RequestBody ProductoEntity producto) {
        try {
            productoRepository.insertarProducto(
                    producto.getCodigoBarras(),
                    producto.getNombre(),
                    producto.getPrecioUnitarioVenta(),
                    producto.getPresentacion(),
                    producto.getCantidadPresentacion(),
                    producto.getUnidadMedida(),
                    producto.getFechaExpiracion(),
                    producto.getEspecificacionEmpacado(),
                    producto.getId());
            return new ResponseEntity<>("ProductoEntity creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar un producto existente
    @PutMapping("productos/{id_producto}/edit/save")
    public ResponseEntity<String> actualizarProducto(@PathVariable("id_producto") Integer id_producto,
            @RequestBody ProductoEntity producto) {
        try {
            productoRepository.actualizarProducto(id_producto,
                    producto.getCodigoBarras(),
                    producto.getNombre(),
                    producto.getPrecioUnitarioVenta(),
                    producto.getPresentacion(),
                    producto.getCantidadPresentacion(),
                    producto.getUnidadMedida(),
                    producto.getFechaExpiracion(),
                    producto.getEspecificacionEmpacado(),
                    producto.getId());
            return new ResponseEntity<>("ProductoEntity actualizado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error al actualizar el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar un producto por código de barras
    @DeleteMapping("/{codigoBarras}/delete")
    public ResponseEntity<String> eliminarProducto(@PathVariable("id_producto") Integer id_producto) {
        try {
            productoRepository.eliminarProducto(id_producto);
            return new ResponseEntity<>("ProductoEntity eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
