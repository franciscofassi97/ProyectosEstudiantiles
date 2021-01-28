
package Modelo;

public class Parejas {
    private int idPareja;
    private String nombrePareja;
    private String fechaPareja;
    private String telefonoPareja;
    private String direccionPareja;
    private int estadoPareja; //1 = activo 2= Inactivo

    public int getEstadoPareja() {
        return estadoPareja;
    }

    public void setEstadoPareja(int estadoPareja) {
        this.estadoPareja = estadoPareja;
    }
    

    public Parejas(int idPareja, String nombrePareja, String fechaPareja, String telefonoPareja, String direccionPareja,int estadPareja) {
        this.idPareja = idPareja;
        this.nombrePareja = nombrePareja;
        this.fechaPareja = fechaPareja;
        this.telefonoPareja = telefonoPareja;
        this.direccionPareja = direccionPareja;
        this.estadoPareja = estadPareja;
    }

    public Parejas() {
    }

    public int getIdPareja() {
        return idPareja;
    }

    public void setIdPareja(int idPareja) {
        this.idPareja = idPareja;
    }

    public String getNombrePareja() {
        return nombrePareja;
    }

    public void setNombrePareja(String nombrePareja) {
        this.nombrePareja = nombrePareja;
    }

    public String getFechaPareja() {
        return fechaPareja;
    }

    public void setFechaPareja(String fechaPareja) {
        this.fechaPareja = fechaPareja;
    }

    public String getTelefonoPareja() {
        return telefonoPareja;
    }

    public void setTelefonoPareja(String telefonoPareja) {
        this.telefonoPareja = telefonoPareja;
    }

    public String getDireccionPareja() {
        return direccionPareja;
    }

    public void setDireccionPareja(String direccionPareja) {
        this.direccionPareja = direccionPareja;
    }

    @Override
    public String toString() {
        return "Parejas{" + "idPareja=" + idPareja + ", nombrePareja=" + nombrePareja + ", fechaPareja=" + fechaPareja + ", telefonoPareja=" + telefonoPareja + ", direccionPareja=" + direccionPareja + '}';
    }
    
    
}
