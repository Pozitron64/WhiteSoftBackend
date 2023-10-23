import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String FILEPATH = "src/main/resources/data.json";

    public static void main(String[] args) {
        Map<Integer, Record> records = new HashMap<>();

        try {
            LinkHandler.writeRecordsFromFileToMap(FILEPATH, records);
        } catch (IOException e) {
            System.out.println("Error read file");
            return;
        }

        while (true) {
            LinkHandler.printMenu();
            int number = scanner.nextInt();
            scanner.nextLine();

            switch (number) {
                case 1:
                    System.out.print("Write id - ");
                    int inputInt = scanner.nextInt();
                    String data = LinkHandler.searchRecords(records, inputInt);
                    System.out.println(data);
                    break;
                case 2:
                    System.out.print("Write name - ");
                    String inputString = scanner.nextLine();
                    data = LinkHandler.searchRecords(records, inputString);
                    System.out.println(data);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Wrong choice, please try again");
                    break;
            }
        }
    }
}