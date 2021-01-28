/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets;

import GestorBD.GestorRegalos;
import Modelo.Articulos;
import Modelo.Parejas;
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
@WebServlet(name = "modificarPareja", urlPatterns = {"/modificarPareja"})
public class modificarPareja extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet modificarPareja</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet modificarPareja at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        }
        
        
        
        GestorRegalos gestor = new GestorRegalos();

        String idParejaAModificar = request.getParameter("idPareja");
        int idPareja = Integer.parseInt(idParejaAModificar);

        Parejas pareja = new Parejas();

        pareja = gestor.obtetenerParejaPorId(idPareja);
        request.setAttribute("parejaModificar", pareja);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificarPareja.jsp");
        rd.forward(request, response);

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

        int idPareja = Integer.parseInt((String) request.getParameter("txtIdPareja"));
        String nombrePareja = request.getParameter("nombrePareja");
        String fechaPareja = request.getParameter("fechaPareja");
        String telefonoPareja = request.getParameter("telefonoPareja");
        String direccionPareja = request.getParameter("direccionPareja");
        
        int estadoPareja = Integer.parseInt(request.getParameter("txtEstadoPareja"));
        

        gestor.actualizarPareja(new Parejas(idPareja, nombrePareja, fechaPareja, telefonoPareja, direccionPareja,estadoPareja));

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoParejas");
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
