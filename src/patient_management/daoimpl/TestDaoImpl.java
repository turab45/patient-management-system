/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patient_management.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import patient_management.database.Database;
import patient_management.model.Test;

/**
 *
 * @author USER
 */
public class TestDaoImpl {
     Connection conn = Database.getConnection();
    
    public int addTest(Test test){
        int row = 0;
        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO test(test_name,description) "
                    + "VALUES('"+test.getTestName()+"','"+test.getDescription()+"')");
            row = pstmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        return  row;
    }
    
    public List<Test> getAllTests(){
        List<Test> tests = new ArrayList<>();
        
        try {
            PreparedStatement pstmt = conn.prepareStatement("select * from test");
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Test test = new Test(rs.getString(2), rs.getString(3));
                test.setId(rs.getInt(1));
                
                tests.add(test);
                
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        
        return tests;
    }
}