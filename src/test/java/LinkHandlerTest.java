import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkHandlerTest {
    @Test
    void testSearchRecordsById() {
        Map<Integer, Record> records = new HashMap<>();
        records.put(1, new Record(1, "Arthur", "Low", "Inst"));
        String result = LinkHandler.searchRecords(records, 1);
        String expected = "id - 1\n" +
                "name - Arthur\n" +
                "description - Low\n" +
                "link - Inst\n";
        assertEquals(expected, result);
    }

    @Test
    void testSearchRecordsByName() {
        Map<Integer, Record> records = new HashMap<>();
        records.put(1, new Record(1, "Arthur", "Low", "Inst"));
        String result = LinkHandler.searchRecords(records, "thu");
        String expected = "id - 1\n" +
                "name - Arthur\n" +
                "description - Low\n" +
                "link - Inst\n";
        assertEquals(expected, result);
    }

    @Test
    public void testLoadRecordsFromFile() throws IOException {
        Map<Integer, Record> records = new HashMap<>();
        String filePath = "src/test/resources/testData.json";
        LinkHandler.writeRecordsFromFileToMap(filePath, records);
        assertEquals(records.size(), 2);
        System.out.println(records);
    }
}
