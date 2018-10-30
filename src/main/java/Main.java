import java.io.*;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    private static BufferedWriter output;
    private static DButils db;
    private static final String PLATE_REGEX = "[a-zA-Z]{3}-[0-9]{4}";

    public static void main(String[] args) throws Exception {

        String selectedFunctionality, selectedExportType;

        db = new DButils();
        db.connect();

        while (true) {
            printMainMenu();
            selectedFunctionality = selectFunctionality();

            printExportTypeMenu();
            selectedExportType = selectExportType();

            if (selectedExportType.equals("1")) {
                //output=file
                output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.csv")));
            } else {
                //output=console
                output = new BufferedWriter(new OutputStreamWriter(System.out));
            }


            if (selectedFunctionality.equals("1")) {
                //status
                String usersPlate = readPlate();
                db.searchByPlate(usersPlate);

                //syndesi stin vasi kai eepistrofi tou insurance status kai ektypwsi

            } else if (selectedFunctionality.equals("2")) {
                //forecoming time frame

            } else if (selectedFunctionality.equals("3")) {
                //expiries
                //arraylist me ola ta vehicles.sort(,new vehicle comparator);

            } else if (selectedFunctionality.equals("4")) {
                //calc fine

                printData("to kostos einai 50 euro");
            }

            //if(selectedExportType.equals("1")) System.out.println("File ready!");


            //ask to continue!!
            Scanner input = new Scanner(System.in);
            System.out.println("\n\nPress any key to continue...");
            input.nextLine();


        }
    }

    private static String readPlate() {
        Scanner input = new Scanner(System.in);
        String usersPlate = "";

        System.out.print("Give a plate number: ");
        do {
            usersPlate = input.nextLine();
            if (usersPlate.matches(PLATE_REGEX)) {
                usersPlate=usersPlate.toLowerCase();
                return usersPlate;
            }
            System.out.print("Give a plate number (ex: NHO-2233): ");
        } while (true);


    }

    private static void printData(String stringToPrint) throws IOException {
        output.write(stringToPrint);
        output.flush();
    }

    protected static void printMainMenu() {
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

    protected static void printExportTypeMenu() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("----------------------");
        System.out.println("--- Enter export type:");
        System.out.println("----------------------");
        System.out.println("1 - File");
        System.out.println("2 - Console");
        System.out.println("----------------------");
    }

    protected static String selectFunctionality() throws SQLException {
        Scanner input = new Scanner(System.in);
        String selection = "";

        System.out.print("Make a selection: ");
        do {
            selection = input.nextLine();
            if (selection.equals("1") || selection.equals("2") || selection.equals("3") || selection.equals("4")) {
                return selection;
            } else if (selection.equals("0")) {
                db.disconnect();
                System.exit(0);
            }
            System.out.print("Make a selection (Options: 0, 1, 2, 3 or 4): ");
        } while (true);
    }

    protected static String selectExportType() {
        Scanner input = new Scanner(System.in);
        String selection = "";

        System.out.print("Make a selection: ");
        do {
            selection = input.nextLine();
            if (selection.equals("1") || selection.equals("2")) {
                return selection;
            }
            System.out.print("Make a selection (1 or 2): ");
        } while (true);
    }
}
