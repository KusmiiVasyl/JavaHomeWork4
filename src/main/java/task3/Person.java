package task3;

import java.util.ArrayList;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String cityOfResidence;

    private ArrayList<Fine> fines;

    public Person(String firstName, String lastName, int age, String cityOfResidence) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.cityOfResidence = cityOfResidence;
        this.fines = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getCityOfResidence() {
        return cityOfResidence;
    }

    public ArrayList<Fine> getFines() {
        return fines;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCityOfResidence(String cityOfResidence) {
        this.cityOfResidence = cityOfResidence;
    }

    public void addFine(Fine fine) {
        fines.add(fine);
    }

    public void showInfoPerson() {
        System.out.println("Full name: " + this.firstName + " " + this.lastName);
        System.out.println("Age: " + this.age);
        System.out.println("City: " + this.cityOfResidence);
        if (fines.isEmpty()) System.out.println("There are no fines...");
        else {
            for (int i = 0; i < fines.size(); i++) {
                System.out.print((i + 1) + ". ");
                fines.get(i).showFine();
            }
        }
    }
}
