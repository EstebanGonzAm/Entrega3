package uniandes.edu.co.proyecto.modelo;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Producto")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_producto;

    private String codigoBarras;
    private String nombre;
    private Integer precioUnitarioVenta;
    private String presentacion;
    private Integer cantidadPresentacion;
    private String unidadMedida;
    private Date fechaExpiracion;
    private Integer id_especificacionempacado;

    /* @ManyToMany
    private List<OrdenCompraEntity> ordenCompras;

    @ManyToMany
    private List<ProveedorEntity> proveedores;

    @ManyToMany
    private List<VentaEntity> ventas;

    @ManyToMany
    private List<BodegaEntity> bodegas;

    @ManyToOne
    private CategoriaEntity categoria;

    @ManyToOne
    private EspecificacionEmpacadoEntity especificacion;

    @OneToMany
    private List<InfoExtraBodegaEntityPK> infoExtraBodegas;

    @OneToMany
    private List<InfoExtraProveedorEntityPK> infoExtraProveedores;

    @OneToMany
    private List<InfoExtraOrdenEntityPK> infoExtraOrdenes;

    @OneToMany
    private List<InfoExtraVentaPK> infoExtraVentas; */

    @ManyToOne
    @JoinColumn(name = "bodega_id", referencedColumnName = "id_bodega")
    private BodegaEntity bodega_id;

    public ProductoEntity(String codigoBarras, String nombre, Integer precioUnitarioVenta, String presentacion, Integer cantidadPresentacion, String unidadMedida, Date fechaExpiracion , Integer id_especificacionempacado,BodegaEntity bodega_id) {
        this.codigoBarras = codigoBarras;
        this.nombre = nombre;
        this.precioUnitarioVenta = precioUnitarioVenta;
        this.presentacion = presentacion;
        this.cantidadPresentacion = cantidadPresentacion;
        this.unidadMedida = unidadMedida;
        this.fechaExpiracion = fechaExpiracion;
        this.id_especificacionempacado = id_especificacionempacado;
        this.bodega_id = bodega_id;
    }

    public ProductoEntity() {
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getPrecioUnitarioVenta() {
        return precioUnitarioVenta;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public Integer getCantidadPresentacion() {
        return cantidadPresentacion;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEspecificacionEmpacado() {
        return id_especificacionempacado;
    }

    public void setEspecificacionEmpacado(Integer id_especificacionempacado) {
        this.id_especificacionempacado = id_especificacionempacado;
    }

    public void setPrecioUnitarioVenta(Integer precioUnitarioVenta) {
        this.precioUnitarioVenta = precioUnitarioVenta;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public void setCantidadPresentacion(Integer cantidadPresentacion) {
        this.cantidadPresentacion = cantidadPresentacion;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public Integer getId() {
        return id_producto;
    }

    public void setId(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public void setBodega(BodegaEntity bodega_id) {
        this.bodega_id = bodega_id;
    }
}
