package models;

import models.enums.DosageForm;

import java.util.HashMap;
import java.util.UUID;

public class Medicine  {
    private String medicineID;
    private String name;
    private DosageForm dosageForm;
    private String strength;


    public Medicine() {
        this.medicineID = UUID.randomUUID().toString();
        this.name = "";
        this.strength = "";
    }

    public Medicine( String name, DosageForm dosageForm, String strength) {
        this.medicineID = UUID.randomUUID().toString();
        this.name = name;
        this.dosageForm = dosageForm;
        this.strength = strength;
    }

    public String getMedicineID() {
        return medicineID;
    }

    public String getName() {
        return name;
    }

    public String getStrength() {
        return strength;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public DosageForm getDosageForm() {
        return dosageForm;
    }

    public void setDosageForm(DosageForm dosageForm) {
        this.dosageForm = dosageForm;
    }

    @Override
    public String toString() {
        return "Medicine ID = " + medicineID +
                "; Name = " + name +
                "; Dosage Form = " + dosageForm +
                "; Strength = " + strength;
    }

    public String toFile() {
        return medicineID + "| " + name + "| " + dosageForm + "| " + strength;
    }
}
