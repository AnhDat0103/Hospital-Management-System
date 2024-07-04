package controller;

import exception.HandlingException;
import fileIO.FileIO;
import models.Medicine;
import models.enums.DosageForm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicineController {

    Scanner sc = new Scanner(System.in);
    private  List<Medicine> medicinesOfCARDIOLOGY = new ArrayList<>();    // list of CARDIOLOGY. The list has information of medicines in CARDIOLOGY.
    private  List<Medicine> medicinesOfDERMATOLOGY = new ArrayList<>();   // list of DERMATOLOGY. The list has information of medicines in DERMATOLOGY.
    private  List<Medicine> medicinesOfENT = new ArrayList<>();           // list of ENT. The list has information of medicines in ENT.
    private  List<Medicine> medicinesOfNEUROLOGY = new ArrayList<>();     // list of NEUROLOGY. The list has information of medicines in NEUROLOGY.
    private  List<Medicine> medicinesOfGERIATRIC = new ArrayList<>();     // list of GERIATRIC. The list has information of medicines in GERIATRIC.

    public List<Medicine> getMedicinesOfCARDIOLOGY() {
        return FileIO.getMedicines("medicinesOfCARDIOLOGY.txt", medicinesOfCARDIOLOGY);
    }

    public List<Medicine> getMedicinesOfDERMATOLOGY() {
        return FileIO.getMedicines("medicinesOfDERMATOLOGY.txt", medicinesOfDERMATOLOGY);
    }

    public List<Medicine> getMedicinesOfENT() {
        return FileIO.getMedicines("medicinesOfENT.txt", medicinesOfENT);
    }

    public List<Medicine> getMedicinesOfNEUROLOGY() {
        return FileIO.getMedicines("medicinesOfNEUROLOGY.txt", medicinesOfNEUROLOGY);

    }

    public List<Medicine> getMedicinesOfGERIATRIC() {
        return FileIO.getMedicines("medicinesOfGERIATRIC.txt", medicinesOfGERIATRIC);
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
                getMedicinesOfCARDIOLOGY().add( new Medicine(medicineName, dosageForm, strength ));
                FileIO.writeMedicineDataToFile("medicinesOfCARDIOLOGY.txt", medicinesOfCARDIOLOGY);
                System.out.println("added new medicine.");
                break;
            case 2:
                getMedicinesOfDERMATOLOGY().add( new Medicine(medicineName, dosageForm, strength ));
                FileIO.writeMedicineDataToFile("medicinesOfDERMATOLOGY.txt", medicinesOfDERMATOLOGY);
                System.out.println("added new medicine.");
                break;
            case 3:
                getMedicinesOfENT().add( new Medicine(medicineName, dosageForm, strength ));
                FileIO.writeMedicineDataToFile("medicinesOfENT.txt", medicinesOfENT);
                System.out.println("added new medicine.");
                break;
            case 4:
                getMedicinesOfNEUROLOGY().add( new Medicine(medicineName, dosageForm, strength ));
                FileIO.writeMedicineDataToFile("medicinesOfNEUROLOGY.txt", medicinesOfNEUROLOGY);
                System.out.println("added new medicine.");
                break;
            case 5:
                getMedicinesOfGERIATRIC().add( new Medicine(medicineName, dosageForm, strength ));
                FileIO.writeMedicineDataToFile("medicinesOfGERIATRIC.txt", medicinesOfGERIATRIC);
                System.out.println("added new medicine.");
                break;
        }
    }

    public void showMedicineList(int choice) {
        switch (choice) {
            case 1:
                getMedicinesOfCARDIOLOGY().forEach(System.out::println);
                break;
            case 2:
                getMedicinesOfDERMATOLOGY().forEach(System.out::println);
                break;
            case 3:
                getMedicinesOfENT().forEach(System.out::println);
                break;
            case 4:
                getMedicinesOfNEUROLOGY().forEach(System.out::println);
                break;
            case 5:
                getMedicinesOfGERIATRIC().forEach(System.out::println);
                break;
        }
    }

    public Medicine findMedicine(String IDNumber, int choice) throws IOException {
        switch (choice) {
            case 1:
                if(FileIO.checkIDInFile(IDNumber, "medicinesOfCARDIOLOGY.txt"))
                    return getMedicinesOfCARDIOLOGY().stream().filter(m -> m.getMedicineID().equals(IDNumber)).findFirst().orElse(null);
            case 2:
                if(FileIO.checkIDInFile(IDNumber, "medicinesOfDERMATOLOGY.txt"))
                    return getMedicinesOfDERMATOLOGY().stream().filter(m -> m.getMedicineID().equals(IDNumber)).findFirst().orElse(null);
            case 3:
                if(FileIO.checkIDInFile(IDNumber, "medicinesOfENT.txt"))
                    return getMedicinesOfENT().stream().filter(m -> m.getMedicineID().equals(IDNumber)).findFirst().orElse(null);
            case 4:
                if(FileIO.checkIDInFile(IDNumber, "medicinesOfNEUROLOGY.txt"))
                    return getMedicinesOfNEUROLOGY().stream().filter(m -> m.getMedicineID().equals(IDNumber)).findFirst().orElse(null);
            case 5:
                if(FileIO.checkIDInFile(IDNumber, "medicinesOfGERIATRIC.txt"))
                    return getMedicinesOfGERIATRIC().stream().filter(m -> m.getMedicineID().equals(IDNumber)).findFirst().orElse(null);
        }
        return null;
    }

    public void updateMedicine(String IDNumber, int choice) throws IOException {
        Medicine medicine = findMedicine(IDNumber, choice);
        if (medicine == null) {
            System.out.println("Medicine not found");
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
                    FileIO.writeMedicineDataToFile("medicinesOfCARDIOLOGY.txt", medicinesOfCARDIOLOGY);
                    System.out.println("updated information of medicine.");
                    break;
                case 2:
                    FileIO.writeMedicineDataToFile("medicinesOfDERMATOLOGY.txt", medicinesOfDERMATOLOGY);
                    System.out.println("updated information of medicine.");
                    break;
                case 3:
                    FileIO.writeMedicineDataToFile("medicinesOfENT.txt", medicinesOfENT);
                    System.out.println("updated information of medicine.");
                    break;
                case 4:
                    FileIO.writeMedicineDataToFile("medicinesOfNEUROLOGY.txt", medicinesOfNEUROLOGY);
                    System.out.println("updated information of medicine.");
                    break;
                case 5:
                    FileIO.writeMedicineDataToFile("medicinesOfGERIATRIC.txt", medicinesOfGERIATRIC);
                    System.out.println("updated information of medicine.");
                    break;
            }
        }
    }

    public void removeMedicine(String IDNumber, int choice) throws IOException {
        Medicine medicine = findMedicine(IDNumber, choice);
        if (medicine == null) {
            System.out.println("The medicine does not exist.");
        } else {
            switch (choice) {
                case 1:
                    medicinesOfCARDIOLOGY.remove(medicine);
                    FileIO.writeMedicineDataToFile("medicinesOfCARDIOLOGY.txt", medicinesOfCARDIOLOGY);
                    System.out.println("The medicine has been removed.");
                    break;
                case 2:
                    medicinesOfDERMATOLOGY.remove(medicine);
                    FileIO.writeMedicineDataToFile("medicinesOfDERMATOLOGY.txt", medicinesOfDERMATOLOGY);
                    System.out.println("The medicine has been removed.");
                    break;
                case 3:
                    medicinesOfENT.remove(medicine);
                    FileIO.writeMedicineDataToFile("medicinesOfENT.txt", medicinesOfENT);
                    System.out.println("The medicine has been removed.");
                    break;
                case 4:
                    medicinesOfNEUROLOGY.remove(medicine);
                    FileIO.writeMedicineDataToFile("medicinesOfNEUROLOGY.txt", medicinesOfNEUROLOGY);
                    System.out.println("The medicine has been removed.");
                    break;
                case 5:
                    medicinesOfGERIATRIC.remove(medicine);
                    FileIO.writeMedicineDataToFile("medicinesOfGERIATRIC.txt", medicinesOfGERIATRIC);
                    System.out.println("The medicine has been removed.");
                    break;
            }
        }
    }
}
