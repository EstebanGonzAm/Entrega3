package uniandes.edu.co.proyecto.modelo;

import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

public class SucursalInventario {
    private String bodega;
    private String producto;
    private int id_producto;
    private int nivel_reorden;

    public SucursalInventario(){

    }

    public SucursalInventario(String bodega,String producto,int id_producto, int nivel_reorden) {
        this.bodega = bodega;
        this.producto = producto;
        this.id_producto = id_producto;
        this.nivel_reorden = nivel_reorden;

    }

    public String getBodega() {
        return bodega;
    }

    public void setBodega(String bodega) {
        this.bodega = bodega;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getNivel_reorden() {
        return nivel_reorden;
    }

    public void setNivel_reorden(int nivel_reorden) {
        this.nivel_reorden = nivel_reorden;
    }
    
}
