package models;

import models.enums.Education;
import models.enums.Gender;
import models.enums.Specialization;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

public class Doctor extends Person {
    private int yearsOfExperience;
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


    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "yearsOfExperience=" + yearsOfExperience +
                ", clinicHours=" + clinicHours +
                ", education=" + education +
                ", specialization=" + specialization +
                ", consultationFee=" + consultationFee +
                ", patients=" + patients +
                '}';
    }

    public String toFile() {
        return getIDNumber() + "| " + getFirstName() + "| "+ getLastName() + "| " + getGender() + "| " + getYob() + "| " + getAge() + "| " + getAddress() + "| " + getTelephoneNumber() + "| " +
                clinicHours + "| " + yearsOfExperience + "| " + education + "| " + specialization + "| " + consultationFee;
    }

    public static void getHead() {
        String format = "| %-10s | %-20s | %-6s | %-10s | %-3s | %-25s | %-15s | %-12s | %-18s | %-20s | %-15s | %-15s |%n";
        System.out.println("+------------+----------------------+--------+------------+-----+---------------------------+-----------------+--------------+--------------------+----------------------+-----------------+------------------+");
        System.out.printf(format, "ID", "Full Name", "Gender", "Birth Day", "Age", "Address", "Telephone", "Clinic Hours", "Experience (Years)", "Education", "Specialization", "Consultation Fee");
        System.out.println("+------------+----------------------+--------+------------+-----+---------------------------+-----------------+--------------+--------------------+----------------------+-----------------+------------------+");
    }

    public void generateTable() {
        String format = "| %-10s | %-20s | %-6s | %-10s | %-3s | %-25s | %-15s | %-12s | %-18s | %-20s | %-15s | %-15s  |%n";
        System.out.printf(format, getIDNumber(), getFullName(), getGender(), getYob(), getAge(), getAddress(), getTelephoneNumber(), getClinicHours(), getYearsOfExperience(), getEducation(), getSpecialization(), getConsultationFee() );
        System.out.println("+------------+----------------------+--------+------------+-----+---------------------------+-----------------+--------------+--------------------+----------------------+-----------------+------------------+");
    }
}

