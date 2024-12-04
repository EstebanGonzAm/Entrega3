package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.proyecto.modelo.Categoria;
import uniandes.edu.co.proyecto.modelo.Producto;

public interface ProductoRepository extends MongoRepository<Producto,Integer> {

    // Consultar los productos
    @Query(value = "{}")
    List<Producto> buscarTodosLosProductos();    

     // Crear un nuevo producto
    @Query("{ $insert: { _id: ?0, codigoBarras: ?1, nombre: ?2, precioUnitarioVenta: ?3, presentacion: ?4, cantidadPresentacion: ?5, unidadMedida: ?5,  fechaExpiracion: ?6 , especificacionEmpacadoVolumen: ?7,especificacionEmpacadoPeso: ?8, categoria_producto: ?9 } }")
    void insertarProducto(int id, String codigoBarras, String nombre, int precioUnitarioVenta, String presentacion, int cantidadPresentacion, String  unidadMedida, Date fechaExpiracion, int especificacionEmpacadoVolumen, int especificacionEmpacadoPeso, List<Categoria> categoria_producto);
    
    // Agregar/Crear una categoria
    @Query("{ _id: ?0 }")
    @Update("{ $set: { codigoBarras: ?1, nombre: ?2, precioUnitarioVenta: ?3, presentacion: ?4, cantidadPresentacion: ?5, unidadMedida: ?5,  fechaExpiracion: ?6 , especificacionEmpacadoVolumen: ?7,especificacionEmpacadoPeso: ?8, categoria_producto: ?9}}")
    void agregarCategoria(int id, String codigoBarras, String nombre, int precioUnitarioVenta, String presentacion, int cantidadPresentacion, String  unidadMedida, Date fechaExpiracion, int especificacionEmpacadoVolumen, int especificacionEmpacadoPeso, List<Categoria> categoria_producto);
}
