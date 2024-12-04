package uniandes.edu.co.proyecto.modelo;

import lombok.ToString;

@ToString
public class ProductoBodega {

    private int producto_id;
    private int cantidad;
    private int costo_promedio;

    public ProductoBodega(int producto_id, int cantidad, int costo_promedio) {
        this.producto_id = producto_id;
        this.cantidad = cantidad;
        this.costo_promedio = costo_promedio;
    }

    public int getProducto_id() {
        return producto_id;
    }
    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
    }

    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCosto_promedio() {
        return costo_promedio;
    }
    public void setCosto_promedio(int costo_promedio) {
        this.costo_promedio = costo_promedio;
    }

}
