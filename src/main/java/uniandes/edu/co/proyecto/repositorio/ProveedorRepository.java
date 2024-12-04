package uniandes.edu.co.proyecto.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.proyecto.modelo.ProductoProveedor;
import uniandes.edu.co.proyecto.modelo.Proveedor;

public interface ProveedorRepository extends MongoRepository<Proveedor,Integer>{

    // Consultar los proveedores
    @Query(value = "{}")
    List<Proveedor> buscarTodosLosProveedores();    

    // Consultar proveedor por su ID
    @Query("{_id: ?0}")
    List<Proveedor> buscarPorId(int id);

    default void insertarProveedor(Proveedor proveedor){
        save(proveedor);

    }

    // Crear un nuevo proveedor
    @Query("{ $insert: { _id: ?0, NIT: ?1, nombre: ?2, direccion: ?3, nombre_contacto: ?4, telefono_contacto: ?5, productosProveedor: ?5,  ordenesCompra: ?6 } }")
    void insertarBar(int id, String NIT, String nombre, String direccion, String nombre_contacto, String telefono_contacto, List<ProductoProveedor>  productosProveedor, List<Integer> ordenesCompra);

    // Actualizar un proveedor por su IDs
    @Query("{ _id: ?0 }")
    @Update("{ $set: { NIT: ?1, nombre: ?2, direccion: ?3, nombre_contacto: ?4, telefono_contacto: ?5, productosProveedor: ?5,  ordenesCompra: ?6}}")
    void actualizarProveedor(int id, String NIT, String nombre, String direccion, String nombre_contacto, String telefono_contacto, List<ProductoProveedor>  productosProveedor, List<Integer> ordenesCompra);
}
