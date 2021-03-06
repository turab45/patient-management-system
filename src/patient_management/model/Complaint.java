/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patient_management.model;

/**
 *
 * @author USER
 */
public class Complaint {
    private int id;
    private String complaint;
    private String remarks;
    private Patient patient;
    private Drug drug;
    private Test test;

    public Complaint(String complaint, String remarks, Patient patient, Drug drug, Test test) {
        this.complaint = complaint;
        this.remarks = remarks;
        this.patient = patient;
        this.drug = drug;
        this.test = test;
    }

    public Complaint() {
    }

    public Complaint(int id) {
        this.id = id;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
    
    
}
