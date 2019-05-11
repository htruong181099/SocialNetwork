    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.User;
import model.post;
import model.Comment;
/**
 *
 * @author Administrator
 */
public class comment_query {
    private Connection conn;
    private ResultSet results;
    public comment_query(){
        Properties props = new Properties();
            InputStream instr = getClass().getResourceAsStream("dbConn.properties");//let me read content of a file 
            try {
                props.load(instr);
            } catch (IOException ex) {
                Logger.getLogger(comment_query.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                instr.close();
            } catch (IOException ex) {
                Logger.getLogger(comment_query.class.getName()).log(Level.SEVERE, null, ex);
            }
            String driver = props.getProperty("driver.name");
            String url = props.getProperty("server.name");
            String username = props.getProperty("user.name");
            String password = props.getProperty("user.password");

            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(comment_query.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn = DriverManager.getConnection(url, username, password);
            } 
            catch (SQLException ex) {
                Logger.getLogger(comment_query.class.getName()).log(Level.SEVERE, null, ex);
            } 
    }
    
    public boolean addComment(User us, post pos, Comment com) throws SQLException{
            String sql = "INSERT INTO `social_network`.`comment` (`user_id`,`post_id`,`comment_content`,`comment_date`) VALUES (?, ?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            this.results = ps.getGeneratedKeys();
            ps.setInt(1, us.getUser_id());
            ps.setInt(2, pos.getPost_id());
            ps.setString(3, com.getComment_content());
            ps.setString(4, com.getComment_date());
            ps.executeUpdate();
            this.results = ps.getGeneratedKeys();
            int key = 0;
            if (this.results.next()) {
                key = this.results.getInt(1);
                com.setComment_id(key);
                return true;
            }
            return false;
        
    }
    
    
   
    
}
