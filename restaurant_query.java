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
import model.review;
import model.restaurant;
import model.user;

public class restaurant_query {
        private Connection conn;
        private ResultSet results;
//        private restaurant res = new restaurant();
        public restaurant_query(){
            Properties props = new Properties();
            InputStream instr = getClass().getResourceAsStream("dbConn.properties");//let me read content of a file 
            try {
                props.load(instr);
            } catch (IOException ex) {
                Logger.getLogger(restaurant_query.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                instr.close();
            } catch (IOException ex) {
                Logger.getLogger(restaurant_query.class.getName()).log(Level.SEVERE, null, ex);
            }
            String driver = props.getProperty("driver.name");
            String url = props.getProperty("server.name");
            String username = props.getProperty("user.name");
            String password = props.getProperty("user.password");

            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(restaurant_query.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn = DriverManager.getConnection(url, username, password);
            } 
            catch (SQLException ex) {
                Logger.getLogger(restaurant_query.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public boolean addRestaurant(restaurant res)  throws SQLException{
            String sql = "INSERT INTO `social_network`.`restaurant` (`restaurant_id`,`restaurant_name`,`address`) VALUES (?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            this.results = ps.getGeneratedKeys();
            ps.setInt(1, res.getRestaurant_id());
            ps.setString(2, res.getName());
            ps.setString(3, res.getAddress());
            ps.executeUpdate();
            this.results = ps.getGeneratedKeys();
            int key=0;
            if (this.results.next()) {
                key = this.results.getInt(1);
                res.setRestaurant_id(key);
                return true;
            }
            return false;
            
        }
        
        public boolean addReview(user us, restaurant res, review rev) throws SQLException{
            String sql = "INSERT INTO `social_network`.`review` (`user_id`,`restaurant_id`,`review_content`,`review_date`) VALUES (?, ?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            this.results = ps.getGeneratedKeys();
            ps.setInt(1, us.getUser_id());
            ps.setInt(2,res.getRestaurant_id());
            ps.setString(3, rev.getReview_content());
            ps.setString(4, rev.getReview_date());
            ps.executeUpdate();
            this.results = ps.getGeneratedKeys();
            int key = 0;
            if (this.results.next()) {
                key = this.results.getInt(1);
                rev.setReview_id(key);
                return true;
            }
            return false;
        
        }
        
        
        public static void main(String[] args) throws SQLException {
        restaurant_query restaurant = new restaurant_query();
        restaurant res = new restaurant();
        res.setName("Mi xao bo");
        res.setAddress("13 Nguyen Hue, Q.1");
        boolean check = restaurant.addRestaurant(res);
        System.out.println(check);

    }
}