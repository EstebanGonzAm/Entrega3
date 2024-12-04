package uniandes.edu.co.proyecto.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.proyecto.modelo.Categoria;
import uniandes.edu.co.proyecto.modelo.ProductoProveedor;
import uniandes.edu.co.proyecto.modelo.Proveedor;

public interface CategoriaRepository extends MongoRepository<Categoria,Integer>{

    // Consultar los proveedores
    @Query(value = "{}")
    List<Categoria> buscarTodasLasCategorias();    

    // Crear un nuevo proveedor
    @Query("{ $insert: { _id: ?0, NIT: ?1, nombre: ?2, direccion: ?3, nombre_contacto: ?4, telefono_contacto: ?5, productosProveedor: ?5,  ordenesCompra: ?6 } }")
    void insertarCategoria(int id, String NIT, String nombre, String direccion, String nombre_contacto, String telefono_contacto, List<ProductoProveedor>  productosProveedor, List<Integer> ordenesCompra);
 
}
