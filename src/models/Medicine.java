package models;

import models.enums.DosageForm;

public class Medicine  {
    private final String medicineID ;
    private String name;
    private DosageForm dosageForm;
    private String strength;

    public Medicine(String medicineID,  String name, DosageForm dosageForm, String strength) {
        this.medicineID = medicineID;
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

    public static void getHead() {
        String format = "| %-10s | %-20s | %-15s | %-15s |%n";
        System.out.println("+-------------+----------------------+-----------------+-----------------+");
        System.out.printf(format, "Medicine ID", "Name", "Dosage Form", "Strength");
        System.out.println("+-------------+----------------------+-----------------+-----------------+");
    }

    public void generateTable() {
        String format = "| %-10s  | %-20s | %-15s | %-15s |%n";
        System.out.printf(format, getMedicineID(), getName(), getDosageForm(), getStrength());
        System.out.println("+-------------+----------------------+-----------------+-----------------+");
    }
}
