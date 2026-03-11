package seedu.classmate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class ModuleTest {

    @Test
    void addPrerequisite_duplicateInput_noChange() {
        Module module = new Module("CG1111A", "Engineering Principles and Practice I");
        module.addPrerequisite("CS1010");
        module.addPrerequisite("CS1010"); // Duplicate code

        /*
         * Since prerequisites are stored as an ArrayList<String>,
         * Size of the ArrayList will increment without detecting duplicate entry
         */
        assertEquals(1, module.getPrerequisites().size(), "Prerequisite module should not be duplicated.");
    }

    @Test
    void module_nullName_throwsException() {
        /*
         * Throw custom exception for null string input
         */
        ClassMateException e = assertThrows(ClassMateException.class, () -> {
            new Module("", "");
        });

        assertEquals("Module details cannot be empty.", e.getMessage());
    }
}
