/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.drinks;

import dal.DrinksDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Drinks;

/**
 *
 * @author Admin
 */
public class AddController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        request.getRequestDispatcher("../view/drinks/add.jsp").forward(request, response);
        
    }

    
    DrinksDBContext dbDrinks = new DrinksDBContext();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String raw_dId = request.getParameter("did");
        String raw_dName= request.getParameter("dname");
        String raw_dImage= request.getParameter("dimage");
        
        Drinks d = new Drinks();
        d.setdID(Integer.parseInt(raw_dId));
        d.setdName(raw_dName);
        d.setdImage("image/"+raw_dImage);
        
        
        
        dbDrinks.insert(d);
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
