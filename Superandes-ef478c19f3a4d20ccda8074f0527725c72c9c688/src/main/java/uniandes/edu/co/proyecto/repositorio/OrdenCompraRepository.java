package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.OrdenCompraEntity;

public interface OrdenCompraRepository extends JpaRepository<OrdenCompraEntity, Integer> {

    @Query(value = "SELECT * FROM OrdenCompra", nativeQuery = true)
    Collection<OrdenCompraEntity> darOrdenesCompra();

    @Query(value = "SELECT * FROM OrdenCompra WHERE id_ordencompra = :id_ordencompra", nativeQuery = true)
    OrdenCompraEntity darOrdenCompra(@Param("id_ordencompra") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO OrdenCompra(fecha_Creacion, estado, fecha_Entrega) VALUES(:fecha_Creacion, :estado, :fecha_Entrega, :id_infoextraorden)", nativeQuery = true)
    void insertarOrdenCompra(@Param("fecha_Creacion") Date fecha_Creacion, @Param("estado") String estado, @Param("fecha_Entrega") Date fechaEntrega, @Param("id_infoextraorden") Integer id_infoextraorden);

    @Modifying
    @Transactional
    @Query(value = "UPDATE OrdenCompra SET fecha_Creacion = :fecha_Creacion, estado = :estado, fecha_Entrega = :fecha_Entrega, id_infoextraorden = :id_infoextraorden WHERE id_ordencompra = :id_ordencompra", nativeQuery = true)
    void actualizarOrdenCompra(@Param("id_ordencompra") Integer id_ordencompra,
                                @Param("fecha_Creacion") Date fecha_Creacion, 
                                @Param("estado") String estado, 
                                @Param("fecha_Entrega") Date fecha_Entrega,
                                @Param("id_infoextraorden") Integer id_infoextraorden);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM OrdenCompra WHERE id_ordencompra = :id_ordencompra", nativeQuery = true)
    void eliminarOrdenCompra(@Param("id_ordencompra") int id_ordencompra);
}
