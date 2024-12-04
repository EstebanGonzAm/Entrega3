package uniandes.edu.co.proyecto.modelo;
import lombok.ToString;

@ToString
public class Categoria {

    private int id_categoria;
    private String nombre;
    private String descripcion;
    private String almacenamiento;

    public Categoria(int id_categoria, String nombre, String descripcion, String almacenamiento) {
        this.id_categoria = id_categoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.almacenamiento = almacenamiento;
    }

    public int getId_categoria() {
        return id_categoria;
    }
    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAlmacenamiento() {
        return almacenamiento;
    }
    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }
}
