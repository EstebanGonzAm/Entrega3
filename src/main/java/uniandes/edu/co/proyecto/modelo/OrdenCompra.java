package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection="ordenes_compra")
@ToString
public class OrdenCompra {

    @Id
    private int id;
    private int sucursal_id;
    private int proveedor_id;
    private Date ETA_orden;
    private String estado;
    private List<ProductoOrdenCompra> productosOrdenCompra;
    public OrdenCompra(int id, int sucursal_id, int proveedor_id, Date ETA_orden, String estado, List<ProductoOrdenCompra> productosOrdenCompra) {
        this.id = id;
        this.sucursal_id = sucursal_id;
        this.proveedor_id = proveedor_id;
        this.ETA_orden = ETA_orden;
        this.estado = estado;
        this.productosOrdenCompra = productosOrdenCompra;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getSucursal_id() {
        return sucursal_id;
    }
    public void setSucursal_id(int sucursal_id) {
        this.sucursal_id = sucursal_id;
    }
    public int getProveedor_id() {
        return proveedor_id;
    }
    public void setProveedor_id(int proveedor_id) {
        this.proveedor_id = proveedor_id;
    }
    public Date getETA_orden() {
        return ETA_orden;
    }
    public void setETA_orden(Date ETA_orden) {
        this.ETA_orden = ETA_orden;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<ProductoOrdenCompra> getProductosOrdenCompra() {
        return productosOrdenCompra;
    }
    public void setProductosOrdenCompra(List<ProductoOrdenCompra> productosOrdenCompra) {
        this.productosOrdenCompra = productosOrdenCompra;
    }
    
}
