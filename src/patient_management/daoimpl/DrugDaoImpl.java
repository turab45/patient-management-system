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
import patient_management.model.Drug;
import patient_management.model.Test;

/**
 *
 * @author USER
 */
public class DrugDaoImpl {
     Connection conn = Database.getConnection();
    
    public int addTDrug(Drug drug){
        int row = 0;
        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO drug(drug_name,description) VALUES('"+drug.getName()+"','"+drug.getDescription()+"')");
            row = pstmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        return  row;
    }
    
    public int deleteTDrug(int drugId){
        int row = 0;
        try {
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM drug where id=?");
            pstmt.setInt(1, drugId);
            row = pstmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        return  row;
    }
    
    public List<Drug> getAllDrugs(){
        List<Drug> tests = new ArrayList<>();
        
        try {
            PreparedStatement pstmt = conn.prepareStatement("select * from drug");
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Drug drug = new Drug(rs.getString(2), rs.getString(3));
                drug.setId(rs.getInt(1));
                
                tests.add(drug);
                
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        
        return tests;
    }
}
