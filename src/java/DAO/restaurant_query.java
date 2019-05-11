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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.review;
import model.restaurant;
/**
 *
 * @author admin
 */
public class restaurant_query {
    private Connection conn;
    private ResultSet results;
    private restaurant res;
     public restaurant_query()
     {
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
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(restaurant_query.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     public boolean addRestaurant(restaurant res) throws SQLException
     {
         String sql = "INSERT INTO `social_network`.`restaurant` ( `restaurant_name`, `address`, `point`) VALUES ( ?, ?, ?);";
         java.sql.PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         ps.setString(1, res.getRestaurant_name());
         ps.setString(2, res.getAddress());
         ps.setFloat(3,res.getPoint());
          ps.executeUpdate();
        this.results = ps.getGeneratedKeys();
        int key = 0;
        if (this.results.next()) {
            key = this.results.getInt(1);
            res.setRestaurant_id(key);
            return true;
        }
        return false;        
     }
      public boolean deleteRestaurant(restaurant res) throws SQLException
    {
        String sql ="DELETE FROM `social_network`.`post` WHERE (`restaurant_id` = ?); ";
        java.sql.PreparedStatement ps =conn.prepareStatement(sql);
        ps.setInt(1, res.getRestaurant_id());
        this.results=ps.executeQuery();
        if(this.results.next())
        {
            return true;
        }
        return false;       
    }
      public float updatePointRestaurant(restaurant res, float Addedpoint) throws SQLException
      {
          String sql="UPDATE `social_network`.`restaurant` SET `point` = ? WHERE (`restaurant_id` = ?);";
          java.sql.PreparedStatement ps = conn.prepareStatement(sql);
          float oldPoint=res.getPoint();
          int numOfReview=0;
          String sqlCount="SELECT * from social_network.review where restaurant_id =?";
          java.sql.PreparedStatement ps2=conn.prepareStatement(sqlCount);
          ps2.setInt(1, res.getRestaurant_id());
          this.results=ps2.executeQuery();
          while(this.results.next()){
              numOfReview++;
          }
          float newPoint=(float)(oldPoint*(1+numOfReview))/numOfReview;
          ps.setFloat(1, newPoint);
          ps.setInt(2, res.getRestaurant_id());
          ps2.executeQuery();
          return newPoint;
      }
    
}
