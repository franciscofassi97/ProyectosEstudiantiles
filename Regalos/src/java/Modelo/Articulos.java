
package Modelo;


public class Articulos {
    private int idArticulo;
    private String nombreArticulo;
    private double precioArticulo;
    private int estadoArticulo;//1 = activo 2= Inactivo

    public int getEstadoArticulo() {
        return estadoArticulo;
    }

    public void setEstadoArticulo(int estadoArticulo) {
        this.estadoArticulo = estadoArticulo;
    }

    public Articulos(int idArticulo, String nombreArticulo, double precioArticulo,int estadoArticulo) {
        this.idArticulo = idArticulo;
        this.nombreArticulo = nombreArticulo;
        this.precioArticulo = precioArticulo;
        this.estadoArticulo = estadoArticulo;
    }

    public Articulos() {
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
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
        return "Articulos{" + "idArticulo=" + idArticulo + ", nombreArticulo=" + nombreArticulo + ", precioArticulo=" + precioArticulo + '}';
    }
    
    
}
