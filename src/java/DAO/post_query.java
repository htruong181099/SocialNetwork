
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

//import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.post;

/**
 *
 * @author admin
 */
public class post_query {

    private static Connection conn;
    private ResultSet results;
    private post pst = new post();

    public post_query() {
        Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");//let me read content of a file 
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(post_query.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();x
        } catch (IOException ex) {
            Logger.getLogger(post_query.class.getName()).log(Level.SEVERE, null, ex);
        }
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String password = props.getProperty("user.password");

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(post_query.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(post_query.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean addPost(post pst) throws SQLException {
        String sql = "INSERT INTO `social_network`.`post` ( `user_id`, `content`, `image_post`, `date_post`) VALUES ( ?, ?, ?, ?);";
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, pst.getUser_id());
        ps.setString(2, pst.getContent());
        ps.setString(3, pst.getImage_content());
        Date d = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        ps.setString(4, ft.format(d));
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        int key = 0;
        if (rs.next()) {
            key = rs.getInt(1);
            pst.setPost_id(key);
            return true;
        }
        return false;
    }
    public static boolean editPost(post pst) throws SQLException
    {
        try{
        String sql = "UPDATE social_network.post SET content=?, image_post=? WHERE post_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,pst.getContent());
        ps.setString(2,pst.getImage_content());
        ps.setInt(3, pst.getPost_id());
        ResultSet rs;
        rs = ps.executeQuery();
        return rs.next();
        }
        catch (Exception e){return false;}
    }
    
    public boolean deletePost(post pst) throws SQLException
    {
        String sql ="DELETE FROM `social_network`.`post` WHERE (`post_id` = ?); ";
        java.sql.PreparedStatement ps =conn.prepareStatement(sql);
        ps.setInt(1, pst.getPost_id());
        this.results=ps.executeQuery();
        if(this.results.next())
        {
            return true;
        }
        return false;       
    }
    
    public static void main(String[] args) throws SQLException {
        post pst = new post();
        post_query pq = new post_query();
        pst.setUser_id(1);
        pst.setPost_id(1);
        pst.setContent("lol");
        post_query.addPost(pst);
    }
    
}

