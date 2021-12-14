/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.total;

import dal.DrinksDBContext;
import dal.ProductDBContext;
import dal.TotalDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Drinks;
import model.Product;
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

        
        
        ArrayList<Drinks> drinks = new ArrayList<>();
        request.setAttribute("drinks", drinks);
        
        request.getRequestDispatcher("../view/total/add1.jsp").forward(request, response);

    }DrinksDBContext db = new DrinksDBContext();

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
//    ProductDBContext proDB = new ProductDBContext();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        
        
        
        
        
        
        String name = request.getParameter("search");
        if(name == null)
            name = "";
        
        ArrayList<Drinks> dri = db.search(name);
        
        request.setAttribute("drinks", dri);
        request.getRequestDispatcher("../view/total/add1.jsp").forward(request, response);
        
        
        

        
        Total tl = new Total();
        
        String[] indexs = request.getParameterValues("index");
        for (String index : indexs) {
            
            Drinks d = new Drinks();
            d.setdID(Integer.parseInt(request.getParameter("did"+ index)));
            
            Total t = new Total();
            t.setdID(d);
            t.settQuantity(Float.parseFloat(request.getParameter("tQuan" + index))                 );
            t.setTdob(Date.valueOf(request.getParameter("tdob" + index)));
            tl.getTotal().add(t);
        }

        TotalDBContext db = new TotalDBContext();
        db.insert1(tl);
        response.sendRedirect("list");

        //---------------------------------------
//        String raw_dID = request.getParameter("did");
//        String raw_tQuan= request.getParameter("tQuan");
//        String raw_tdob= request.getParameter("tdob");
//        
//        Drinks d = new Drinks();
//        d.setdID(Integer.parseInt(raw_dID));
//        
//        
//        
//        TotalDBContext dbTotal = new TotalDBContext();
//        Total t = new Total();
//        t.setdID(d);
//        t.settQuantity(Float.parseFloat(raw_tQuan));
//        t.setTdob(Date.valueOf(raw_tdob));
//        
//        dbTotal.insert(t);
//        response.sendRedirect("list");
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
