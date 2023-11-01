import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final String FILEPATH = "src/main/resources/data.json";
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Menu menu = new Menu(FILEPATH);

        while (true) {
            menu.printMenu();
            Integer number;
            try{
                number = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException exception){
                number = -1;
            }
            menu.start(number);
        }
    }
}