package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ProductoEntity;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer> {

    @Query(value = "SELECT * FROM Producto", nativeQuery = true)
    Collection<ProductoEntity> darProductos();

    @Query(value = "SELECT * FROM producto WHERE id_producto = :id_producto", nativeQuery = true)
    ProductoEntity darProducto(@Param("id_producto") String id_producto);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO producto(id_producto, codigoBarras,nombre, precioUnitarioVenta, presentacion, cantidadPresentacion, unidadMedida, fechaExpiracion, id_especificacionempacado, bodega_id) VALUES(proyecto_sequence.nextval, :codigoBarras, :nombre, :precioUnitarioVenta, :presentacion, :cantidadPresentacion, :unidadMedida, :fechaExpiracion, :id_especificacionempacado, :bodega_id)", nativeQuery = true)
    void insertarProducto(@Param("codigoBarras") String codigoBarras, @Param("nombre") String nombre, @Param("precioUnitarioVenta") Integer precioUnitarioVenta, @Param("presentacion") String presentacion, @Param("cantidadPresentacion") Integer cantidadPresentacion, @Param("unidadMedida") String unidadMedida, @Param("fechaExpiracion") Date fechaExpiracion, @Param("id_especificacionempacado") Integer id_especificacionempacado, @Param("bodega_id") Integer bodega_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE producto SET codigoBarras=:codigoBarras, nombre=:nombre, precioUnitarioVenta=:precioUnitarioVenta, presentacion=:presentacion, cantidadPresentacion=:cantidadPresentacion, unidadMedida=:unidadMedida, fechaExpiracion=:fechaExpiracion, id_especificacionempacado=:id_especificacionempacado, bodega_id=:bodega_id  WHERE id_producto=:id_producto", nativeQuery = true)
    void actualizarProducto(@Param("id_producto") Integer id_producto, @Param("codigoBarras") String codigoBarras, @Param("nombre") String nombre, @Param("precioUnitarioVenta") Integer precioUnitarioVenta, @Param("presentacion") String presentacion, @Param("cantidadPresentacion") Integer cantidadPresentacion, @Param("unidadMedida") String unidadMedida, @Param("fechaExpiracion") Date fechaExpiracion, @Param("id_especificacionempacado") Integer id_especificacionempacado, @Param("bodega_id") Integer bodega_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM producto WHERE id_producto = :id_producto", nativeQuery = true)
    void eliminarProducto(@Param("id_producto") Integer id_producto);

}
