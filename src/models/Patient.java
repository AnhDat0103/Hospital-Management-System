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
    private HashMap<String, Medicine> medicines;
    private Specialization specialization;

    public Patient(String IDNumber, String firstName, String lastName, String yob, Gender gender, String address, String telephone, double height, double weight, String bloodType, int allergies){

    }

    public Patient(String IdNumber, String FirstName, String LastName, String yob, Gender gender,
                   String address, String telephoneNumber, String allergies, double height,
                   double weight, String bloodType, HashMap<String, Medicine> medicines, Specialization specialization) throws ParseException {
        super(IdNumber, FirstName, LastName, yob, gender, address, telephoneNumber);
        this.allergies = allergies;
        this.height = height;
        this.weight = weight;
        this.bloodType = bloodType;
        this.medicines = new HashMap<>(medicines);
        this.specialization = specialization;
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
                "allergies='" + allergies + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", bloodType='" + bloodType + '\'' +
                ", medicines=" + medicines +
                ", specialization=" + specialization +
                '}';
    }




    public void addMedicine(Medicine medicine) {
        medicines.put(medicine.getMedicineID(), medicine);
        System.out.println("Medicine " + medicine.getMedicineID() + " has been added");
    }
}

