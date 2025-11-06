/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CinemaMamagementSystem;

/**
 *
 * @author hoangdinhphong
 */
import java.sql.*;
import javax.swing.*;

public class MySQLConnection {
    public static Connection dbConnector() {
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Đường dẫn macOS (VD: /Users/phong/Documents/cmsDB.sqlite)
        	String url = "jdbc:mysql://localhost:3306/movie_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        	String name="root";
        	String pass="123456789";
            
            Connection conn = DriverManager.getConnection(url,name,pass);
            return conn;
            
        } catch (Exception e) {
        	e.printStackTrace();
//            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
//    public static void main(String[] args) {
//            Connection conn = MySQLConnection.dbConnector();
//    if (conn != null) {
//        System.out.println("✅ Kết nối SQLite thành công!");
//    } else {
//        System.out.println("❌ Kết nối thất bại!");
//    }
//    }
}
