import java.util.Map;

public interface Command {
    public int getIdentificationNumber();

    public String getDescription();

    public void runCommand(Map<Integer, Record> mapRecords);
}
