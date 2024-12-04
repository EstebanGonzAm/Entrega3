package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection="productos")
@ToString
public class Producto {
    @Id
    private int id;
    private String codigoBarras;
    private String nombre;
    private int precioUnitarioVenta;
    private String presentacion;
    private int cantidadPresentacion;
    private String unidadMedida;
    private Date fechaExpiracion;
    private int especificacionEmpacadoVolumen;
    private int especificacionEmpacadoPeso;
    private List<Categoria> categoria_producto;
    public Producto(int id, String codigoBarras, String nombre, int precioUnitarioVenta, String presentacion, int cantidadPresentacion,
                    String unidadMedida, Date fechaExpiracion, int especificacionEmpacadoVolumen, int especificacionEmpacadoPeso,
                    List<Categoria> categoria_producto) {

        this.id = id;
        this.codigoBarras = codigoBarras;
        this.nombre = nombre;
        this.precioUnitarioVenta = precioUnitarioVenta;
        this.presentacion = presentacion;
        this.cantidadPresentacion = cantidadPresentacion;
        this.unidadMedida = unidadMedida;
        this.fechaExpiracion = fechaExpiracion;
        this.especificacionEmpacadoVolumen = especificacionEmpacadoVolumen;
        this.especificacionEmpacadoPeso = especificacionEmpacadoPeso;
        this.categoria_producto = categoria_producto;

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getcodigoBarras() {
        return codigoBarras;
    }
    public void setcodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getPrecioUnitarioVenta() {
        return precioUnitarioVenta;
    }
    public void setPrecioUnitarioVenta(int precioUnitarioVenta) {
        this.precioUnitarioVenta = precioUnitarioVenta;
    }
    
    public String getPresentacion() {
        return presentacion;
    }
    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public int getCantidadPresentacion() {
        return cantidadPresentacion;
    }
    public void setCantidadPresentacion(int cantidadPresentacion) {
        this.cantidadPresentacion = cantidadPresentacion;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }
    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }
    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public int getEspecificacionEmpacadoVolumen() {
        return especificacionEmpacadoVolumen;
    }
    public void setEspecificacionEmpacadoVolumen(int especificacionEmpacadoVolumen) {
        this.especificacionEmpacadoVolumen = especificacionEmpacadoVolumen;
    }

    public int getEspecificacionEmpacadoPeso() {
        return especificacionEmpacadoPeso;
    }
    public void setEspecificacionEmpacadoPeso(int especificacionEmpacadoPeso) {
        this.especificacionEmpacadoPeso = especificacionEmpacadoPeso;
    }

    public List<Categoria> getCategoria_producto() {
        return categoria_producto;
    }
    public void setCategoria_producto(List<Categoria> categoria_producto) {
        this.categoria_producto = categoria_producto;
    }
    
}
