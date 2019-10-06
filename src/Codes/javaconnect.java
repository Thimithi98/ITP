/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author HP
 */
public class javaconnect {
    
    
    

    static Connection ConnecrDb;
    
  Connection con;
  ResultSet rs;
  PreparedStatement pst;  
    
    public static Connection connect(){
   
    try{
         Class.forName("com.mysql.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/point_of_sales_system","root","");
         return con;
    }catch(Exception e){
        
        return null;
    
        }
    
    
    
    
    }
    
}
