import java.util.Scanner;

public class UserInputReader {

    static String userInput(String regex, String introMessage, String wrongMessage) {
        Scanner input = new Scanner(System.in);
        String userTyped = "";

        System.out.print(introMessage);
        do {
            userTyped = input.nextLine();
            if (userTyped.matches(regex)) {
                userTyped = userTyped.toLowerCase();
                return userTyped;
            }
            System.out.print(wrongMessage);
        } while (true);
    }
}
