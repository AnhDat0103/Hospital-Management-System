package models;

import java.util.HashMap;

public class Doctor extends Person {
    private int yearsOfExperience;
    private int clinicHours;
    private String education;
    private Specialization specialization;
    private double consultationFee;
    private HashMap patients;

    public Doctor(){
    }
    public Doctor(int yearsOfExperience, int clinicHours,String education, Specialization specialization, double consultationFee, HashMap patients){
        this.yearsOfExperience = yearsOfExperience;
        this.clinicHours = clinicHours;
        this.education = education;
        this.specialization = specialization;
        this.consultationFee = consultationFee;
        this.patients = new HashMap();
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

    public HashMap getPatients() {
        return patients;
    }

    public void setPatients(HashMap patients) {
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
}
