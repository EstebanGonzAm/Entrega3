package uniandes.edu.co.proyecto.modelo;

import java.util.List;

import lombok.ToString;

@ToString
public class ProductoOrdenCompra {

    private int producto_id;
    private int precio_acordado;
    private int cantidad;

    public ProductoOrdenCompra(int producto_id, int precio_acordado, int cantidad) {
        this.producto_id = producto_id;
        this.precio_acordado = precio_acordado;
        this.cantidad = cantidad;
    }

    public int getId_producto() {
        return producto_id;
    }
    public void setId_producto(int producto_id) {
        this.producto_id = producto_id;
    }

    public int getPrecio_acordado() {
        return precio_acordado;
    }
    public void setPrecio_acordado(int precio_acordado) {
        this.precio_acordado = precio_acordado;
    }

    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
