import java.util.Map;
import java.util.Scanner;

public class SearcherLinkById implements Command {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public int getIdentificationNumber() {
        return 1;
    }

    @Override
    public String getDescription() {
        return "найти записи по id\n";
    }

    @Override
    public void runCommand(Map<Integer, Record> mapRecords) {
        System.out.print("Введите id - ");
        Integer input;
        try{
            input = Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException exception){
            input = -1;
        }
        Record record = mapRecords.get(input);
        if (record != null) {
            System.out.println(record.toString());
        } else {
            System.out.println("Запись под таким номером не найдена\n");
        }
    }

    @Override
    public String toString() {
        return getIdentificationNumber() + " - " + getDescription();
    }

}
