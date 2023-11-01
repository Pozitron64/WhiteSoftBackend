import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class LinkHandler {
    public static void printMenu() {
        String expectedOutput = "Выберите вариант из меню:\n" +
                "1 - найти записи по id\n" +
                "2 - найти записи по имени\n" +
                "3 - закрыть программу\n";
        System.out.println(expectedOutput);
    }

    public static void writeRecordsFromFileToMap(String filePath, Map<Integer, Record> records) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new File(filePath));
        for (JsonNode recordNode : jsonNode) {
            int id = recordNode.get("id").asInt();
            String name = recordNode.get("name").asText();
            String description = recordNode.get("description").asText();
            String link = recordNode.get("link").asText();
            Record record = new Record(id, name, description, link);
            records.put(id, record);
        }
    }

    public static String searchRecords(Map<Integer, Record> mapRecords, Object input) {
        String returnLink = "";
        if (input instanceof Integer) {
            Record record = mapRecords.get((Integer) input);
            if (record != null) {
                return "id - " + record.getId() + "\n" +
                        "name - " + record.getName() + "\n" +
                        "description - " + record.getDescription() + "\n" +
                        "link - " + record.getLink() + "\n";
            }
        } else if (input instanceof String) {
            for (Record record : mapRecords.values()) {
                if (record.getName().contains((String) input)) {
                    returnLink += "id - " + record.getId() + "\n" +
                            "name - " + record.getName() + "\n" +
                            "description - " + record.getDescription() + "\n" +
                            "link - " + record.getLink() + "\n";
                }
            }
            if (returnLink != "")
                return returnLink;
        }
        return "Link not found.\n";
    }
}
