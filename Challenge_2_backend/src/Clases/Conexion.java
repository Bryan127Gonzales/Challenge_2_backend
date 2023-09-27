/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import javax.swing.JOptionPane;
import java.sql.*;
/**
 *
 * @author Bryan
 */
public class Conexion {
    
    public Connection Conectar (){
        String basedatos="hotel";
        String userbd="root";
        String passwordbd="";
        Connection con=null; 
        try{
            con = (Connection) DriverManager. getConnection ("jdbc:mysql://localhost/"+basedatos,userbd,passwordbd);
        } catch (SQLException e) {
            
            JOptionPane. showMessageDialog (null,"Error añ hacer conexion: "+e.getMessage());
        }
        return con;
    }
}
