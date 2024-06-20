package models;

import models.enums.Gender;
import models.enums.Specialization;

import java.text.ParseException;
import java.util.HashMap;

public class Patient extends Person {
    private double height;
    private double weight;
    private String bloodType;
    private String allergies;
    private String allergyDetails;
    private HashMap<String, Medicine> medicines;
    private Specialization specialization;


    public Patient() {

    }

    public Patient(String idNumber, String firstName, String lastName, String yob, Gender gender, String address, String telephone, double height, double weight, String bloodType, String allergyDetails, Specialization specialization) throws ParseException {
        super(idNumber, firstName, lastName, yob, gender, address, telephone);
        this.specialization = specialization;
        this.allergyDetails = allergyDetails;
        this.allergies = allergyDetails;
        this.height = height;
        this.weight = weight;
        this.bloodType = bloodType;
    }

    public String getAllergyDetails() {
        return allergyDetails;
    }

    public void setAllergyDetails(String allergyDetails) {
        this.allergyDetails = allergyDetails;
    }

    public String isAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public HashMap<String, Medicine> getMedicine() {
        return medicines;
    }

    public void setMedicine(HashMap<String, Medicine> medicines) {
        this.medicines = medicines;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
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
        return getIDNumber() + "| " + getFullName() + "| " + getGender() + "| " + getYob() + "| " + getAge() + "| " + getAddress() + "| " + getTelephoneNumber() + "| " +
                allergyDetails + "| " +height + "| " + weight + "| " + bloodType + "| " + specialization;
    }




    public void addMedicine(Medicine medicine) {
        medicines.put(medicine.getMedicineID(), medicine);
        System.out.println("Medicine " + medicine.getMedicineID() + " has been added");
    }
}
