
package ModeloDTO;

public class DTOCompra {
    private int idCompra; 
    private String  nombreArticulo;
    private double precioArticulo;

    public DTOCompra(int idCompra, String nombreArticulo, double precioArticulo) {
        this.idCompra = idCompra;
        this.nombreArticulo = nombreArticulo;
        this.precioArticulo = precioArticulo;
    }

    public DTOCompra() {
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public double getPrecioArticulo() {
        return precioArticulo;
    }

    public void setPrecioArticulo(double precioArticulo) {
        this.precioArticulo = precioArticulo;
    }

    @Override
    public String toString() {
        return "DTOCompra{" + "idCompra=" + idCompra + ", nombreArticulo=" + nombreArticulo + ", precioArticulo=" + precioArticulo + '}';
    }
    
    
}
