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
import java.sql.Date;
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
        
        
        ArrayList<Category> cate = dbCate.list();
        request.setAttribute("cate", cate);
        
        
        String id = request.getParameter("id");
        Product p = new Product();
        
        p.setpID(id);
        
        
        //truyen vao id
        Product product = dbPro.get(p);
        request.setAttribute("product", product);
        request.getRequestDispatcher("../view/product/edit.jsp").forward(request, response);
        
        
        
        
    }
    
    ProductDBContext dbPro = new ProductDBContext();
    CategoryDBContext dbCate = new CategoryDBContext();

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String raw_id = request.getParameter("id");
        String raw_name = request.getParameter("name");
        String raw_quantity = request.getParameter("quantity:");
        String raw_did = request.getParameter("did");

        Product p = new Product();
        p.setpID(raw_id);
        p.setpName(raw_name);
        p.setpQuantity(Float.parseFloat(raw_quantity));
        
        
        Category c = new Category();
        c.setcID(Integer.parseInt(raw_did));
        p.setCate(c);

        dbPro.update(p);
        response.sendRedirect("list");
    }

    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
