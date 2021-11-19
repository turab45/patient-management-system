
package patient_management.model;

public class Appointment {
    private int id;
    private Patient patient;
    private String date;
    private String remarks;

    public Appointment(Patient patient, String date, String remarks) {
        this.patient = patient;
        this.date = date;
        this.remarks = remarks;
    }

    public Appointment() {
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
    
}
