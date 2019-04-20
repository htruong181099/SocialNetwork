/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
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

    private Connection conn;
    private ResultSet results;
    private post pst = new post();

    public post_query() {
        Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");//let me read content of a file 
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(user_dao_query.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(user_dao_query.class.getName()).log(Level.SEVERE, null, ex);
        }
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String password = props.getProperty("user.password");

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(user_dao_query.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(user_dao_query.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean addPost(post pst) throws SQLException {
        String sql = "INSERT INTO `socialnetworkdb`.`post` ( `user_id`, `content`, `image_post`, `date_post`) VALUES ( ?, ?, ?, ?);";
        java.sql.PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, pst.getUser_id());
        ps.setString(2, pst.getContent());
        ps.setString(3, pst.getImage_content());
        Date d = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        ps.setString(4, ft.format(d));
        ps.executeUpdate();
        this.results = ps.getGeneratedKeys();
        int key = 0;
        if (this.results.next()) {
            key = this.results.getInt(1);
            pst.setPost_id(key);
            return true;
        }
        return false;
    }
    public boolean editPostByContent(post pst, String newContent) throws SQLException
    {
        String sql = "UPDATE socialnetworkdb.post SET content=? where post_id=?";
        java.sql.PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,newContent);
        ps.setInt(2, pst.getPost_id());
        this.results=ps.executeQuery();
        if(this.results.next())
        {
            return true;
        }
        return false;
    }
    public boolean editPostByImage(post pst, String newImage) throws SQLException
    {
        String sql = "UPDATE socialnetworkdb.post SET image_post=? where post_id=?";
        java.sql.PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,newImage);
        ps.setInt(2, pst.getPost_id());
        this.results=ps.executeQuery();
        if(this.results.next())
        {
            return true;
        }
        return false;
    }
    public boolean deletePost(post pst) throws SQLException
    {
        String sql ="DELETE FROM `socialnetworkdb`.`post` WHERE (`post_id` = ?); ";
        java.sql.PreparedStatement ps =conn.prepareStatement(sql);
        ps.setInt(1, pst.getPost_id());
        this.results=ps.executeQuery();
        if(this.results.next())
        {
            return true;
        }
        return false;       
    }
}
