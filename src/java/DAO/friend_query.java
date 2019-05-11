
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
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.friendlist;
import model.User;
/**
 *
 * @author Administrator
 */
public class friend_query {
    private Connection conn;
    private ResultSet results;
   

    public friend_query() {
        Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");//let me read content of a file 
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(friend_query.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(friend_query.class.getName()).log(Level.SEVERE, null, ex);
        }
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String password = props.getProperty("user.password");

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(friend_query.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(friend_query.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*public boolean addfriend(String us1_name, String us2_name, friendlist fr) throws SQLException{
        String sql1 ="SELECT `user_id` FROM `social_network`.`user` WHERE `user_name` = `?` ";
        PreparedStatement id1 = conn.prepareStatement(sql1);
        PreparedStatement id2 = conn.prepareStatement(sql1);
        id1.setString(1, us1_name);
        id2.setString(1, us2_name);
        ResultSet rs1 = id1.executeQuery(sql1);
        ResultSet rs2= id2.executeQuery(sql1);
        
        String sql = "INSERT INTO `social_network`.`friendlist` (`id_user`,`id_friend`,`user_name`,`friend_name`) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            this.results = ps.getGeneratedKeys();
            ps.setInt(1, rs1.getInt("user_id"));
            ps.setInt(2, rs2.getInt("user_id"));
            ps.setString(3, us1_name);
            ps.setString(4, us2_name);
            ps.executeUpdate();
            this.results = ps.getGeneratedKeys();
            int key = 0;
            if (this.results.next()) {
                key = this.results.getInt(1);
                fr.setFriendlist_id(key);
                return true;
            }
            return false;
    }*/
    
    public boolean addfriend(User us1, User us2, friendlist fr) throws SQLException{
        
        String sql = "INSERT INTO `social_network`.`friendlist` (`id_user`,`id_friend`,`user_name`,`friend_name`) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            this.results = ps.getGeneratedKeys();
            ps.setInt(1, us1.getUser_id());
            ps.setInt(2, us2.getUser_id());
            ps.setString(3, us1.getUsername());
            ps.setString(4, us2.getUsername());
            ps.executeUpdate();
            this.results = ps.getGeneratedKeys();
            int key = 0;
            if (this.results.next()) {
                key = this.results.getInt(1);
                fr.setFriendlist_id(key);
                return true;
            }
            return false;
    }
    
    public void updateStatus(friendlist fr) throws SQLException{
        
        String sql = "UPDATE `social_network`.`friendlist` SET status =? where friendlist_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setInt(2, fr.getFriendlist_id());
           
    }
    
    
    public static void main(String[] args) throws SQLException {
        friend_query friend = new friend_query();
       // friendlist fr = new friendlist();
        

    }
}
