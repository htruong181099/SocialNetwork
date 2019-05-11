/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import DAO.Delete;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.ResultSet;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Administrator
 */
public class forgetpass {
    private Connection conn;
    public forgetpass(){
        Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");//let me read content of a file 
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(Delete.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(Delete.class.getName()).log(Level.SEVERE, null, ex);
        }
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String password = props.getProperty("user.password");

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Delete.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(Delete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean isUsernameRegistered(String username) {
        String query = "SELECT user_name FROM user WHERE user_name=" +"\""+username+"\""+";";  //get username
        try {
      Statement stmt = conn.prepareStatement(query);
      ResultSet rs = stmt.executeQuery(query) ;
      if(rs!= null) {
       return true ;
      }else {
       return false ;
      }
     } catch (SQLException e) {
      e.printStackTrace();
      return true ;
     }
    protected void doGet(HttpServletRequest request, HttpServletResponse respond) throws ServletException{
        RequestDispatcher rd = request.getRequestDispatcher("/views/forgetpass.jsp");
        
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse respond) throws ServletException{
        String username = request.getParameter("username");
        if (isUsernameRegistered(username))
            
        String emailsql = "SELECT email FROM user WHERE user_name=" +"\""+username+"\""+";";
        Statement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery(query);
        
    }
    
}
