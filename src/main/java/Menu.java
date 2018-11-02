import java.io.IOException;
import java.util.Scanner;

public class Menu {



    static void printMainMenu() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("------------------------------------");
        System.out.println("--- Select Functionality to perform:");
        System.out.println("------------------------------------");
        System.out.println("1 - Vehicle Insurance status");                 //F1
        System.out.println("2 - Forecoming Expires (given a time-frame)");  //F2
        System.out.println("3 - Vehicles ordered by plate");                        //F3
        System.out.println("4 - Calculate fine cost per owner");            //F4
        System.out.println("------------------------------------");
        System.out.println("0 - Exit");
        System.out.println("------------------------------------");
    }

    static void printExportTypeMenu() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("----------------------");
        System.out.println("--- Enter export type:");
        System.out.println("----------------------");
        System.out.println("1 - File");
        System.out.println("2 - Console");
        System.out.println("----------------------");
    }

}
