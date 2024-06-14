package models;

import java.util.HashMap;

public class Patient extends Person {
    private int height;
    private int weight;
    private String bloodType;
    private boolean allerigies;
    private HashMap<String, Medicine> medicines;
    private Specialization specialization;

    public Patient() {

    }
    public Patient(String IdNumber, String FirstName, String LastName, String yob, int age, String gender, String address, String telephoneNumber, boolean allerigies, int height, int weight, String bloodType, HashMap<String, Medicine> medicines, Specialization specialization) {
        super(IdNumber, FirstName, LastName, yob, age, gender, address, telephoneNumber);
        this.allerigies = allerigies;
        this.height = height;
        this.weight = weight;
        this.bloodType = bloodType;
        this.medicines = new HashMap<>();
        this.specialization = specialization;
    }

    public boolean isAllerigies() {
        return allerigies;
    }

    public void setAllerigies(boolean allerigies) {
        this.allerigies = allerigies;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getWeight() {
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
        return "Patient{" +
                "allerigies=" + allerigies +
                ", height=" + height +
                ", weight=" + weight +
                ", bloodType='" + bloodType + '\'' +
                ", Medicine=" + medicines +
                ", specialization=" + specialization +
                '}';
    }
    public Medicine addMedicine(Medicine medicine){ //add them thuoc moi bang cach getMedicine
        medicines.put(medicine.getMedicineID(), medicine);
        return medicine;
    }

}
