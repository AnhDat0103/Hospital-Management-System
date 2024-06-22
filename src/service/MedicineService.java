package service;

import exception.HandlingException;
import models.Medicine;
import models.enums.DosageForm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicineService {

    Scanner sc = new Scanner(System.in);
    private  List<Medicine> medicinesOfCARDIOLOGY = new ArrayList<>();    // list of CARDIOLOGY. The list has information of medicines in CARDIOLOGY.
    private  List<Medicine> medicinesOfDERMATOLOGY = new ArrayList<>();   // list of DERMATOLOGY. The list has information of medicines in DERMATOLOGY.
    private  List<Medicine> medicinesOfENT = new ArrayList<>();           // list of ENT. The list has information of medicines in ENT.
    private  List<Medicine> medicinesOfNEUROLOGY = new ArrayList<>();     // list of NEUROLOGY. The list has information of medicines in NEUROLOGY.
    private  List<Medicine> medicinesOfGERIATRIC = new ArrayList<>();     // list of GERIATRIC. The list has information of medicines in GERIATRIC.

    public List<Medicine> getMedicinesOfCARDIOLOGY() {
        return medicinesOfCARDIOLOGY;
    }

    public void setMedicinesOfCARDIOLOGY(List<Medicine> medicinesOfCARDIOLOGY) {
        this.medicinesOfCARDIOLOGY = medicinesOfCARDIOLOGY;
    }

    public List<Medicine> getMedicinesOfDERMATOLOGY() {
        return medicinesOfDERMATOLOGY;
    }

    public void setMedicinesOfDERMATOLOGY(List<Medicine> medicinesOfDERMATOLOGY) {
        this.medicinesOfDERMATOLOGY = medicinesOfDERMATOLOGY;
    }

    public List<Medicine> getMedicinesOfENT() {
        return medicinesOfENT;
    }

    public void setMedicinesOfENT(List<Medicine> medicinesOfENT) {
        this.medicinesOfENT = medicinesOfENT;
    }

    public List<Medicine> getMedicinesOfNEUROLOGY() {
        return medicinesOfNEUROLOGY;
    }

    public void setMedicinesOfNEUROLOGY(List<Medicine> medicinesOfNEUROLOGY) {
        this.medicinesOfNEUROLOGY = medicinesOfNEUROLOGY;
    }

    public List<Medicine> getMedicinesOfGERIATRIC() {
        return medicinesOfGERIATRIC;
    }

    public void setMedicinesOfGERIATRIC(List<Medicine> medicinesOfGERIATRIC) {
        this.medicinesOfGERIATRIC = medicinesOfGERIATRIC;
    }

    // METHOD OF MEDICINE
    public void addNewMedicine(int choice) {

        System.out.print("Medicine's name: ");
        String medicineName = sc.nextLine();

        int choice2;
        DosageForm dosageForm = null;
        do {
            System.out.printf("Choose the type of medicine:%10s", " ");
            System.out.printf("%s10s|%10s|%10s|%10s|", "1. TABLETS", "2. LIQUIDS", "3. TOPICAL", "4. LOZENGES");
            System.out.print("Your choice: ");
            choice2 = HandlingException.getInteger(sc);
            switch (choice2) {
                case 1:
                    dosageForm = DosageForm.TABLETS;
                    break;
                case 2:
                    dosageForm = DosageForm.LIQUIDS;
                    break;
                case 3:
                    dosageForm = DosageForm.TOPICAL;
                    break;
                case 4:
                    dosageForm = DosageForm.LOZENGES;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice2 < 1 || choice2 > 4);

        System.out.print("Medicine's strength: ");
        String strength = sc.nextLine();

        switch (choice) {
            case 1:
                medicinesOfCARDIOLOGY.add( new Medicine(medicineName, dosageForm, strength ));
                System.out.println("added new medicine.");
                break;
            case 2:
                medicinesOfDERMATOLOGY.add( new Medicine(medicineName, dosageForm, strength ));
                System.out.println("added new medicine.");
                break;
            case 3:
                medicinesOfENT.add( new Medicine(medicineName, dosageForm, strength ));
                System.out.println("added new medicine.");
                break;
            case 4:
                medicinesOfNEUROLOGY.add( new Medicine(medicineName, dosageForm, strength ));
                System.out.println("added new medicine.");
                break;
            case 5:
                medicinesOfGERIATRIC.add( new Medicine(medicineName, dosageForm, strength ));
                System.out.println("added new medicine.");
                break;
        }
    }

    public void showMedicineList(int choice) {
        switch (choice) {
            case 1:
                if (medicinesOfCARDIOLOGY.isEmpty()) {
                    System.out.println("no one medicine in here");
                }
                medicinesOfCARDIOLOGY.forEach(Medicine ->System.out.println(Medicine.toString()));
                break;
            case 2:
                if (medicinesOfDERMATOLOGY.isEmpty()) {
                    System.out.println("no one medicine in here");
                }
                medicinesOfDERMATOLOGY.forEach(Medicine ->System.out.println(Medicine.toString()));
                break;
            case 3:
                if (medicinesOfENT.isEmpty()) {
                    System.out.println("no one medicine in here");
                }
                medicinesOfENT.forEach(Medicine ->System.out.println(Medicine.toString()));
                break;
            case 4:
                if (medicinesOfNEUROLOGY.isEmpty()) {
                    System.out.println("no one medicine in here");
                }
                medicinesOfNEUROLOGY.forEach(Medicine ->System.out.println(Medicine.toString()));
                break;
            case 5:
                if (medicinesOfGERIATRIC.isEmpty()) {
                    System.out.println("no one medicine in here");
                }
                medicinesOfGERIATRIC.forEach(Medicine ->System.out.println(Medicine.toString()));
                break;
        }
    }

    public Medicine findMedicine(String IDNumber, int choice) {
        switch (choice) {
            case 1:
                if (medicinesOfCARDIOLOGY.isEmpty()) {
                    return null;
                }
                return medicinesOfCARDIOLOGY.stream().filter(medicine ->  medicine.getMedicineID().equals(IDNumber)).findFirst().orElse(null);
            case 2:
                if (medicinesOfDERMATOLOGY.isEmpty()) {
                    return null;
                }
                return medicinesOfDERMATOLOGY.stream().filter(medicine ->  medicine.getMedicineID().equals(IDNumber)).findFirst().orElse(null);
            case 3:
                if (medicinesOfENT.isEmpty()) {
                    return null;
                }
                return medicinesOfENT.stream().filter(medicine ->  medicine.getMedicineID().equals(IDNumber)).findFirst().orElse(null);
            case 4:
                if (medicinesOfNEUROLOGY.isEmpty()) {
                    return null;
                }
                return medicinesOfNEUROLOGY.stream().filter(medicine ->  medicine.getMedicineID().equals(IDNumber)).findFirst().orElse(null);
            case 5:
                if (medicinesOfGERIATRIC.isEmpty()) {
                    return null;
                }
                return medicinesOfGERIATRIC.stream().filter(medicine ->  medicine.getMedicineID().equals(IDNumber)).findFirst().orElse(null);
        }
        return null;
    }

    public Medicine updateMedicine(String IDNumber, int choice) {

        if (findMedicine(IDNumber, choice) == null) {
            return null;
        } else {
            System.out.print("Medicine's name: ");
            findMedicine(IDNumber, choice).setName(sc.nextLine());

            int choice2;
            do {
                System.out.printf("Choose the type of medicine:%10s", " ");
                System.out.printf("%s10s|%10s|%10s|%10s|", "1. TABLETS", "2. LIQUIDS", "3. TOPICAL", "4. LOZENGES");
                System.out.print("Your choice: ");
                choice2 = HandlingException.getInteger(sc);
                switch (choice2) {
                    case 1:
                        findMedicine(IDNumber, choice).setDosageForm(DosageForm.TABLETS);
                        break;
                    case 2:
                        findMedicine(IDNumber, choice).setDosageForm(DosageForm.LIQUIDS);
                        break;
                    case 3:
                        findMedicine(IDNumber, choice).setDosageForm(DosageForm.TOPICAL);
                        break;
                    case 4:
                        findMedicine(IDNumber, choice).setDosageForm(DosageForm.LOZENGES);
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            } while (choice2 < 1 || choice2 > 4);

            System.out.print("Medicine's strength: ");
            findMedicine(IDNumber, choice).setStrength(sc.nextLine());

            switch (choice) {
                case 1:
                    medicinesOfCARDIOLOGY.set(medicinesOfCARDIOLOGY.indexOf(findMedicine(IDNumber, choice)), findMedicine(IDNumber, choice));
                    System.out.println("updated information of medicine.");
                    break;
                case 2:
                    medicinesOfDERMATOLOGY.set(medicinesOfDERMATOLOGY.indexOf(findMedicine(IDNumber, choice)), findMedicine(IDNumber, choice));
                    System.out.println("updated information of medicine.");
                    break;
                case 3:
                    medicinesOfENT.set(medicinesOfENT.indexOf(findMedicine(IDNumber, choice)), findMedicine(IDNumber, choice));
                    System.out.println("updated information of medicine.");
                    break;
                case 4:
                    medicinesOfNEUROLOGY.set(medicinesOfNEUROLOGY.indexOf(findMedicine(IDNumber, choice)), findMedicine(IDNumber, choice));
                    System.out.println("updated information of medicine.");
                    break;
                case 5:
                    medicinesOfGERIATRIC.set(medicinesOfGERIATRIC.indexOf(findMedicine(IDNumber, choice)), findMedicine(IDNumber, choice));
                    System.out.println("updated information of medicine.");
                    break;
            }
            return findMedicine(IDNumber, choice);
        }
    }

    public void removeMedicine(String IDNumber, int choice) {
        if (findMedicine(IDNumber, choice) == null) {
            System.out.println("The medicine does not exist.");
        } else {
            switch (choice) {
                case 1:
                    medicinesOfCARDIOLOGY.remove(findMedicine(IDNumber, choice));
                    System.out.println("The medicine has been removed.");
                    break;
                case 2:
                    medicinesOfDERMATOLOGY.remove(findMedicine(IDNumber, choice));
                    System.out.println("The medicine has been removed.");
                    break;
                case 3:
                    medicinesOfENT.remove(findMedicine(IDNumber, choice));
                    System.out.println("The medicine has been removed.");
                    break;
                case 4:
                    medicinesOfNEUROLOGY.remove(findMedicine(IDNumber, choice));
                    System.out.println("The medicine has been removed.");
                    break;
                case 5:
                    medicinesOfGERIATRIC.remove(findMedicine(IDNumber, choice));
                    System.out.println("The medicine has been removed.");
                    break;
            }
        }
    }
}
