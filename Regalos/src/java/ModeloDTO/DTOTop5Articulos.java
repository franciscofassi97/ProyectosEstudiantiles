
package ModeloDTO;

public class DTOTop5Articulos {
    private String nombreArticulo;
    private int canitdadArticulo;
    private int canitdadParejas;

    public DTOTop5Articulos() {
    }

    public DTOTop5Articulos(String nombreArticulo, int canitdadArticulo, int canitdadParejas) {
        this.nombreArticulo = nombreArticulo;
        this.canitdadArticulo = canitdadArticulo;
        this.canitdadParejas = canitdadParejas;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public int getCanitdadArticulo() {
        return canitdadArticulo;
    }

    public void setCanitdadArticulo(int canitdadArticulo) {
        this.canitdadArticulo = canitdadArticulo;
    }

    public int getCanitdadParejas() {
        return canitdadParejas;
    }

    public void setCanitdadParejas(int canitdadParejas) {
        this.canitdadParejas = canitdadParejas;
    }

    @Override
    public String toString() {
        return "DTOTop5Articulos{" + "nombreArticulo=" + nombreArticulo + ", canitdadArticulo=" + canitdadArticulo + ", canitdadParejas=" + canitdadParejas + '}';
    }
    
    
}
