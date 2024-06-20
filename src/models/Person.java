package models;

import exception.HandlingException;
import models.enums.Gender;
import validation.Validate;

import java.text.ParseException;

public class Person {
    private String IDNumber;
    private String FirstName;
    private String LastName;
    private String fullName;
    private String yob;
    private int age;
    private Gender gender;
    private String address;
    private String telephoneNumber;


    public Person() {

    }
    public Person(String IdNumber, String FirstName, String LastName, String yob, Gender gender, String address, String telephoneNumber) throws ParseException {
        this.IDNumber = IdNumber;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.fullName = getFullName();
        this.yob = yob;
        this.age = toAge(yob);
        this.gender = gender;
        this.address = Validate.formatName(address);
        this.telephoneNumber = telephoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = Validate.formatName(address);
    }
    public String getTelephoneNumber() {
        return telephoneNumber;
    }
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
    public String getIDNumber() {
        return IDNumber;
    }
    public void setIDNumber(String IDNumber) {
        this.IDNumber = IDNumber;
    }
    public String getFirstName() {
        return FirstName;
    }
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }
    public String getLastName() {
        return LastName;
    }
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }
    public String getYob() {
        return yob;
    }
    public void setYob(String yob) throws ParseException {
        this.yob = yob;
        this.age = toAge(yob);
    }
    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setFullName() {
        this.fullName = getFullName();
    }

    @Override
    public String toString() {
        return " IDNumber= '" + IDNumber +
                ", FullName='" + getFullName() +
                ", gender='" + gender +
                ", yob='" + yob +
                ", age=" + age +
                ", address='" + address +
                ", telephoneNumber='" + telephoneNumber;
    }
    //in ra fullname
    public String getFullName(){
        String fullName = this.FirstName + " " + this.LastName;
        return Validate.formatName(fullName);
    }
    //in ra tuoi
    public int toAge(String yob) throws ParseException {
       return Validate.toAge(yob);
    }

}
