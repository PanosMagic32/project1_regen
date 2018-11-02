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
    private static Printer printer;
    private static final String FUNCTIONALITY_REGEX = "[0-4]";
    private static final String EXPORT_TYPE_REGEX = "[1-2]";
    private static final String PLATE_REGEX = "[a-zA-Z]{3}-[0-9]{4}";
    private static final String FINE_REGEX = "[1-9]{1}[0-9]*";
    private static final String TIMEFRAME_REGEX = "[0-9]*";


    public static void main(String[] args) {

        String selectedFunctionality;
        String selectedExportType;

        while (true) {
            Menu.printMainMenu();
            selectedFunctionality = UserInputReader.userInput(FUNCTIONALITY_REGEX, "Select functionality: ", "Select functionality (eg. 1, 2, 3, 4 or 0): ");


            if (selectedFunctionality.equals("0")) System.exit(0);


            Menu.printExportTypeMenu();
            selectedExportType = UserInputReader.userInput(EXPORT_TYPE_REGEX, "Select export type: ", "Select export type (eg. 1 or 2): ");
            if (selectedExportType.equals("1")) {
                //output=file
                try {
                    printer = new Printer(new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.csv"))));
                } catch (FileNotFoundException e) {
                    new Team4Exception(e);
                }
            } else {
                //output=console
                printer = new Printer(new BufferedWriter(new OutputStreamWriter(System.out)));
            }

            DBtableGetter tables = new DBtableGetter();
            ArrayList<Owner> oList = tables.getOwnersIncludedVehicles();
            ArrayList<Vehicle> vList = new ArrayList<>();
            for (Owner o : oList) {
                vList.addAll(o.getVehicles());
            }

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            String now = dateFormat.format(c.getTime());

            switch (selectedFunctionality) {
                case "1"://status
                    String usersPlate = UserInputReader.userInput(PLATE_REGEX, "Give a plate number: ", "Give a plate number (ex: NHO-2233): ");

                    List<Vehicle> vehicleWithUsersPlate = vList.stream().filter((v) -> v.getPlate().equals(usersPlate)).collect(Collectors.toList());
                    if (!vehicleWithUsersPlate.isEmpty()) printer.printData(vehicleWithUsersPlate.get(0).toString());
                    else System.out.println("Plate not found.");
                    break;

                case "2"://forecoming time frame
                    int timeFrame = Integer.parseInt(UserInputReader.userInput(TIMEFRAME_REGEX, "Give a time frame (days): ", "Give a time frame (ex: 30): "));

                    try {
                        c.setTime(dateFormat.parse(now));
                    } catch (ParseException e) {
                        new Team4Exception(e);
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
                    //expiries
                    vList.sort(new VehicleComparator());
                    for (Vehicle v : vList) {
                        printer.printData(v.toString());
                    }
                    break;

                case "4":
                    //calculate fine
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
