package models;

import com.sun.org.apache.bcel.internal.classfile.StackMapEntry;

import java.util.HashMap;
import java.util.Map;

public class Doctor extends Person {
    private int yearsOfExperience; //nam kinh nghiem
    private int clinicHours;
    private String education;
    private Specialization specialization;
    private double consultationFee;
    private HashMap<String, Patient> patients;

    public Doctor(){
        this.patients = new HashMap<>();
    }
    public Doctor(int yearsOfExperience, int clinicHours,String education, Specialization specialization, double consultationFee, HashMap patients){
        this.yearsOfExperience = yearsOfExperience;
        this.clinicHours = clinicHours;
        this.education = education;
        this.specialization = specialization;
        this.consultationFee = consultationFee;
        this.patients = new HashMap<>();
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getClinicHours() {
        return clinicHours;
    }

    public void setClinicHours(int clinicHours) {
        this.clinicHours = clinicHours;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    public HashMap<String, Patient> getPatients() {
        return patients;
    }

    public void setPatients(HashMap<String, Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "clinicHours=" + clinicHours +
                ", yearsOfExperience=" + yearsOfExperience +
                ", education='" + education + '\'' +
                ", specialization=" + specialization +
                ", consultationFee=" + consultationFee +
                ", patients=" + patients +
                '}';
    }
    //Ham them benh nhan
    public void addNewPatient(Patient patient) {
        if (patient == null || patient.getIDNumber() == null || patient.getIDNumber().isEmpty()) {
            throw new IllegalArgumentException("Patient or Patient ID cannot be null or empty");
        }
        patients.put(patient.getIDNumber(), patient);
    }
    //Ham tim kiem benh nhan
    public Patient findPatient(String IDNumber) {
        try{
            patients.get(IDNumber);
        }
        return patients.get(IDNumber);
    }
    public Patient listPatient(Patient patients){
        if(getPatients().isEmpty()){
            System.out.println("No patient found.");
        }else {
            for (Map.Entry<String, Patient> entry : patients.entrySet()) {
                System.out.println(entry.getValue());
            }
        }
    }
    public Patient removePatient(String IDNumber){
        return patients.remove(IDNumber);
    }



}
