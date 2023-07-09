package theKazantsev.RESTfulCalculator.json;

public class addJSON {

    private long id;
    private int result;

    public addJSON(long id, int param1, int param2) {
        this.id = id;
        result = param1 + param2;
    }

    public int getResult() {
        return result;
    }

    public long getId() {
        return id;
    }
}
