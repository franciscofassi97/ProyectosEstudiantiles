
package Modelo;


public class Compras {
    private int idCompra;
    private Parejas idPareja;
    private String fechaCompra;
    private double montoCompra;

    public Compras(int idCompra, Parejas idPareja, String fechaCompra, double montoCompra) {
        this.idCompra = idCompra;
        this.idPareja = idPareja;
        this.fechaCompra = fechaCompra;
        this.montoCompra = montoCompra;
    }

    public Compras() {
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Parejas getIdPareja() {
        return idPareja;
    }

    public void setIdPareja(Parejas idPareja) {
        this.idPareja = idPareja;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public double getMontoCompra() {
        return montoCompra;
    }

    public void setMontoCompra(double montoCompra) {
        this.montoCompra = montoCompra;
    }

    @Override
    public String toString() {
        return "Compras{" + "idPareja=" + idPareja + ", fechaCompra=" + fechaCompra + ", montoCompra=" + montoCompra + '}';
    }
    
    
}
