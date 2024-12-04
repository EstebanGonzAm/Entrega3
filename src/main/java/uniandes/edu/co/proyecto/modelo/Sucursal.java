package uniandes.edu.co.proyecto.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection="sucursales")
@ToString
public class Sucursal {
    @Id
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String ciudad;
    private List<Bodega> bodegas;
    private List<ProductoNivelReorden> nivel_minimo_reorden;
    public Sucursal(int id, String nombre, String direccion, String telefono, String ciudad, List<Bodega> bodegas, List<ProductoNivelReorden> nivel_minimo_reorden) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.bodegas = bodegas;
        this.nivel_minimo_reorden = nivel_minimo_reorden;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Bodega> getLista_bodegas() {
        return bodegas;
    }
    public void setLista_bodegas(List<Bodega> bodegas) {
        this.bodegas = bodegas;
    }

    public List<ProductoNivelReorden>  getNivel_reorden() {
        return nivel_minimo_reorden;
    }
    public void setNivel_reorden(List<ProductoNivelReorden>  nivel_minimo_reorden) {
        this.nivel_minimo_reorden = nivel_minimo_reorden;
    }
}
