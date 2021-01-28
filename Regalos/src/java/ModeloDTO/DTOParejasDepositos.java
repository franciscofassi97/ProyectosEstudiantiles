
package ModeloDTO;

public class DTOParejasDepositos {
    
    private String nombrePareja; 
    private int cantidadDepositos;
    private Double montoDepositado; 

    public DTOParejasDepositos(String nombrePareja, int cantidadDepositos, Double montoDepositado) {
        this.nombrePareja = nombrePareja;
        this.cantidadDepositos = cantidadDepositos;
        this.montoDepositado = montoDepositado;
    }

    public DTOParejasDepositos() {
    }

    public String getNombrePareja() {
        return nombrePareja;
    }

    public void setNombrePareja(String nombrePareja) {
        this.nombrePareja = nombrePareja;
    }

    public int getCantidadDepositos() {
        return cantidadDepositos;
    }

    public void setCantidadDepositos(int cantidadDepositos) {
        this.cantidadDepositos = cantidadDepositos;
    }

    public Double getMontoDepositado() {
        return montoDepositado;
    }

    public void setMontoDepositado(Double montoDepositado) {
        this.montoDepositado = montoDepositado;
    }

    @Override
    public String toString() {
        return "DTOParejasDepositos{" + "nombrePareja=" + nombrePareja + ", cantidadDepositos=" + cantidadDepositos + ", montoDepositado=" + montoDepositado + '}';
    }
    
    
}
