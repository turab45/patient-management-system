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
import patient_management.model.Appointment;
import patient_management.model.Patient;


public class AppointmentDaoImpl {
    Connection conn = Database.getConnection();
    
    public int addAppointment(Appointment appointment){
        Integer row = null;
        
        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO appointment(date,remarks,patient_id) VALUES(?,?,?)");
            pstmt.setString(1, appointment.getDate());
            pstmt.setString(2, appointment.getRemarks());
            pstmt.setInt(3, appointment.getPatient().getId());
            
            row = pstmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        
        return row;
    }
    
    public List<Appointment> getAppointmentsOfPatient(patient_management.model.Patient p){
        List<Appointment> apponitments = new ArrayList<>();
        
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM appointment where patient_id=?");
            pstmt.setInt(1, p.getId());
            
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                Appointment appointment = new Appointment();
                appointment.setId(rs.getInt(1));
                appointment.setDate(rs.getString(2));
                appointment.setRemarks(rs.getString(3));
                appointment.setPatient(p);
                
                apponitments.add(appointment);
            }
            
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        
        return apponitments;
    }
    
    public List<Appointment> getAllAppointments(){
        List<Appointment> apponitments = new ArrayList<>();
        
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM appointment");
            
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                Appointment appointment = new Appointment();
                appointment.setId(rs.getInt(1));
                appointment.setDate(rs.getString(2));
                appointment.setRemarks(rs.getString(3));
                Patient p = new Patient();
                p.setId(rs.getInt(4));
                appointment.setPatient(p);
                
                apponitments.add(appointment);
            }
            
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        
        return apponitments;
    }
    
    public List<Appointment> getApponitmentsOfPatient(int id){
        List<Appointment> apponitments = new ArrayList<>();
        
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM appointment where patient_id=?");
            pstmt.setInt(1, id);
            
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                Appointment appointment = new Appointment();
                appointment.setId(rs.getInt(1));
                appointment.setDate(rs.getString(2));
                appointment.setRemarks(rs.getString(3));
                Patient p = new Patient();
                p.setId(rs.getInt(4));
                appointment.setPatient(p);
                
                apponitments.add(appointment);
            }
            
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        
        return apponitments;
    }
}
