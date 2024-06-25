package models;

import models.enums.Education;
import models.enums.Gender;
import models.enums.Specialization;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class Doctor extends Person {
    private int yearsOfExperience; //nam kinh nghiem
    private int clinicHours;
    private Education education;
    private Specialization specialization;
    private double consultationFee;
    private HashMap<String, Patient> patients;

    public Doctor() {
        this.patients = new HashMap<>(patients);
    }

    public Doctor(String IdNumber, String FirstName, String LastName, String yob, Gender gender, String address, String telephoneNumber,
                  int yearsOfExperience, int clinicHours, Education education,
                  Specialization specialization, double consultationFee) throws ParseException {
        super(IdNumber, FirstName, LastName, yob, gender, address, telephoneNumber);
        this.yearsOfExperience = yearsOfExperience;
        this.clinicHours = clinicHours;
        this.education = education;
        this.specialization = specialization;
        this.consultationFee = consultationFee;
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

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
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
        return  super.toString() +
                "clinicHours=" + clinicHours +
                ", yearsOfExperience=" + yearsOfExperience +
                ", education='" + education +
                ", specialization=" + specialization +
                ", consultationFee=" + consultationFee;

    }

    public String toFile() {
        return getIDNumber() + "| " + getFirstName() + "| "+ getLastName() + "| " + getGender() + "| " + getYob() + "| " + getAge() + "| " + getAddress() + "| " + getTelephoneNumber() + "| " +
                clinicHours + "| " + yearsOfExperience + "| " + education + "| " + specialization + "| " + consultationFee;
    }
}

