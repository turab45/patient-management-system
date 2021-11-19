/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patient_management.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import patient_management.database.Database;
import patient_management.model.User;

public class UserDaoImpl {

    Connection conn = Database.getConnection();

    public Integer addUser(User user) {
        Integer row = null;
        try {

            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO user(name,password) values(?,?)");
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPassword());

            row = pstmt.executeUpdate();

        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
        return row;
    }

    public User getUserByNameAndPassword(String name, String password) {
        User user = null;
        ResultSet rs = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM user WHERE name=? AND password=?");
            pstmt.setString(1, name);
            pstmt.setString(2, password);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                user = new User();

               
                user.setId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                

            }

        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
        return user;
    }
}
