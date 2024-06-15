import exception.HandlingException;
import models.Doctor;
import models.Medicine;

import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Hospital Management System");
        System.out.println("Take care the everyone's health together.");
        System.out.println("hihihh");
        System.out.println("Hello Tuan Anh");
        System.out.println("Hello anh dat");
        System.out.println("Hi Minh Cao");
        System.out.println("hello everyone!");
        System.out.println("Hello Kim Tuan");

        //test medicine
        Medicine med1 = new Medicine("001", "Panadol", "Tablet", "1 lit");
        System.out.println(med1.toString());
        //test doctor

    }
}