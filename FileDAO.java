/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.DBConnect_MySQL;
import java.sql.Connection;

/**
 *
 * @author TramLuc
 */
public class FileDAO {
     final static Connection cons = DBConnect_MySQL.getConnection();
     
     public static int checkfile(String link){
         
         if (link.trim().isEmpty()){ return 2;};
         String str = link.trim().split("\\.")[1];
         if (str.equals("png") || str.equals("jpg") ||str.equals("PNG") ||str.equals("JPG")){
             return 0;
         }
         else if(str.equals("mp4") ||str.equals("MP4")){
             return 1;
         }
         else return 2;
     }
}
