import java.io.File;

public class DiskStorage {
    private File dir;

    public DiskStorage(File dir) {
        this.dir = dir;
    }

    public void flush(MemTable memTable) {
        // method to flush the data from the MemTable to an SSTable
    }

    public String get(String key) {
        // method to retrieve value for a given key from the SSTables
        return null;
    }

    public void delete(String key) {
        // method to delete a key-value pair from the SSTables
    }
}
