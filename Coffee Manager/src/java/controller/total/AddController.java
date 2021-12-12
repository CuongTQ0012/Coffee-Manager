/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.total;

import dal.TotalDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Drinks;
import model.Total;

/**
 *
 * @author Admin
 */
public class AddController extends HttpServlet {


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
        
        
        request.getRequestDispatcher("../view/total/add.jsp").forward(request, response);
        
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
        
        String raw_dID = request.getParameter("did");
        String raw_tQuan= request.getParameter("tQuan");
        String raw_tdob= request.getParameter("tdob");
        
        Drinks d = new Drinks();
        d.setdID(Integer.parseInt(raw_dID));
        
        
        
        TotalDBContext dbTotal = new TotalDBContext();
        Total t = new Total();
        t.setdID(d);
        t.settQuantity(Float.parseFloat(raw_tQuan));
        t.setTdob(Date.valueOf(raw_tdob));
        
        dbTotal.insert(t);
        response.sendRedirect("list");
        
        
        
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
