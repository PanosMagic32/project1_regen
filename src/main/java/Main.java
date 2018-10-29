import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String sFunc, sExp;

        while (true) {
            printMainMenu();
            sFunc = selectFunctionality();
            printExportTypeMenu();
            sExp = selectExportType();

            if (sFunc.equals("1") && sExp.equals("1")) {
                //status into file


            }else if (sFunc.equals("1") && sExp.equals("2")) {
                //status into console


            }else if (sFunc.equals("2") && sExp.equals("1")) {
                //forecoming into file


            }else if (sFunc.equals("2") && sExp.equals("2")) {
                //forecoming into console


            }else if (sFunc.equals("3") && sExp.equals("1")) {
                //expiries into file
                //arraylist me ola ta vehicles.sort(,new vehicle comparator);

            }else if (sFunc.equals("3") && sExp.equals("2")) {
                //expiries into console


            }else if (sFunc.equals("4") && sExp.equals("1")) {
                //calc fine into file


            }else if (sFunc.equals("4") && sExp.equals("2")) {
                //calc fine into console


            }


            //ask to continue!!
            Scanner input = new Scanner(System.in);
            System.out.println("\n\nPress any key to continue...");
            input.nextLine();

        }
    }

    protected static void printMainMenu() {
        System.out.println("\n\n");
        System.out.println("------------------------------------");
        System.out.println("--- Select Functionality to perform:");
        System.out.println("------------------------------------");
        System.out.println("1 - Vehicle Insurance status");                 //F1
        System.out.println("2 - Forecoming Expires (given a time-frame)");  //F2
        System.out.println("3 - Vehicles ordered by plate");                        //F3
        System.out.println("4 - Calculate fine cost per Owner");            //F4
        System.out.println("------------------------------------");
        System.out.println("0 - Exit");
        System.out.println("------------------------------------");
    }

    protected static void printExportTypeMenu() {
        System.out.println("\n\n");
        System.out.println("----------------------");
        System.out.println("--- Enter export type:");
        System.out.println("----------------------");
        System.out.println("1 - File");
        System.out.println("2 - Console");
        System.out.println("----------------------");
    }

    protected static String selectFunctionality() {
        Scanner input = new Scanner(System.in);
        String selection = "";

        System.out.print("Make a selection: ");
        do {
            selection = input.nextLine();
            if (selection.length() == 1) {
                if (selection.equals("1") || selection.equals("2") || selection.equals("3") || selection.equals("4")) {
                    //System.out.println("selected " + selection);
                    return selection;
                } else if (selection.equals("0")) {
                    System.exit(0);
                }
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
            if (selection.length() == 1) {
                if (selection.equals("1") || selection.equals("2")) {
                    //System.out.println("selected " + selection);
                    return selection;
                }
            }
            System.out.print("Make a selection (1 or 2): ");
        } while (true);
    }
}
