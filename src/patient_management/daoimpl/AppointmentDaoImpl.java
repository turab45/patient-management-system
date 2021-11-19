/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patient_management.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import patient_management.database.Database;
import patient_management.model.Appointment;


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
}
