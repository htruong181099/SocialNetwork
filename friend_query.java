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
    
    public boolean addfriend(int us1_id, int us2_id, friendlist fr) throws SQLException{
        String sql = "INSERT INTO `social_network`.`friendlist` (`from_id`,`to_id`) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, us1_id);
            ps.setInt(2, us2_id);
            this.results = ps.getGeneratedKeys();
            int key = 0;
            if (this.results.next()) {
                key = this.results.getInt(1);
                fr.setFriendlist_id(key);
                return true;
            }
            return false;
    }
    

}
