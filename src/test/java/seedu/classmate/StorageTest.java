package seedu.classmate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Contains unit tests for the Storage class.
 */
public class StorageTest {
    private static final String TEST_FILE = "data/testModules.txt";
    private final Storage storage = new Storage(TEST_FILE);

    @AfterEach
    void cleanup() {
        File file = new File(TEST_FILE);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testSaveAndLoadModules() {

        ArrayList<String> modules = new ArrayList<>();
        modules.add("CS2113");
        modules.add("CG2023");

        storage.save(modules);

        ArrayList<String> loadedModules = storage.load();

        assertEquals(2, loadedModules.size());
        assertTrue(loadedModules.contains("CS2113"));
        assertTrue(loadedModules.contains("CG2023"));
    }

    @Test
    void testReturnEmptyListWhenFileNotExists() {

        ArrayList<String> loadedModules = storage.load();

        assertTrue(loadedModules.isEmpty());
    }

    @Test
    void testSaveEmptyListCreatesEmptyFile() {

        ArrayList<String> modules = new ArrayList<>();
        storage.save(modules);
        ArrayList<String> loadedModules = storage.load();
        assertEquals(0, loadedModules.size());
    }

}
