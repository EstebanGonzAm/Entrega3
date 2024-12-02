package uniandes.edu.co.proyecto.modelo;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "OrdenCompra")
public class OrdenCompraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id_ordencompra;
    private Date fecha_Creacion;
    private String estado;
    private Date fecha_Entrega;
    private Integer id_infoextraorden;

    /* @ManyToMany
    private List<ProductoEntity> producto;

    @ManyToOne
    private SucursalEntity sucursal;

    @ManyToOne
    private ProveedorEntity proveedor;

    @OneToOne
    private RecepcionProductoEntity recepcionProducto; */

    public OrdenCompraEntity(Date fecha_Creacion, String estado, Date fecha_Entrega, Integer id_infoextraorden) {
        this.fecha_Creacion = fecha_Creacion;
        this.estado = estado;
        this.fecha_Entrega = fecha_Entrega;
        this.id_infoextraorden = id_infoextraorden;
    }

    public OrdenCompraEntity() {
    }

    public Integer getId() {
        return id_ordencompra;
    }

    public Date getFechaCreacion() {
        return fecha_Creacion;
    }

    public String getEstado() {
        return estado;
    }

    public Date getFechaEntrega() {
        return fecha_Entrega;
    }

    public Integer getId_infoextraorden() {
        return id_infoextraorden;
    }

    public void setId(Integer id_ordencompra) {
        this.id_ordencompra = id_ordencompra;
    }

    public void setFechaCreacion(Date fecha_Creacion) {
        this.fecha_Creacion = fecha_Creacion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFechaEntrega(Date fecha_Entrega) {
        this.fecha_Entrega = fecha_Entrega;
    }

}
