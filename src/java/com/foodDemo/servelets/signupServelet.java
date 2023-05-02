
package com.foodDemo.servelets;

import com.foodDemo.dao.Userdao;
import com.foodDemo.etities.User;
import com.foodDemo.helper.ConnectionProvider;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jay
 */
public class signupServelet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String uname = request.getParameter("uname");
            String uemail = request.getParameter("uemail");
            String upassword = request.getParameter("upassword");
            String ucpassword = request.getParameter("ucpassword");
            
            User user = new User(uname, uemail, upassword);
            
            if(!upassword.equals(ucpassword)){
                out.println("password and confirm password not match");
                out.println(ucpassword);
                out.println(upassword);
            }
            else{
                Userdao dao = new Userdao(ConnectionProvider.getConnection());
                out.print(ConnectionProvider.getConnection());
                if (dao.saveUser(user)) {
                    out.print("done");
                }
                else{
                    out.print("error..");
                }
                
            }
            
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
        processRequest(request, response);
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
        processRequest(request, response);
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
