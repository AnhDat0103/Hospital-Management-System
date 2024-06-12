package models;

import java.util.HashMap;

public class Doctor {
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



}
