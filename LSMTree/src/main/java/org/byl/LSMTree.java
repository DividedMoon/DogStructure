import java.io.File;

public class LSMTree {

    private MemTable memTable;
    private DiskStorage diskStorage;

    public void put(String key, String value) {
        memTable.put(key, value);
        if (memTable.isFull()) {
            diskStorage.flush(memTable);
            memTable = new MemTable();
        }
    }

    public String get(String key) {
        String value = memTable.get(key);
        if (value != null) {
            return value;
        }
        return diskStorage.get(key);
    }

    public void delete(String key) {
        memTable.delete(key);
        diskStorage.delete(key);
    }

    public LSMTree(File dir) {
        memTable = new MemTable();
        diskStorage = new DiskStorage(dir);
    }
}
