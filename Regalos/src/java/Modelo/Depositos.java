
package Modelo;


public class Depositos {
    private int idDeposito;
    private Parejas idPareja;
    private String fechaDeposito;
    private String nombreInvitadoDeposito;
    private String direccionInvitadoDeposito;
    private String contactoInvitadoDeposito;
    private double montoDeposito;

    public Depositos() {
    }

    public Depositos(int idDeposito, Parejas idPareja, String fechaDeposito, String nombreInvitadoDeposito, String direccionInvitadoDeposito, String contactoInvitadoDeposito, double montoDeposito) {
        this.idDeposito = idDeposito;
        this.idPareja = idPareja;
        this.fechaDeposito = fechaDeposito;
        this.nombreInvitadoDeposito = nombreInvitadoDeposito;
        this.direccionInvitadoDeposito = direccionInvitadoDeposito;
        this.contactoInvitadoDeposito = contactoInvitadoDeposito;
        this.montoDeposito = montoDeposito;
    }

    public int getIdDeposito() {
        return idDeposito;
    }

    public void setIdDeposito(int idDeposito) {
        this.idDeposito = idDeposito;
    }

    public Parejas getIdPareja() {
        return idPareja;
    }

    public void setIdPareja(Parejas idPareja) {
        this.idPareja = idPareja;
    }

    public String getFechaDeposito() {
        return fechaDeposito;
    }

    public void setFechaDeposito(String fechaDeposito) {
        this.fechaDeposito = fechaDeposito;
    }

    public String getNombreInvitadoDeposito() {
        return nombreInvitadoDeposito;
    }

    public void setNombreInvitadoDeposito(String nombreInvitadoDeposito) {
        this.nombreInvitadoDeposito = nombreInvitadoDeposito;
    }

    public String getDireccionInvitadoDeposito() {
        return direccionInvitadoDeposito;
    }

    public void setDireccionInvitadoDeposito(String direccionInvitadoDeposito) {
        this.direccionInvitadoDeposito = direccionInvitadoDeposito;
    }

    public String getContactoInvitadoDeposito() {
        return contactoInvitadoDeposito;
    }

    public void setContactoInvitadoDeposito(String contactoInvitadoDeposito) {
        this.contactoInvitadoDeposito = contactoInvitadoDeposito;
    }

    public double getMontoDeposito() {
        return montoDeposito;
    }

    public void setMontoDeposito(double montoDeposito) {
        this.montoDeposito = montoDeposito;
    }

    @Override
    public String toString() {
        return "Depositos{" + "idDeposito=" + idDeposito + ", idPareja=" + idPareja + ", fechaDeposito=" + fechaDeposito + ", nombreInvitadoDeposito=" + nombreInvitadoDeposito + ", direccionInvitadoDeposito=" + direccionInvitadoDeposito + ", contactoInvitadoDeposito=" + contactoInvitadoDeposito + ", montoDeposito=" + montoDeposito + '}';
    }
    
}
