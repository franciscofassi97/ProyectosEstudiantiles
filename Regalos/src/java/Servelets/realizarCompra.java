/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets;

import GestorBD.GestorRegalos;
import Modelo.Articulos;
import Modelo.Compras;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "realizarCompra", urlPatterns = {"/realizarCompra"})
public class realizarCompra extends HttpServlet {

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
        
        if (request.getSession().getAttribute("usuario") == null) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/inicioSecion.jsp");
            rd.forward(request, response);
            return;
        }else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/realizarCompra.jsp");
            rd.forward(request, response);
        }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        GestorRegalos gestor = new GestorRegalos();
        
        String idC = request.getParameter("txtIdCompra");
        int idCompra = Integer.parseInt(idC);
        
        String idPareja = request.getParameter("txtIdPareja");
        int idParejaComptadora = Integer.parseInt(idPareja);
       
        String fechaCompra = request.getParameter("txtFecha");
        
        
        Compras  compra = new Compras(idCompra, gestor.obtetenerParejaPorId(idParejaComptadora), fechaCompra,0);
        
        gestor.agragarCompra(compra);
        
        request.setAttribute("txtIdCompra", idCompra);
        request.setAttribute("txtIdPareja", idPareja);
        
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
