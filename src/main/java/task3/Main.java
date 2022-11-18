package task3;

public class Main {
    public static void main(String[] args) {
        TaxInspectionOnFines taxInspectionOnFines = new TaxInspectionOnFines();

        Person person1 = new Person("Elvis", "Presley", 42, "Lviv");
        Person person2 = new Person("Donalt", "Trump", 55, "Donetsk");
        Person person3 = new Person("Marilyn", "Monroe", 28, "Ternopil");
        Person person4 = new Person("Eva", "Peron", 40, "Uhruniv");
        Person person5 = new Person("Rosa", "Parks", 31, "Solotvun");
        person1.addFine(new Fine("Оплата податкового векселя", 2500.56));
        person1.addFine(new Fine("Оплата податкового штрафу", 8300.56));
        person2.addFine(new Fine("Сплата фінансових санкцій", 12000.86));
        person3.addFine(new Fine("Стягнення в межах виконавчого провадження", 48500.56));
        person4.addFine(new Fine("Сплата грошових зобов'язань з митних платежів", 8256.65));
        person4.addFine(new Fine("Сплата фінансових санкцій", 16987.54));
        person5.addFine(new Fine("Сплата грошового зобов'язання за результатами  перевірки", 18965.47));

        taxInspectionOnFines.addViolation(1005, person1);
        taxInspectionOnFines.addViolation(1006, person2);
        taxInspectionOnFines.addViolation(1007, person3);
        taxInspectionOnFines.addViolation(20015, person4);
        taxInspectionOnFines.addViolation(20016, person5);

        taxInspectionOnFines.printingById(1008);
        taxInspectionOnFines.printingByTypeOfFine("Сплата фінансових санкцій");
        taxInspectionOnFines.printingByCity("Lviv");
        taxInspectionOnFines.addNewFineByPersonId(20016,
                new Fine("Сплата фінансових санкцій", 20500.55));
        taxInspectionOnFines.removeFineByPersonId(1005,
                new Fine("Оплата податкового штрафу", 8300.56));
        taxInspectionOnFines.changeCityByPersonId(20016, "Kyiv");
        taxInspectionOnFines.changeSumOfFine(20016,
                "Сплата грошового зобов'язання за результатами  перевірки", 500.50);

        taxInspectionOnFines.printingDatabase();
    }
}
