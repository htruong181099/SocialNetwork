/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tool.md5;
import DAO.user_dao_query;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import model.User;
import java.sql.Connection;
import java.io.InputStream;
@WebServlet(name = "user", urlPatterns = {"/user"})
public class UserController extends HttpServlet {

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
            out.println("<title>Servlet User</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet User at " + request.getContextPath() + "</h1>");
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
        doPost(request, response);
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
        try {
            String command = request.getParameter("command");
            HttpSession session = request.getSession();
            String url = "";
            String view="";
             User user = new User();
            user_dao_query usrQuery = new user_dao_query();
            switch (command) {
                case "LOGIN":
                    String userName = request.getParameter("username");
                    String password = request.getParameter("password");
                   
                    user = usrQuery.loginUser(userName, password);
                    if (user!=null) {
                        url = "/index";
                    }
                    else{
                        url = "/Login";
                    }
                    
                                       
                    break;
                case "REGISTER":
                    String username=request.getParameter("username");
                    String pwd=request.getParameter("password");
                    String confirmpwd=request.getParameter("confirmpwd");
                    String email=request.getParameter("email");
                    String username_err="",password_err="",email_err="";
                    if(email.equals("")){
                        email_err="Email khong duoc de trong.";
                    }
                      if(usrQuery.checkEmail(email))
                    {
                       email_err="Email da ton tai!!!";
                    }
                    if(usrQuery.checkUsername(username))
                    {
                        username_err="Ten dang nhap da ton tai, vui long chon ten khac!!!";
                    }
                    if(email_err.length()>0)
                    {
                        request.setAttribute("email_err",email_err );
                    }
                     if(username.equals("")){
                        username_err="Ten dang nhap khong duoc de trong.";
                    }
                    if(username_err.length()>0)
                    {
                        request.setAttribute("username_err",username_err );
                    }
                     if(pwd.length()<6){
                        password_err="Mat khau cua ban phai hon 6 ki tu.";
                    }
                    if(password_err.length()>0)
                    {
                        request.setAttribute("password_err",password_err );
                    }
                  
                    user=new User(username,pwd,email);
                  
                    if(usrQuery.checkUser(user)==false&&password_err.length()==0&&username_err.length()==0&&email_err.length()==0) 
                   {
                       usrQuery.signUpUser(user);   
                       url="/Login";                       
                   }
                   else 
                   {
                       url="/Signup";
                   }                   
                    break;
                default:
                    break;
            }
            RequestDispatcher dis = request.getRequestDispatcher(url);
             dis.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
  
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
