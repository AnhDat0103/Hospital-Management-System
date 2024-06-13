package models;

public class Medicine {
    private String medicineID;
    private String name;
    private String dosageForm;
    private String strength;

    public Medicine() {
        this.medicineID = "";
        this.name = "";
        this.dosageForm = "";
        this.strength = "";
    }

    public Medicine(String medicineID, String name, String dosageForm, String strength) {
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

    public String getDosageForm() {
        return dosageForm;
    }

    public String getStrength() {
        return strength;
    }

    public void setMedicineID(String medicineID) {
        this.medicineID = medicineID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDosageForm(String dosageForm) {
        this.dosageForm = dosageForm;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "Medicine: " +
                "Medicine ID = " + medicineID +
                "; Name = " + name +
                "; Dosage Form = " + dosageForm +
                "; Strength = " + strength;
    }
}
