package uniandes.edu.co.proyecto.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.modelo.ProductoNivelReorden;
import uniandes.edu.co.proyecto.modelo.Sucursal;

public interface SucursalRepository extends MongoRepository<Sucursal,Integer>{

    @Query(value = "{}")
    List<Sucursal> buscarTodasLasSucursales();    

    @Query("{_id: ?0}")
    List<Sucursal> buscarPorId(int id);

    default void insertarSucursal(Sucursal sucursal){
        save(sucursal);

    }

    // Agregar/Crear un bar por su ID
    @Query("{ _id: ?0 }")
    @Update("{ $set: { nombre: ?1, direccion: ?2, telefono: ?3, ciudad: ?4, bodegas: ?5, nivel_minimo_reorden: ?6 }}")
    void actualizarBodegaEnSucursal(int id, String nombre, String direccion, String telefono, String ciudad, List<Bodega> bodegas, List<ProductoNivelReorden> nivel_minimo_reorden);
}
