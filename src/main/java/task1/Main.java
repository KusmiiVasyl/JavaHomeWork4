package task1;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


    }
//    byte numMenu;
//        while((numMenu = showMenu()) != 0){
//        switch (numMenu) {
//            case 1 -> System.out.println("Case 1");
//            case 2 -> System.out.println("Case 2");
//            case 3 -> System.out.println("Case 3");
//        }
//    }
    static byte showMenu(){
        System.out.println("______________________MENU_______________________");
        System.out.println("Enter a number from the menu to enter the required information:");
        System.out.println("press 1 - to enter the average time between passenger arrivals;");
        System.out.println("press 2 - to enter the average time between passenger arrivals;");
        System.out.println("press 3 - to enter the average time between the appearance of boats;");
        System.out.println("press 0 - to EXIT from program.");
        System.out.println("-------------------------------------------------");
        Scanner in = new Scanner(System.in);
        byte numMenu = in.nextByte();
        return numMenu;
    }
}
