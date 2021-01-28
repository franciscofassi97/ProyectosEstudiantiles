package GestorBD;

import Modelo.Articulos;
import Modelo.Compras;
import Modelo.Depositos;
import Modelo.DetalleCompras;
import Modelo.Parejas;
import Modelo.Usuario;
import ModeloDTO.DTOCompra;
import ModeloDTO.DTOParejasDepositos;
import ModeloDTO.DTOTop5Articulos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorRegalos {

    private String CONN = "jdbc:sqlserver://DESKTOP-1FQTCAM\\SQLEXPRESS:1433;databaseName=LabTP";
    private String USER = "sa";
    private String PASS = "Azulconrojo123.";
    private Connection conn;

    public GestorRegalos() {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorRegalos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void abrirConexcion() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(CONN, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void cerrarConexcion() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
///////////////////////////////////////// ALTA DE PAREJAS /////////////////////////////////////////////////////////////////        
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    public void agragarPareja(Parejas nuevaPareja) {
        try {
            abrirConexcion();

            PreparedStatement st = conn.prepareStatement("insert into Parejas(nombrePareja, fechaPareja, telefonoPareja, direccionPareja, estadoParejas) values(?,?,?,?,?)");

            st.setString(1, nuevaPareja.getNombrePareja());
            st.setString(2, nuevaPareja.getFechaPareja());
            st.setString(3, nuevaPareja.getTelefonoPareja());
            st.setString(4, nuevaPareja.getDireccionPareja());
            st.setInt(5, nuevaPareja.getEstadoPareja());

            st.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(GestorRegalos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexcion();
        }

    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////        
///////////////////////////////////////// BAJA DE PAREJAS /////////////////////////////////////////////////////////////////        
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //BAJA LOGICA
    public void bajaPareja(int idPareja) {
        try {
            abrirConexcion();
            PreparedStatement ps = conn.prepareStatement("UPDATE Parejas SET estadoParejas = 2 WHERE idPareja = ?");

            ps.setInt(1, idPareja);

            ps.executeUpdate();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexcion();
        }
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////        
/////////////////////////////////////ACTUALIZACION DE PAREJAS /////////////////////////////////////////////////////////////////        
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void actualizarPareja(Parejas pareja) {
        try {
            abrirConexcion();
            PreparedStatement ps = conn.prepareStatement("UPDATE Parejas SET nombrePareja = ?, fechaPareja = ?,telefonoPareja = ?,direccionPareja = ?,estadoParejas = ?  WHERE idPareja = ?");

            ps.setString(1, pareja.getNombrePareja());
            ps.setString(2, pareja.getFechaPareja());
            ps.setString(3, pareja.getTelefonoPareja());
            ps.setString(4, pareja.getDireccionPareja());
            ps.setInt(5, pareja.getEstadoPareja());

            ps.setInt(6, pareja.getIdPareja());

            ps.executeUpdate();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexcion();
        }
    }

//////////////////////////////////////////OBTENER ID DE PAREJA/////////////////////////////////////////////////////////////
    public Parejas obtetenerParejaPorId(int idPareja) {

        Parejas idResultado = null;

        try {
            abrirConexcion();
            String sql = "SELECT * FROM Parejas WHERE idPareja = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, idPareja);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {

                String nombrePareja = rs.getString("nombrePareja");
                String fechaPareja = rs.getString("fechaPareja");
                String telefonoPareja = rs.getString("telefonoPareja");
                String direccionPareja = rs.getString("direccionPareja");
                int estadoPareja = rs.getInt("estadoParejas");

                idResultado = new Parejas(idPareja, nombrePareja, fechaPareja, telefonoPareja, direccionPareja, estadoPareja);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexcion();
        }

        return idResultado;

    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////// CONSULTA DE PAREJAS ///////////////////////////////////////////////////////////////// 
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public ArrayList<Parejas> getListaParejas() {
        ArrayList<Parejas> listaDeParejas = new ArrayList<Parejas>();
        try {
            abrirConexcion();

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT *\n"
                    + "FROM Parejas WHERE estadoParejas = 1");

            while (rs.next()) {
                int idPareja = rs.getInt("idPareja");
                String nombrePareja = rs.getString("nombrePareja");
                String fechaPareja = rs.getString("fechaPareja");
                String telefonoPareja = rs.getString("telefonoPareja");
                String direccionPareja = rs.getString("direccionPareja");
                int estadoPareja = rs.getInt("estadoParejas");

                Parejas pareja = new Parejas(idPareja, nombrePareja, fechaPareja, telefonoPareja, direccionPareja, estadoPareja);

                listaDeParejas.add(pareja);
            }

        } catch (SQLException ex) {
            Logger.getLogger(GestorRegalos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexcion();
        }

        return listaDeParejas;
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
///////////////////////////////////////// ALTA DE ARTICULOS /////////////////////////////////////////////////////////////////        
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    public void agragarArticulo(Articulos nuevoArticulo) {
        try {
            abrirConexcion();

            PreparedStatement st = conn.prepareStatement("INSERT INTO Articulos(nombreArticulo, precioArticulo,estadoArticulo) values(?,?,?)");

            st.setString(1, nuevoArticulo.getNombreArticulo());
            st.setDouble(2, nuevoArticulo.getPrecioArticulo());
            st.setInt(3, nuevoArticulo.getEstadoArticulo());

            st.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(GestorRegalos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexcion();
        }

    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
///////////////////////////////////////// BAJA DE ARTICULOS /////////////////////////////////////////////////////////////////        
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 

    // BAJA LOGICA estado 1 = activo 2= eliminado ..
    public void bajaArticulo(int idArticulos) {
        try {
            abrirConexcion();
            PreparedStatement ps = conn.prepareStatement("UPDATE Articulos SET estadoArticulo = 2 WHERE idArticulo = ?");

            ps.setInt(1, idArticulos);

            ps.executeUpdate();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexcion();
        }
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////        
/////////////////////////////////////ACTUALIZACION DE ARTICULOS /////////////////////////////////////////////////////////////////        
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void actualizarArticulo(Articulos articulos) {
        try {
            abrirConexcion();
            PreparedStatement ps = conn.prepareStatement("UPDATE Articulos SET nombreArticulo = ?, precioArticulo = ?,estadoArticulo = ? WHERE idArticulo = ?");

            ps.setString(1, articulos.getNombreArticulo());
            ps.setDouble(2, articulos.getPrecioArticulo());
            ps.setInt(3, articulos.getEstadoArticulo());

            ps.setInt(4, articulos.getIdArticulo());

            ps.executeUpdate();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexcion();
        }
    }
/////////////////////////////////////OBTENER ARTICULO POR ID/////////////////////////////////////////////////////////        

    public Articulos obtetenerArticuloPorId(int idArticulo) {
        Articulos idResultado = null;

        try {
            abrirConexcion();
            String sql = "SELECT * FROM Articulos WHERE idArticulo = ?;";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, idArticulo);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String nombreArticulo = rs.getString("nombreArticulo");
                double precioArticulo = rs.getDouble("precioArticulo");
                int estadoArticulo = rs.getInt("estadoArticulo");
                idResultado = new Articulos(idArticulo, nombreArticulo, precioArticulo, estadoArticulo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexcion();
        }

        return idResultado;

    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
///////////////////////////////////////// CONSULTA DE ARTICULOS /////////////////////////////////////////////////////////////////        
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    public ArrayList<Articulos> listaArticulos() {
        ArrayList<Articulos> listaDeArticulos = new ArrayList<Articulos>();
        try {
            abrirConexcion();

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT *\n"
                    + "FROM Articulos WHERE estadoArticulo = 1 ");

            while (rs.next()) {

                int idArticulo = rs.getInt("idArticulo");
                String nombreArticulo = rs.getString("nombreArticulo");
                double precioArticulo = rs.getDouble("precioArticulo");
                int estadoArticulo = rs.getInt("estadoArticulo");

                Articulos articulo = new Articulos(idArticulo, nombreArticulo, precioArticulo, estadoArticulo);

                listaDeArticulos.add(articulo);
            }

        } catch (SQLException ex) {
            Logger.getLogger(GestorRegalos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexcion();
        }

        return listaDeArticulos;
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
///////////////////////////////////////// ALTA DE DEPOSITO/////////////////////////////////////////////////////////////////        
////////////////////PARA HACER EL ALTA DE DEPOSITO NECECITO CARGAR EL COMBO DE PAREJA ///////////////////////////////////
    public void agregarDeposito(Depositos nuevoDeposito) {
        try {
            abrirConexcion();

            PreparedStatement st = conn.prepareStatement("INSERT INTO Depositos(idPareja,fechaDeposito,nombreInvitadoDeposito,direccionInvitadoDeposito,contacoInivitadoDeposito,montoDeposito)VALUES(?,?,?,?,?,?)");

            st.setInt(1, nuevoDeposito.getIdPareja().getIdPareja());
            st.setString(2, nuevoDeposito.getFechaDeposito());
            st.setString(3, nuevoDeposito.getNombreInvitadoDeposito());
            st.setString(4, nuevoDeposito.getDireccionInvitadoDeposito());
            st.setString(5, nuevoDeposito.getContactoInvitadoDeposito());
            st.setDouble(6, nuevoDeposito.getMontoDeposito());

            st.executeUpdate();

        } catch (Exception e) {
            Logger.getLogger(GestorRegalos.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            cerrarConexcion();
        }
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
///////////////////////////////////////// SECCION REPORTES //////////////////////////////////////////////////////////////        
////////////////////LISTADO DE PAREJAS CON CANTIDAD Y MONTO DEPOSITADO///////////////////////////////////////////////////
    public ArrayList<DTOParejasDepositos> listaParejasXDepositos() {
        ArrayList<DTOParejasDepositos> listaParejasXDepositos = new ArrayList<DTOParejasDepositos>();
        try {
            abrirConexcion();

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT nombrePareja,count(d.idDeposito) as 'Cantidad' ,sum(d.montoDeposito) as 'Total'\n"
                    + "FROM Parejas p, Depositos d \n"
                    + "WHERE p.idPareja = d.idPareja\n"
                    + "GROUP BY nombrePareja");

            while (rs.next()) {

                String nombrePareja = rs.getString("nombrePareja");
                int cantidadDepositos = rs.getInt("Cantidad");
                double montoDeposito = rs.getDouble("Total");

                DTOParejasDepositos dto = new DTOParejasDepositos(nombrePareja, cantidadDepositos, montoDeposito);

                listaParejasXDepositos.add(dto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(GestorRegalos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexcion();
        }

        return listaParejasXDepositos;
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
///////////////////////////////////////// SECCION REPORTES //////////////////////////////////////////////////////////////        
//////////////////// TOTAL FACTURADO POR TODOS LOS REGALOS DE TODAS LAS PAREJAS.///////////////////////////////////////////////////
    public double totalFacturado() {
        double totalFacturado = 0;
        try {
            abrirConexcion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(precioArticuloDetalle) as 'Total Facturado'\n"
                    + "FROM DetalleCompra");

            rs.next();
            totalFacturado = rs.getInt("Total Facturado");
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrarConexcion();
        }
        return totalFacturado;
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
///////////////////////////////////////// SECCION REPORTES //////////////////////////////////////////////////////////////        
//////////////////// TOP 5 ARTICULOS MAS VENDIDOS, PAREJAS QUE COMPRARON.///////////////////////////////////////////////////
    public ArrayList<DTOTop5Articulos> listaArticulosMasComprados() {
        ArrayList<DTOTop5Articulos> listaArticulosMasVendidos = new ArrayList<DTOTop5Articulos>();
        try {
            abrirConexcion();

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT top 5 a.nombreArticulo as 'Articulo', Count(dc.idArticulo) as 'Cantidad vendido', COUNT(DISTINCT idPareja)as 'Parejas que compraron' \n"
                    + "FROM Compras c, DetalleCompra dc, Articulos a\n"
                    + "WHERE c.idCompra = dc.idCompra\n"
                    + "and dc.idArticulo = a.idArticulo\n"
                    + "GROUP BY  dc.idArticulo, nombreArticulo\n"
                    + "Order by COUNT(dc.idArticulo) desc");

            while (rs.next()) {

                String nombreArticulo = rs.getString("Articulo");
                int cantidadVendida = rs.getInt("Cantidad vendido");
                int cantidadParejasCompraron = rs.getInt("Parejas que compraron");

                DTOTop5Articulos dto = new DTOTop5Articulos(nombreArticulo, cantidadVendida, cantidadParejasCompraron);

                listaArticulosMasVendidos.add(dto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(GestorRegalos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexcion();
        }

        return listaArticulosMasVendidos;
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
///////////////////////////////////////// INISIO SECION /////////////////////////////////////////////////////////////////        
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    public Usuario existeUsuario(String nombreUsuario, String contraseniaUsuario) {
        Usuario existe = null;
        try {
            abrirConexcion();
            String sql = "SELECT * FROM Usuarios WHERE nombreUsuario =  ? AND  contrasenia =  ? ";

            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, nombreUsuario);
            st.setString(2, contraseniaUsuario);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                existe = new Usuario();

                existe.setNombreUsuario(rs.getString("nombreUsuario"));
                existe.setContrasenia(rs.getString("contrasenia"));
            }

            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexcion();
        }

        return existe;
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
///////////////////////////////////////// REALIZAR UNA COMPRA/////////////////////////////////////////////////////////////////        
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    /* Un jsp para tener idCompra y la pareja q va a comprar que de ahi me lleve a el listado de articulos,
    me tiene q traer el idCompra y cuando seleccione un articulo con el id tengo q taer el precio del mismo...
    
     */
    //METODO PARA OBTENER EL MONTO DEPOSITADO A CADA PAREJA
    public double totalDeposito(int idPareja) {
        double totalDeposito = 0;
        try {
            abrirConexcion();
            String sql = "SELECT SUM(montoDeposito) as 'Total'\n"
                    + "FROM Depositos\n"
                    + "WHERE idPareja  = ?";

            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, idPareja);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                totalDeposito = rs.getDouble("Total");

            }

            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexcion();
        }

        return totalDeposito;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
///////////////////////////////////////// ALTA DE COMPRA/////////////////////////////////////////////////////////////////        
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    public void agragarCompra(Compras nuevaCompra) {
        try {
            abrirConexcion();

            PreparedStatement st = conn.prepareStatement("INSERT INTO Compras(idCompra,idPareja, fechaCompra) values(?,?,?)");

            st.setInt(1, nuevaCompra.getIdCompra());
            st.setInt(2, nuevaCompra.getIdPareja().getIdPareja());
            st.setString(3, nuevaCompra.getFechaCompra());

            st.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(GestorRegalos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexcion();
        }

    }

    //obtener idCompra
    public Compras obtetenerIdCompra(int idCompra) {
        Compras idResultado = null;

        try {
            abrirConexcion();
            String sql = "SELECT * FROM Compras WHERE idCompra = ?;";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, idCompra);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int idPareja = rs.getInt("idPareja");
                String fecha = rs.getString("fechaCompra");

                idResultado = new Compras(idCompra, null, fecha, 0);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexcion();
        }

        return idResultado;

    }

    //insertar detalle Compra
    public void agragarDetalle(DetalleCompras nuevoDetalle) {
        try {
            abrirConexcion();

            PreparedStatement st = conn.prepareStatement("INSERT INTO DetalleCompra(idCompra, idArticulo,precioArticuloDetalle) values(?,?,?)");

            st.setInt(1, nuevoDetalle.getIdCompra().getIdCompra());
            st.setInt(2, nuevoDetalle.getIdArticulo().getIdArticulo());
            st.setDouble(3, nuevoDetalle.getPrecioArticuloDetalle());

            st.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(GestorRegalos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexcion();
        }

    }

    //Obtener precio articulo 
    public Articulos obtetenerPrecioArticulo(int idArticulo) {
        Articulos precio = null;

        try {
            abrirConexcion();
            String sql = "SELECT * FROM Articulos WHERE idArticulo = ?;";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, idArticulo);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String nombreArticulo = rs.getString("nombreArticulo");
                double precioArticulo = rs.getDouble("precioArticulo");
                int estadoArticulo = rs.getInt("estadoArticulo");

                precio = new Articulos(idArticulo, nombreArticulo, precioArticulo, estadoArticulo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexcion();
        }

        return precio;

    }
//Lisatdo de compra

    public ArrayList<DTOCompra> obtenerListaDeCompra(int idCompra) {
        ArrayList<DTOCompra> lista = new ArrayList<DTOCompra>();
        try {
            abrirConexcion();

            String sql = (" SELECT idCompra , a.nombreArticulo as 'Articulo' , precioArticuloDetalle as 'Precio'\n" +
                            "  FROM DetalleCompra dc, Articulos a\n" +
                            "  WHERE dc.idArticulo = a.idArticulo and\n" +
                            "  idCompra = ?;");
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, idCompra);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                
                int idCompraRealizada =rs.getInt("idCompra");
                String nombreArticulo =rs.getString ("Articulo");
                double precioArticulo = rs.getDouble("Precio");
          
                DTOCompra rd = new DTOCompra(idCompraRealizada, nombreArticulo,precioArticulo);
                lista.add(rd);
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexcion();
        }

        return lista;
    }

}
