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
        this.patients = new HashMap<>();
    }

    public Doctor(String IdNumber, String FirstName, String LastName, String yob, Gender gender, String address, String telephoneNumber,
                  int yearsOfExperience, int clinicHours, Education education,
                  Specialization specialization, double consultationFee,
                  HashMap<String, Patient> patients) throws ParseException {
        super(IdNumber, FirstName, LastName, yob, gender, address, telephoneNumber);
        this.yearsOfExperience = yearsOfExperience;
        this.clinicHours = clinicHours;
        this.education = education;
        this.specialization = specialization;
        this.consultationFee = consultationFee;
        this.patients = new HashMap<>(patients);
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
        return "Doctor{" +
                "clinicHours=" + clinicHours +
                ", yearsOfExperience=" + yearsOfExperience +
                ", education='" + education + '\'' +
                ", specialization=" + specialization +
                ", consultationFee=" + consultationFee +
                ", patients=" + patients +
                '}';
    }

    //Ham them benh nhan
//    public void addNewPatient(Patient patient) {
//        if (patient == null || patient.getIDNumber() == null || patient.getIDNumber().isEmpty()) {
//            throw new IllegalArgumentException("Patient or Patient ID cannot be null or empty");
//        }
//        patients.put(patient.getIDNumber(), patient);
//    }
//
    //Ham tim kiem benh nhan
    public Patient findPatient(String IDNumber) {
        return patients.get(IDNumber);
    }


    public void listPatient(HashMap<String, Patient> patients) {
        if (getPatients().isEmpty()) {//check neu benh nhan khong co thi in ra No patient found
            System.out.println("No patient found.");
        } else {
            for (Map.Entry<String, Patient> entry : patients.entrySet()) { //chay 1 vong foreach voi 'entry' đại diện cho một cặp khóa-giá trị. tu day in ra danh sach patients
                System.out.println(entry.getValue());
            }
        }
    }


    public Patient removePatient(String IDNumber) {//xoa benh nhan
        return patients.remove(IDNumber);
    }


    public Medicine findMedicine(String IDNumber, Medicine medicines) {
        if (patients.containsKey(IDNumber)) {//check benh nhan bang idnumber
            Patient patient = patients.get(IDNumber);
            patient.addMedicine(medicines);//neu co thi add thuoc vao cua nguoi benh day
            return medicines;

        } else {
            throw new IllegalArgumentException("Patient with ID" + IDNumber + " not found.");//xu ly ngoai te neu khong co benh nhan day
        }
    }
}

