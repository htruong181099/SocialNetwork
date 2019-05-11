/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.io.IOException;
import java.io.InputStream;
//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.user;
import java.util.Date;

/**
 *
 * @author BaoPhuc
 */
public class user_dao_query {

    private Connection conn;
    private ResultSet results;
    private user usr = new user();

    public user_dao_query() {
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

    public user loginUser(String user_name, String password) throws SQLException {
        String sql = "SELECT * FROM socialnetworkdb.user WHERE user_name=? and password=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, user_name);
        ps.setString(2, password);
        this.results = ps.executeQuery();
        if (this.results.next()) {
            user us = new user();
            us.setUser_id(this.results.getInt("user_id"));
            us.setUsername(this.results.getString("user_name"));
            us.setPassword(this.results.getString("password"));
            us.setFirst_name(this.results.getString("first_name"));
            us.setLast_name(this.results.getString("last_name"));
            us.setDate_of_birth(this.results.getString("date_of_birth"));
            us.setAvatar(this.results.getString("avatar"));
            us.setGender(this.results.getInt("gender"));
            us.setCountry(this.results.getString("country"));
            us.setHobby(this.results.getString("hobby"));
            us.setPhone(this.results.getString("phone"));
            us.setEmail(this.results.getString("email"));
            return us;
        }
        return null;
    }

    public boolean signUpUser(user us) throws SQLException {
        String sql = "INSERT INTO `socialnetworkdb`.`user` ( `user_name`, `password`, `first_name`, `last_name`, `date_of_birth`, `avatar`, `gender`, `country`, `hobby`, `phone`, `email`) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        Date dat = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        
        ps.setString(1, us.getUsername());
        ps.setString(2, us.getPassword());
        ps.setString(3, us.getFirst_name());
        ps.setString(4, us.getLast_name());
        ps.setString(5,ft.format(us.getDate_of_birth()));
        ps.setString(6, us.getAvatar());
        ps.setInt(7, us.getGender());
        ps.setString(8, us.getCountry());
        ps.setString(9, us.getHobby());
        ps.setString(10, us.getPhone());
        ps.setString(11, us.getEmail());
        ps.executeUpdate();
        this.results = ps.getGeneratedKeys();
        int key = 0;
        if (this.results.next()) {
            key = this.results.getInt(1);
            usr.setUser_id(key);
            return true;
        }
        return false;

    }

    public ArrayList<user> GetUserList() throws SQLException {
        String sql = "SELECT * FROM socialnetworkdb.user;";
        PreparedStatement ps = conn.prepareStatement(sql);
        this.results = ps.executeQuery();
        ArrayList<user> arrayListUser = new ArrayList<user>();
        while (this.results.next()) {
            user us = new user();
            us.setUser_id(this.results.getInt("user_id"));
            us.setUsername(this.results.getString("user_name"));
            us.setPassword(this.results.getString("password"));
            us.setFirst_name(this.results.getString("first_name"));
            us.setLast_name(this.results.getString("last_name"));
            us.setDate_of_birth(this.results.getString("date_of_birth"));
            us.setAvatar(this.results.getString("avatar"));
            us.setGender(this.results.getInt("gender"));
            us.setCountry(this.results.getString("country"));
            us.setHobby(this.results.getString("hobby"));
            us.setPhone(this.results.getString("phone"));
            us.setEmail(this.results.getString("email"));
            arrayListUser.add(us);
        }
        return arrayListUser;
    }
    
    public void update_profile(user us) throws SQLException {
            String sql = "UPDATE `socialnetwork`.`user` set (`first_name`, `last_name`, `date_of_birth`, `avatar`, `gender`, `country`, `hobby`, `phone`, `email`) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?) where user_name = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
            
            ps.setString(1, us.getFirst_name());
            ps.setString(2, us.getLast_name());
            ps.setString(3,ft.format(us.getDate_of_birth()));
            ps.setString(4, us.getAvatar());
            ps.setInt(5, us.getGender());
            ps.setString(6, us.getCountry());
            ps.setString(7, us.getHobby());
            ps.setString(8, us.getPhone());
            ps.setString(9, us.getEmail());
            ps.setString(10, us.getUsername());
            ps.executeUpdate();

        }

    public static void main(String[] args) throws SQLException {
        user_dao_query user = new user_dao_query();
        user usrr = new user();
        //usrr.setUser_id(123781);
        usrr.setUsername("baophuc2");
        usrr.setPassword("asdf");
        usrr.setFirst_name("nguyen");
        usrr.setLast_name("last_name");
        usrr.setDate_of_birth("1999-01-02");
        usrr.setAvatar("avatar");
        usrr.setGender(1);
        usrr.setCountry("country");
        usrr.setHobby("hobby");
        usrr.setPhone("phone");
        usrr.setEmail("email");
        boolean check = user.signUpUser(usrr);
        System.out.println(check);

    }
}
