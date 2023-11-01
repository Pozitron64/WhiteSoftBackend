import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private SearcherLinkById searcherLinkById = new SearcherLinkById();
    private SearcherLinkByName searcherLinkByName = new SearcherLinkByName();
    private CloseProgram closeProgram = new CloseProgram();
    private Map<Integer, Record> records = new HashMap<>();
    private String filePath;

    public Menu(String filePath) {
        Reader.writeRecordsFromFileToMap(filePath, records);
        this.filePath = filePath;
    }

    public void start(int number) {
        if (searcherLinkById.getIdentificationNumber() == number) {
            searcherLinkById.runCommand(records);
        } else if (searcherLinkByName.getIdentificationNumber() == number) {
            searcherLinkByName.runCommand(records);
        } else if (closeProgram.getIdentificationNumber() == number) {
            closeProgram.runCommand(records);
        } else {
            System.out.println("Команда под таким номером отсутствует");
        }
    }

    public void printMenu() {
        String expectedOutput = "Выберите вариант из меню:\n" +
                searcherLinkById.toString() +
                searcherLinkByName.toString() +
                closeProgram.toString();
        System.out.println(expectedOutput);
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
