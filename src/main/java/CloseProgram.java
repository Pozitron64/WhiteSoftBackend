import java.util.Map;

public class CloseProgram implements Command {

    @Override
    public int getIdentificationNumber() {
        return 3;
    }

    @Override
    public String getDescription() {
        return "закрыть программу\n";
    }

    @Override
    public void runCommand(Map<Integer, Record> mapRecords) {
        System.exit(0);
    }

    @Override
    public String toString() {
        return getIdentificationNumber() + " - " + getDescription();
    }
}
