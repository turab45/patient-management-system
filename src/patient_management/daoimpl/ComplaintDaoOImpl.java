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
import patient_management.model.Complaint;
import patient_management.model.Patient;
import patient_management.model.Test;

/**
 *
 * @author USER
 */
public class ComplaintDaoOImpl {
     Connection conn = Database.getConnection();
    
    public int addComplaint(Complaint complaint){
        int row = 0;
        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO complaint(complaint,remarks,patient_id) "
                    + "VALUES('"+complaint.getComplaint()+"','"+complaint.getRemarks()+"','"+complaint.getPatient().getId()+"')");
            row = pstmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        return  row;
    }
    
    public List<Complaint> getAllComplaints(){
        List<Complaint> tests = new ArrayList<>();
        
        try {
            PreparedStatement pstmt = conn.prepareStatement("select * from complaint");
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Patient patient = new Patient();
                patient.setId(rs.getInt(4));
                Complaint test = new Complaint(rs.getString(2), rs.getString(3), patient);
                test.setId(rs.getInt(1));
                
                tests.add(test);
                
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        
        return tests;
    }
    
    public List<Complaint> getComplaintsOfPatient(int id){
        List<Complaint> tests = new ArrayList<>();
        
        try {
            PreparedStatement pstmt = conn.prepareStatement("select * from complaint where patient_id=?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Patient patient = new Patient();
                patient.setId(rs.getInt(4));
                Complaint test = new Complaint(rs.getString(2), rs.getString(3), patient);
                test.setId(rs.getInt(1));
                
                tests.add(test);
                
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        
        return tests;
    }
    
    public int deleteComplaint(int id){
        int row = 0;
        try {
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM complaint where id=?");
            pstmt.setInt(1, id);
            row = pstmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        return  row;
    }
}
