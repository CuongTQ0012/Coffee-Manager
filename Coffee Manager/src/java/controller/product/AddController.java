/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.product;

import dal.CategoryDBContext;
import dal.ProductDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.Product;

/**
 *
 * @author Admin
 */
public class AddController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

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
        
        ArrayList<Category> cate = dbCate.list();
        request.setAttribute("cate", cate);
        request.getRequestDispatcher("../view/product/add.jsp").forward(request, response);
        
    }
    
    ProductDBContext dbPro = new ProductDBContext();
    CategoryDBContext dbCate = new CategoryDBContext();
    

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String raw_pId = request.getParameter("pid");
        String raw_pName= request.getParameter("pname");
        String raw_PQuantity= request.getParameter("pquantity");
        String raw_unit= request.getParameter("unit");
        
        
        Product p = new Product();
        p.setpID(raw_pId);
        p.setpName(raw_pName);
        p.setpQuantity(Float.parseFloat(raw_PQuantity));
        
        
        Category c = new Category();
        c.setcID(Integer.parseInt(raw_unit));
        p.setCate(c);
        
        
        dbPro.insert(p);
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
