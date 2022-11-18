package task3;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class TaxInspectionOnFines {
    private Map<Integer, Person> listDataFines = new HashMap<>();

    public void addViolation(Integer id, Person person) {
        listDataFines.put(id, person);
    }

    public void printingDatabase() {
        listDataFines.forEach(this::printIdAndPerson);
    }

    public void printingById(Integer id) {
        Person person = listDataFines.get(id);
        if (person != null) printIdAndPerson(id, person);
        else {
            System.out.println("There is no code data.");
        }
    }

    public void printingByTypeOfFine(String typeOfFine) {
        listDataFines.forEach((key, val) -> {
            val.getFines().forEach(fine -> {
                if (fine.getTypeOfFine() == typeOfFine) {
                    printIdAndPerson(key, val);
                }
            });
        });
    }

    public void printingByCity(String city) {
        listDataFines.forEach((key, val) -> {
            if (val.getCityOfResidence() == city) printIdAndPerson(key, val);
        });
    }

    public void addNewFineByPersonId(Integer id, Fine fine) {
        Person person = listDataFines.get(id);
        if (person != null) person.addFine(fine);
    }

    public void removeFineByPersonId(Integer id, Fine fine) {
        Person person = listDataFines.get(id);
        if (person != null) {
            for (int i = 0; i < person.getFines().size(); i++) {
                if (person.getFines().get(i).equals(fine)) {
                    person.getFines().remove(i);
                }
            }
        }
    }

    public void changeCityByPersonId(Integer id, String city) {
        Person person = listDataFines.get(id);
        if (person != null) {
            person.setCityOfResidence(city);
        }
    }

    public void changeSumOfFine(Integer id, String typeOfSum, double newSum) {
        Person person = listDataFines.get(id);
        if (person != null) {
            for (int i = 0; i < person.getFines().size(); i++) {
                if (person.getFines().get(i).getTypeOfFine() == typeOfSum) {
                    person.getFines().get(i).setSum(newSum);
                }
            }
        }
    }

    private void printIdAndPerson(Integer id, Person person) {
        System.out.println("--------------------------------");
        System.out.print("Id: " + id + ".  ");
        person.showInfoPerson();
        System.out.println("--------------------------------");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaxInspectionOnFines that = (TaxInspectionOnFines) o;

        return Objects.equals(listDataFines, that.listDataFines);
    }

    @Override
    public int hashCode() {
        return listDataFines != null ? listDataFines.hashCode() : 0;
    }
}
