
package Modelo;


public class DetalleCompras {
    private int idDetalleCompra;
    private Compras idCompra;
    private Articulos idArticulo;
    private double precioArticuloDetalle;
    private double montoTotalDetalle;
    
    public DetalleCompras() {
    }

    public DetalleCompras(int idDetalleCompra, Compras idCompra, Articulos idArticulo, double precioArticuloDetalle, double montoTotalDetalle) {
        this.idDetalleCompra = idDetalleCompra;
        this.idCompra = idCompra;
        this.idArticulo = idArticulo;
        this.precioArticuloDetalle = precioArticuloDetalle;
        this.montoTotalDetalle = montoTotalDetalle;
        
    }

    public int getIdDetalleCompra() {
        return idDetalleCompra;
    }

    public void setIdDetalleCompra(int idDetalleCompra) {
        this.idDetalleCompra = idDetalleCompra;
    }

    public Compras getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Compras idCompra) {
        this.idCompra = idCompra;
    }

    public Articulos getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Articulos idArticulo) {
        this.idArticulo = idArticulo;
    }

    public double getPrecioArticuloDetalle() {
        return precioArticuloDetalle;
    }

    public void setPrecioArticuloDetalle(double precioArticuloDetalle) {
        this.precioArticuloDetalle = precioArticuloDetalle;
    }

    public double getMontoTotalDetalle() {
        return montoTotalDetalle;
    }

    public void setMontoTotalDetalle(double montoTotalDetalle) {
        this.montoTotalDetalle = montoTotalDetalle;
    }
    
    @Override
    public String toString() {
        return "DetalleCompras{" + "idDetalleCompra=" + idDetalleCompra + ", idCompra=" + idCompra + ", idArticulo=" + idArticulo + ", precioArticuloDetalle=" + precioArticuloDetalle + ", montoTotalDetalle=" + montoTotalDetalle + '}';
    }

}
