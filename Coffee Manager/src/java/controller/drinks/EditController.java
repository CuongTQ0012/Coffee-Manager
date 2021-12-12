/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.drinks;

import dal.DrinksDetailDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Drinks;
import model.DrinksDetail;
import model.Product;

/**
 *
 * @author Admin
 */
public class EditController extends HttpServlet {


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
        
//        String id = request.getParameter("id");
//        int id_int = Integer.parseInt(id);
        
        DrinksDetail dd = new DrinksDetail();
        dd.setDdID(8);
        
        
        
        DrinksDetail drinksDetail = dbdd.get(dd);
        
        request.setAttribute("drinksDetail", drinksDetail);
        request.getRequestDispatcher("../view/drinks/editdd.jsp").forward(request, response);
    }
    
    DrinksDetailDBContext dbdd = new DrinksDetailDBContext();

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
        String raw_ddid = request.getParameter("ddid");
        String raw_did = request.getParameter("did");
        String raw_pid = request.getParameter("pid");
        String raw_tquan = request.getParameter("tquan");

        Drinks d = new Drinks();
        d.setdID(Integer.parseInt(raw_did));
        
        
        Product p = new Product();
        p.setpID(raw_pid);
        
        DrinksDetail dd = new DrinksDetail();
        dd.setDdID(Integer.parseInt(raw_ddid));
        dd.setDdQuantity(Float.parseFloat(raw_tquan));
        dd.setPid(p);
        dd.setdID(d);
        
        
        
        
        
        
        

        dbdd.update(dd);
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
