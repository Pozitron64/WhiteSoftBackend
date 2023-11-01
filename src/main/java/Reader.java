import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Reader {
    public static void writeRecordsFromFileToMap(String filePath, Map<Integer, Record> records) {
        try{
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
        }catch (IOException e) {
            System.out.println("Error read file");
            System.exit(0);
        }
    }
}
