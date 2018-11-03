package org.regeneration.team4.project1.App;

import org.regeneration.team4.project1.DB.DBtableGetter;
import org.regeneration.team4.project1.DB.DButils;
import org.regeneration.team4.project1.UI.Menu;
import org.regeneration.team4.project1.UI.Printer;
import org.regeneration.team4.project1.UI.UserInputReader;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static final String FUNCTIONALITY_REGEX = "[0-4]";
    private static final String EXPORT_TYPE_REGEX = "[1-2]";
    private static final String PLATE_REGEX = "[a-zA-Z]{3}-[0-9]{4}";
    private static final String FINE_REGEX = "[1-9]{1}[0-9]*";
    private static final String TIMEFRAME_REGEX = "[0-9]*";
    private static Printer printer;

    public static void main(String[] args) {
        String selectedFunctionality;
        String selectedExportType;

        while (true) {
            //prints main menu to select programs functionality
            Menu.printMainMenu();
            selectedFunctionality = UserInputReader.userInput(FUNCTIONALITY_REGEX, "Select functionality: ", "Select functionality (eg. 1, 2, 3, 4 or 0): ");

            if (selectedFunctionality.equals("0")) System.exit(0);

            //prints the export menu and selects the type
            Menu.printExportTypeMenu();
            selectedExportType = UserInputReader.userInput(EXPORT_TYPE_REGEX, "Select export type: ", "Select export type (eg. 1 or 2): ");
            if (selectedExportType.equals("1")) {
                //output=file
                try {
                    printer = new Printer(new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.csv"))));
                } catch (FileNotFoundException exc) {
                    new CustomWrapException(exc);
                }
            } else {
                //output=console
                printer = new Printer(new BufferedWriter(new OutputStreamWriter(System.out)));
            }

            //retrieves the tables owner and vehicle and merges them
            DButils dbUtils = new DButils();
            dbUtils.connect();
            DBtableGetter tables = new DBtableGetter(dbUtils);
            ArrayList<Owner> oList = tables.getOwnersIncludedVehicles();
            dbUtils.disconnect();
            ArrayList<Vehicle> vList = new ArrayList<>();
            for (Owner o : oList) {
                vList.addAll(o.getVehicles());
            }

            //takes the current date to the given format
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            String now = dateFormat.format(c.getTime());

            switch (selectedFunctionality) {
                case "1":
                    //give the insurance status from plate input
                    String usersPlate = UserInputReader.userInput(PLATE_REGEX, "Give a plate number: ", "Give a plate number (ex: NHO-2233): ");

                    List<Vehicle> vehicleWithUsersPlate = vList.stream().filter((v) -> v.getPlate().equals(usersPlate)).collect(Collectors.toList());
                    if (!vehicleWithUsersPlate.isEmpty()) printer.printData(vehicleWithUsersPlate.get(0).toString());
                    else System.out.println("Plate not found.");
                    break;

                case "2":
                    //give the insurance status from plate input
                    int timeFrame = Integer.parseInt(UserInputReader.userInput(TIMEFRAME_REGEX, "Give a time frame (days): ", "Give a time frame (ex: 30): "));

                    try {
                        c.setTime(dateFormat.parse(now));
                    } catch (ParseException exc) {
                        new CustomWrapException(exc);
                    }
                    c.add(Calendar.DAY_OF_MONTH, timeFrame);
                    String nowPlusTimeFrame = dateFormat.format(c.getTime());
                    for (Vehicle v : vList) {
                        String exp = v.getIns_exp_date();
                        if (exp.compareTo(now) > 0 && exp.compareTo(nowPlusTimeFrame) < 0) {
                            printer.printData(v.toString());
                        }
                    }
                    break;

                case "3":
                    //displays all vehicles sorted by plate
                    vList.sort(new VehicleComparator());
                    for (Vehicle v : vList) {
                        printer.printData(v.toString());
                    }
                    break;

                case "4":
                    //calculate fine for expired insurances according to given cost
                    int usersFine = Integer.parseInt(UserInputReader.userInput(FINE_REGEX, "Give a cost for the fine: ", "Give a proper number (eg. 10): "));

                    for (Owner o : oList) {
                        int counter = 0;
                        for (Vehicle v : o.getVehicles()) {
                            String exp = v.getIns_exp_date();
                            if (o.getOid() == v.getOid() && exp.compareTo(now) < 0) counter++;
                        }
                        if (counter > 0) {
                            printer.printData(o.getFname() + " " + o.getLname() + "'s fine for " + counter + " car(s) is " + (usersFine * counter) + " euros.\n");
                        }
                    }
                    break;

            }

            //ask to continue!!
            Scanner input = new Scanner(System.in);
            System.out.println("\n\nPress any key to continue...");
            input.nextLine();
        }
    }
}
