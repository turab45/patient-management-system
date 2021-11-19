/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patient_management.model;


public class Patient {
    private int id;
    private String fullName;
    private String birthDate;
    private int age;
    private String nrcNumber;
    private String civilStatus;
    private String ethnicity;
    private String contactNumber;
    private String address;
    private String email;

    public Patient(String fullName, String birthDate, int age, String nrcNumber, String civilStatus, String ethnicity, String contactNumber, String address, String email) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.age = age;
        this.nrcNumber = nrcNumber;
        this.civilStatus = civilStatus;
        this.ethnicity = ethnicity;
        this.contactNumber = contactNumber;
        this.address = address;
        this.email = email;
    }

    public Patient() {
    }

    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNrcNumber() {
        return nrcNumber;
    }

    public void setNrcNumber(String nrcNumber) {
        this.nrcNumber = nrcNumber;
    }

    public String getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Patient{" + "id=" + id + ", fullName=" + fullName + ", birthDate=" + birthDate + ", age=" + age + ", nrcNumber=" + nrcNumber + ", civilStatus=" + civilStatus + ", ethnicity=" + ethnicity + ", contactNumber=" + contactNumber + ", address=" + address + ", email=" + email + '}';
    }
    
    
}
