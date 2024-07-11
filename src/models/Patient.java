package models;

import models.enums.Gender;
import models.enums.Specialization;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Patient extends Person {
    private double height;
    private double weight;
    private String bloodType;
    private boolean allergies;
    private String allergyDetails;
    private List<Medicine> medicines;
    private Specialization specialization;


    public Patient(){
    }

    public Patient(String idNumber, String firstName, String lastName, String yob, Gender gender, String address, String telephone,
                   double height, double weight, String bloodType,
                   boolean allergies,String allergyDetails, Specialization specialization) throws ParseException {
        super(idNumber, firstName, lastName, yob, gender, address, telephone);
        this.specialization = specialization;
        this.allergyDetails = allergyDetails;
        this.allergies = allergies;
        this.height = height;
        this.weight = weight;
        this.bloodType = bloodType;
        this.medicines = new ArrayList<>();
    }

    public String getAllergyDetails() {
        return allergyDetails;
    }

    public void setAllergyDetails(String allergyDetails) {
        this.allergyDetails = allergyDetails;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setAllergies(boolean allergies) {
        this.allergies = allergies;
    }

    @Override
    public String toString() {
        return "Patient {" +
                super.toString() +
                "allergyDetails='" + allergyDetails + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", bloodType='" + bloodType +
                ", medicines=" + medicines +
                ", specialization=" + specialization;
    }

    public String toFile() {
        return getIDNumber() + "| " + getFirstName() + "| "+ getLastName() + "| " + getGender() + "| " + getYob() + "| " + getAge() + "| " + getAddress() + "| " + getTelephoneNumber() + "| " + allergies + "| " +
                allergyDetails + "| " + height + "| " + weight + "| " + bloodType + "| " + specialization;
    }

    public void addMedicine(List<Medicine> medicines) {
         this.medicines = medicines;
    }

    public static void getHead() {
        String format = "|%-8s| %-20s | %-6s | %-3s | %-25s | %-15s | %-6s | %-6s | %-9s | %-30s | %-15s |%n";
        System.out.println("+--------+----------------------+--------+-----+---------------------------+-----------------+--------+--------+-----------+--------------------------------+-----------------+");
        System.out.printf(format, "ID", "Full Name", "Gender", "Age", "Address", "Telephone", "Height", "Weight", "Blood Type", "Allergy Details", "Specialization");
        System.out.println("+--------+----------------------+--------+-----+---------------------------+-----------------+--------+--------+-----------+--------------------------------+-----------------+");
    }

    public void generateTable() {
        String format = "|%-8s| %-20s | %-6s | %-3s | %-25s | %-15s | %-6.2f | %-6.2f | %-9s | %-30s | %-15s |%n";
        System.out.printf(format, getIDNumber(), getFullName(), getGender(), getAge(), getAddress(), getTelephoneNumber(), getHeight(), getWeight(), getBloodType(), getAllergyDetails(), getSpecialization());
        System.out.println("+--------+----------------------+--------+-----+---------------------------+-----------------+--------+--------+-----------+--------------------------------+-----------------+");
    }
}
