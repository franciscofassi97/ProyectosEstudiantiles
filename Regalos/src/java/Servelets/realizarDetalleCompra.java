/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets;

import GestorBD.GestorRegalos;
import Modelo.Articulos;
import Modelo.Compras;
import Modelo.DetalleCompras;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "realizarDetalleCompra", urlPatterns = {"/realizarDetalleCompra"})
public class realizarDetalleCompra extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        GestorRegalos gestor = new GestorRegalos();
        ArrayList<Articulos> listaArticulos = gestor.listaArticulos();
       
        request.setAttribute("listaArticulos", listaArticulos);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/reliazarDetalle.jsp");
        rd.forward(request, response);
        
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        GestorRegalos gestor = new GestorRegalos();
        
        String idCompra = request.getParameter("txtIdCompra");
        int idCompraRealizar = Integer.parseInt(idCompra);
       
        String idPareja = request.getParameter("txtIdPareja");
        int idParejaComprando = Integer.parseInt(idPareja);
       
        String mon =request.getParameter("monto");
        double monto = Double.parseDouble(mon);
        
        request.setAttribute("txtIdCompra", idCompraRealizar);
        request.setAttribute("txtIdPareja", idParejaComprando);
        
        request.setAttribute("monto", monto);
      
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    double monto = 0;
    double algo= 0; 
    double vuelto = 0;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        GestorRegalos gestor = new GestorRegalos();
        Articulos articulo = new Articulos();
        
        int idCompra = Integer.parseInt(request.getParameter("txtIdCompra"));
        int idArticulo = Integer.parseInt(request.getParameter("txtIdArticulo"));
        articulo = gestor.obtetenerPrecioArticulo(idArticulo);
        
        
        DetalleCompras  detalleCompra = new DetalleCompras(0,gestor.obtetenerIdCompra(idCompra),gestor.obtetenerArticuloPorId(idArticulo),articulo.getPrecioArticulo(),0);
        
        
        
        
        int idPareja = Integer.parseInt(request.getParameter("txtIdPareja"));
        
         
        
        if(idCompra!= algo)
        { 
            monto =+ gestor.totalDeposito(idPareja);
            algo = idCompra;
            monto = monto - articulo.getPrecioArticulo();
            request.setAttribute("monto", monto);
            gestor.agragarDetalle(detalleCompra);
        }
        else if(idCompra==algo && monto > articulo.getPrecioArticulo() ){
        
            monto = monto - articulo.getPrecioArticulo();
            request.setAttribute("monto", monto);
            gestor.agragarDetalle(detalleCompra);
        }else{
            monto = monto + vuelto; 
            request.setAttribute("vuelto", monto);
        }
        
        String idCompras = request.getParameter("txtIdCompra");
        int idCompraRealizar = Integer.parseInt(idCompras);
        String idParejas = request.getParameter("txtIdPareja");
        int idParejaComprando = Integer.parseInt(idParejas);
        
        request.setAttribute("txtIdPareja", idParejaComprando);
        
        request.setAttribute("txtIdCompra", idCompraRealizar);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoArticulosComprar.jsp");
        rd.forward(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
