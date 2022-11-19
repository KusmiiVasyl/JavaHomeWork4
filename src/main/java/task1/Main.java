package task1;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {
    public static ArrayList<LocalDateTime> averageTimeBetweenArrivalsOfPassengers = new ArrayList<>();
    public static ArrayList<Boat> averageTimeBetweenAppearanceOfBoats = new ArrayList<>();

    public static void main(String[] args) {
        Collections.addAll(averageTimeBetweenArrivalsOfPassengers,
                LocalDateTime.of(2022, 11, 18, 10, 15, 50),
                LocalDateTime.of(2022, 11, 18, 10, 55, 15),
                LocalDateTime.of(2022, 11, 18, 12, 33, 59),
                LocalDateTime.of(2022, 11, 18, 13, 40, 30),
                LocalDateTime.of(2022, 11, 18, 15, 12, 25),
                LocalDateTime.of(2022, 11, 18, 17, 05, 10),
                LocalDateTime.of(2022, 11, 18, 18, 26, 40),
                LocalDateTime.of(2022, 11, 18, 20, 44, 36),
                LocalDateTime.of(2022, 11, 18, 22, 50, 03),
                LocalDateTime.of(2022, 11, 19, 00, 25, 40),
                LocalDateTime.of(2022, 11, 19, 02, 40, 52),
                LocalDateTime.of(2022, 11, 19, 04, 20, 56)
        );

        Collections.addAll(averageTimeBetweenAppearanceOfBoats,
                new Boat(2022, 11, 18, 13, 20, 25, false),
                new Boat(2022, 11, 18, 16, 15, 40, true),
                new Boat(2022, 11, 18, 19, 50, 35, false),
                new Boat(2022, 11, 19, 01, 20, 18, false),
                new Boat(2022, 11, 19, 06, 56, 55, false)
        );

        System.out.println("Середній час перебування людини на зупинці становить: "
                + averageTimePersonStaysAtStop());
    }

    static LocalTime averageTimePersonStaysAtStop() {
        boardingOfPassengersInBoat();
        ArrayList<Long> timeWaitingPassengers = new ArrayList<>();
        averageTimeBetweenAppearanceOfBoats.forEach(boat -> {
            boat.getPassengersOnBoard().forEach(passengerTime -> {
                timeWaitingPassengers.add(ChronoUnit.SECONDS.between(passengerTime, boat.getTimeAppearance()));
            });
        });
        Optional<Long> timeWaiting = timeWaitingPassengers.stream().reduce(Long::sum);
        return LocalTime.ofSecondOfDay(timeWaiting.get() / timeWaitingPassengers.size());
    }

    static void boardingOfPassengersInBoat() {
        averageTimeBetweenAppearanceOfBoats.forEach(boat -> {
            for (int i = 0; i < averageTimeBetweenArrivalsOfPassengers.size(); i++) {
                if (boat.isFinalStop() || boat.getNumberOfFreeSeats() == 0) break;
                if (boat.isPickUpPassenger(averageTimeBetweenArrivalsOfPassengers.get(i))) {
                    averageTimeBetweenArrivalsOfPassengers.remove(i);
                    i--;
                }
            }
        });
    }
}
