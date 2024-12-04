package uniandes.edu.co.proyecto.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection="proveedores")
@ToString
public class Proveedor {
    @Id
    private int id;
    private String NIT;
    private String nombre;
    private String direccion;
    private String nombre_contacto;
    private String telefono_contacto;
    private List<ProductoProveedor> productosProveedor;
    private List<Integer> ordenesCompra;
    public Proveedor(int id, String NIT, String nombre, String direccion, String nombre_contacto, String telefono_contacto) {
        this.id = id;
        this.NIT = NIT;
        this.nombre = nombre;
        this.direccion = direccion;
        this.nombre_contacto = nombre_contacto;
        this.telefono_contacto = telefono_contacto;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNIT() {
        return NIT;
    }
    public void setNIT(String NIT) {
        this.NIT = NIT;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setNombre_contacto(String nombre_contacto) {
        this.nombre_contacto = nombre_contacto;
    }

    public String getNombre_contacto() {
        return nombre_contacto;
    }
    public void setTelefono_contacto(String telefono_contacto) {
        this.telefono_contacto = telefono_contacto;
    }

    public String getTelefono_contacto() {
        return telefono_contacto;
    }

    public List<ProductoProveedor> getListaProductos() {
        return productosProveedor;
    }
    public void setListaProductos(List<ProductoProveedor> productosProveedor) {
        this.productosProveedor = productosProveedor;
    }

    public List<Integer> getOrdenesCompra() {
        return ordenesCompra;
    }
    public void setOrdenesCompra(List<Integer> ordenesCompra) {
        this.ordenesCompra = ordenesCompra;
    }
    
}
