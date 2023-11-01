import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SearcherLinkByName implements Command {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public int getIdentificationNumber() {
        return 2;
    }

    @Override
    public String getDescription() {
        return "найти записи по имени\n";
    }

    public void runCommand(Map<Integer, Record> mapRecords) {
        System.out.print("Введите имя - ");
        String input = scanner.nextLine();
        List<Record> foundRecordsList = searchRecordByName(mapRecords, input);
        if (!foundRecordsList.isEmpty()) {
            for (Record record : foundRecordsList){
                System.out.println(record.toString());
            }
        }else {
            System.out.println("Данное имя не найдено\n");
        }
    }
    public List<Record> searchRecordByName(Map<Integer, Record> mapRecords, String name){
        List<Record> foundRecordsList = new ArrayList<>();
        for (Record record : mapRecords.values()) {
            if (record.getName().contains((String) name)) {
                foundRecordsList.add(record);
            }
        }
        return foundRecordsList;
    }

    @Override
    public String toString() {
        return getIdentificationNumber() + " - " + getDescription();
    }
}
