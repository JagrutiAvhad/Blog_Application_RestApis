/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;


import java.sql.*;
/**
 *
 * @author jagru
 */
public class connection1 {
    public static void  getcon()
    {
         Connection con;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel", "root", "JagAvh@2019");
          System.out.println("connection established");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
