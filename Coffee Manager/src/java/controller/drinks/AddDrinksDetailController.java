/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.drinks;

import dal.DrinksDBContext;
import dal.DrinksDetailDBContext;
import dal.ProductDBContext;
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
public class AddDrinksDetailController extends HttpServlet {


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
        
        
        String id = request.getParameter("id");
        int id_int = Integer.parseInt(id);
        
        Drinks d = new Drinks();
        d.setdID(id_int);
        Drinks drinks = dbDrinks.get(d);
        request.setAttribute("drinks", drinks);
        
//        request.getRequestDispatcher("../view/drinks/detail.jsp").forward(request, response);
        request.getRequestDispatcher("../view/drinks/addDrinksDetail.jsp").forward(request, response);
        
    }
    
    
    DrinksDBContext dbDrinks = new DrinksDBContext();
    DrinksDetailDBContext DBdd = new DrinksDetailDBContext();
    ProductDBContext dbPro = new ProductDBContext();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        Product p = new Product();
        p.setpID(request.getParameter("pid"));
        

        Drinks d = new Drinks();
        d.setdID(Integer.parseInt(request.getParameter("did")));

        DrinksDetail dd = new DrinksDetail();

        dd.setdID(d);
        dd.setPid(p);
        dd.setDdQuantity(Float.parseFloat(request.getParameter("ddQuan")));
        DBdd.insert(dd);
        
        String id = request.getParameter("did");
        String respon = "detail1?id=" + id;
        
        response.sendRedirect(respon);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
