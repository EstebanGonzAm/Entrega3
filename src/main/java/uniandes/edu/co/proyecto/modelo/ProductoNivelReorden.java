package uniandes.edu.co.proyecto.modelo;

import lombok.ToString;

@ToString
public class ProductoNivelReorden {

    private int producto_id;
    private int nivel_reorden;


    public ProductoNivelReorden(int producto_id, int nivel_reorden) {
        this.producto_id = producto_id;
        this.nivel_reorden = nivel_reorden;
    }

    public int getProducto_id() {
        return producto_id;
    }
    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
    }

    public int getNivel_reorden() {
        return nivel_reorden;
    }
    public void setNivel_reorden(int nivel_reorden) {
        this.nivel_reorden = nivel_reorden;
    }
}

