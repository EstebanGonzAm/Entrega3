package uniandes.edu.co.proyecto.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.proyecto.modelo.OrdenCompra;

public interface OrdenCompraRepository extends MongoRepository<OrdenCompra,Integer> {

    // Consultar los productos
    @Query(value = "{}")
    List<OrdenCompra> buscarTodasLasOrdenesCompra();    

    // Consultar orden compra por su ID
    @Query("{_id: ?0}")
    List<OrdenCompra> buscarPorId(int id);  
}
