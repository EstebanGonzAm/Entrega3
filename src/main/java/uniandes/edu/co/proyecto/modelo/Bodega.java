package uniandes.edu.co.proyecto.modelo;

import java.util.List;

import lombok.ToString;

@ToString
public class Bodega {
    
    private int id_bodega;
    private String nombre;
    private int tamanio;
    private List<ProductoBodega> lista_productos_bodega;

    public Bodega(int id_bodega, String nombre, int tamanio) {
        this.id_bodega = id_bodega;
        this.nombre = nombre;
        this.tamanio = tamanio;
    }

    public int getId() {
        return id_bodega;
    }
    public void setId(int id_bodega) {
        this.id_bodega = id_bodega;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTamanio() {
        return tamanio;
    }
    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public List<ProductoBodega> getLista_productos_bodega() {
        return lista_productos_bodega;
    }
    public void setLista_productos_bodega(List<ProductoBodega> lista_productos_bodega) {
        this.lista_productos_bodega = lista_productos_bodega;
    }

    
}