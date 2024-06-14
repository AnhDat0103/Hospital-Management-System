package models;

public class Person {
    private String IDNumber;
    private String FirstName;
    private String LastName;
    private String yob;
    private int age;
    private String gender;
    private String address;
    private String telephoneNumber;

    public Person() {

    }
    public Person(String IdNumber, String FirstName, String LastName, String yob, int age, String gender, String address, String telephoneNumber) {
        this.IDNumber = IdNumber;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.yob = yob;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
    public void setYob(String yob) {
        this.yob = yob;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "address='" + address + '\'' +
                ", IDNumber='" + IDNumber + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", yob='" + yob + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                '}';
    }
    public String getFullName(){
        return FirstName + " " + LastName;
    }
    public int toAge(){
        return age;
    }

}
