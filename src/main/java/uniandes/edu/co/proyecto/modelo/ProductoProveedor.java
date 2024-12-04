package uniandes.edu.co.proyecto.modelo;
import java.util.List;

import lombok.ToString;

@ToString
public class ProductoProveedor {

    private int id_producto;
    private int precio_acordado;

    public ProductoProveedor(int id_producto, int precio_acordado) {
        this.id_producto = id_producto;
        this.precio_acordado = precio_acordado;
    }

    public int getId_producto() {
        return id_producto;
    }
    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getPrecio_acordado() {
        return precio_acordado;
    }
    public void setPrecio_acordado(int precio_acordado) {
        this.precio_acordado = precio_acordado;
    }

}
