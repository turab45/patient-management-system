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
import patient_management.model.Patient;


public class PatientDaoImpl {
    Connection conn = Database.getConnection();
    
    public int addPatient(Patient patient){
        int row = 0;
        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO patient(fullname,birthdate,age,nrc_number,civil_status,ethnicity,contact_number,address,email) "
                    + "VALUES('"+patient.getFullName()+"','"+patient.getBirthDate()+"','"+patient.getAge()+"','"+patient.getNrcNumber()+"','"+patient.getCivilStatus()+"','"+patient.getEthnicity()+"','"+patient.getContactNumber()+"','"+patient.getAddress()+"','"+patient.getEmail()+"')");
            row = pstmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        return  row;
    }
    
    public int updatePatient(Patient patient){
        int row = 0;
        try {
            PreparedStatement pstmt = conn.prepareStatement("UPDATE patient SET fullname=?,birthdate=?,age=?,nrc_number=?,civil_status=?,ethnicity=?,contact_number=?,address=?,email=? WHERE id=?");
            pstmt.setString(1, patient.getFullName());
            pstmt.setString(2, patient.getBirthDate());
            pstmt.setInt(3, patient.getAge());
            pstmt.setString(4, patient.getNrcNumber());
            pstmt.setString(5, patient.getCivilStatus());
            pstmt.setString(6, patient.getEthnicity());
            pstmt.setString(7, patient.getContactNumber());
            pstmt.setString(8, patient.getAddress());
            pstmt.setString(9, patient.getEmail());
            pstmt.setInt(10, patient.getId());
            
            row = pstmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        return  row;
    }
    
    public List<Patient> getAllPatients(){
        List<Patient> patients = new ArrayList<>();
        ResultSet rs = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM patient");
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt(1);
                String fullName = rs.getString(2);
                String birthDate = rs.getString(3);
                int age = rs.getInt(4);
                String nrcNumber = rs.getString(5);
                String civilStatus = rs.getString(6);
                String ethnicity = rs.getString(7);
                String contactNo = rs.getString(8);
                String address = rs.getString(9);
                String email = rs.getString(10);
                
                Patient p = new Patient(fullName, birthDate, age, nrcNumber, civilStatus, ethnicity, contactNo, address, email);
                p.setId(id);
                
                patients.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        return patients;
    }
    
    public Patient getPatientById(int pid){
        Patient patient = null;
        ResultSet rs = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM patient WHERE id=?");
            pstmt.setInt(1, pid);
            
            rs = pstmt.executeQuery();
            
            if(rs.next()){
                int id = rs.getInt(1);
                String fullName = rs.getString(2);
                String birthDate = rs.getString(3);
                int age = rs.getInt(4);
                String nrcNumber = rs.getString(5);
                String civilStatus = rs.getString(6);
                String ethnicity = rs.getString(7);
                String contactNo = rs.getString(8);
                String address = rs.getString(9);
                String email = rs.getString(10);
                
                patient = new Patient(fullName, birthDate, age, nrcNumber, civilStatus, ethnicity, contactNo, address, email);
                patient.setId(id);
                
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        return patient;
    }
    
    public Patient getPatientByName(String patientname){
        Patient patient = null;
        ResultSet rs = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM patient WHERE fullname=?");
            pstmt.setString(1, patientname);
            
            rs = pstmt.executeQuery();
            
            if(rs.next()){
                int id = rs.getInt(1);
                String fullName = rs.getString(2);
                String birthDate = rs.getString(3);
                int age = rs.getInt(4);
                String nrcNumber = rs.getString(5);
                String civilStatus = rs.getString(6);
                String ethnicity = rs.getString(7);
                String contactNo = rs.getString(8);
                String address = rs.getString(9);
                String email = rs.getString(10);
                
                patient = new Patient(fullName, birthDate, age, nrcNumber, civilStatus, ethnicity, contactNo, address, email);
                patient.setId(id);
                
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        return patient;
    }
    
    public void deletePatient(int pid){
        try {
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM patient WHERE id=?");
            pstmt.setInt(1, pid);
            
            pstmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
    }
}
