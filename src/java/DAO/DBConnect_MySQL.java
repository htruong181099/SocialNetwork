package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BaoPhuc
 */
public class DBConnect_MySQL {

    public static Connection getConnection() {
        Connection cons = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            if (cons == null) {
                cons = DriverManager.getConnection("jdbc:mysql://localhost/social_network?user=root&password=root");
                System.out.println("Ket noi thanh cong");
               
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
        if(cons!=null) System.out.println("Thanh cong");
        return cons;
    }
    public static void main(String[] args){
        getConnection();
    }

}
