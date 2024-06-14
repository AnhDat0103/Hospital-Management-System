package models;

import java.util.HashMap;

public class Patient extends Person {
    private int height;
    private int weight;
    private String bloodType;
    private boolean allerigies;
    private HashMap Medicine;
    private Specialization specialization;

    public Patient() {

    }


    public Patient(String IdNumber, String FirstName, String LastName, String yob, int age, String gender, String address, String telephoneNumber, boolean allerigies, int height, int weight, String bloodType, HashMap Medicine, Specialization specialization) {
        super(IdNumber, FirstName, LastName, yob, age, gender, address, telephoneNumber);
        this.allerigies = allerigies;
        this.height = height;
        this.weight = weight;
        this.bloodType = bloodType;
        this.Medicine = Medicine;
        this.specialization = specialization;

    }

}
