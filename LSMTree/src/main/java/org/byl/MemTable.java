import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MemTable {
    private Map<String, String> data;
    private Map<String,String> backup;

    public MemTable() {
        data = new TreeMap<>();
        back
    }

    public void put(String key, String value) {
        data.put(key, value);
    }

    public String get(String key) {
        return data.get(key);
    }

    public void delete(String key) {
        data.remove(key);
    }
}
