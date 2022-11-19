package task1;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

public class Boat {
    private LocalDateTime timeAppearance;
    private int numberOfFreeSeats;
    private boolean isFinalStop;
    private ArrayList<LocalDateTime> passengersOnBoard = new ArrayList<>();

    public Boat(int year, int month, int day, int hour, int minutes, int seconds, boolean isFinalStop) {
        this.timeAppearance = LocalDateTime.of(year, month, day, hour, minutes, seconds);
        this.numberOfFreeSeats = new Random().nextInt(4) + 1;
        this.isFinalStop = isFinalStop;
    }

    public LocalDateTime getTimeAppearance() {
        return timeAppearance;
    }

    public int getNumberOfFreeSeats() {
        return numberOfFreeSeats;
    }

    public ArrayList<LocalDateTime> getPassengersOnBoard() {
        return passengersOnBoard;
    }

    public boolean isFinalStop() {
        return isFinalStop;
    }

    public boolean isPickUpPassenger(LocalDateTime timePassenger) {
        if (numberOfFreeSeats != 0) {
            passengersOnBoard.add(timePassenger);
            numberOfFreeSeats--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Boat{" +
                "timeAppearance=" + timeAppearance +
                ", numberOfFreeSeats=" + numberOfFreeSeats +
                ", isFinalStop=" + isFinalStop +
                ", passengersOnBoard=" + passengersOnBoard +
                '}' + "\n";
    }
}
