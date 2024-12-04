package uniandes.edu.co.proyecto.repositorio;

import java.util.List;

import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SucursalInventarioRepository {

    private final MongoTemplate mongoTemplate;

    public SucursalInventarioRepository(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }



    public List<Document> ObtenerInformacionProductosSucursal(int idSucursal)
    {
        List<Document> pipeline = List.of(
            // Filtrar por la sucursal deseada
            new Document("$match", new Document("_id", idSucursal)),
            
            // Descomponer el array de bodegas
            new Document("$unwind", "$bodegas"),
            
            // Descomponer el array de productos dentro de cada bodega
            new Document("$unwind", "$bodegas.productos"),
            
            // Agregar el nivel mínimo de reorden basado en `producto_id`
            new Document("$addFields", new Document("nivel_reorden",
                new Document("$arrayElemAt", List.of(
                    new Document("$filter", new Document()
                        .append("input", "$nivel_minimo_reorden")
                        .append("as", "reorden")
                        .append("cond", new Document("$eq", List.of("$$reorden.producto_id", "$bodegas.productos.producto_id")))
                    ),
                    0
                ))
            )),
            
            // Proyectar los datos requeridos
            new Document("$project", new Document()
                .append("bodega", "$bodegas.nombre")
                .append("producto_id", "$bodegas.productos.producto_id")
                .append("cantidad_actual", "$bodegas.productos.cantidad")
                .append("costo_promedio", "$bodegas.productos.costo_promedio")
                .append("nivel_minimo_reorden", "$nivel_reorden.nivel_reorden")
            )
        );

        return mongoTemplate.getCollection("sucursales").aggregate(pipeline).into(new java.util.ArrayList<>());
    }

}