package seedu.classmate;
import static org.junit.jupiter.api.Assertions.*;

import seedu.classmate.commands.RemoveSpecialisationCommand;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Unit tests for RemoveSpecialisationCommand.
 */
public class RemoveSpecialisationCommandTest {
    private static final String TEST_MODULES_FILE = "data/testModules.txt";
    private static final String TEST_SPECS_FILE = "data/testSpecs.txt";

    private Major major;
    private SpecialisationOverview specOverview;
    private Ui ui;
    private Storage storage;
    private UserProfile userProfile;

    @BeforeEach
    public void setUp() {
        // Initialise dummy curriculum data
        major = new Major(new ArrayList<>());
        specOverview = new SpecialisationOverview(new HashMap<>());
        ui = new Ui();

        // Initialise test storage and empty profile
        storage = new Storage(TEST_MODULES_FILE, TEST_SPECS_FILE);
        userProfile = new UserProfile(new ArrayList<>(), new ArrayList<>());
    }

    @AfterEach
    void cleanup() {
        // Delete test files after each run
        new File(TEST_MODULES_FILE).delete();
        new File(TEST_SPECS_FILE).delete();
    }

    @Test
    void execute_validSpecialisation_removesSuccessfully() throws ClassMateException {
        // Add a specialisation first
        userProfile.addSpecialisation("Robotics");
        assertEquals(1, userProfile.getUserSpecialisations().size());

        // Run the remove command
        RemoveSpecialisationCommand cmd = new RemoveSpecialisationCommand("Robotics", userProfile, storage);
        assertDoesNotThrow(() -> cmd.executeCommand(major, ui, specOverview));

        // Since there was only one spec, removing the spec should make list empty
        assertTrue(userProfile.getUserSpecialisations().isEmpty());
    }

    @Test
    void execute_caseInsensitive_removesSuccessfully() throws ClassMateException {
        // Add specialisation with one capital letter
        userProfile.addSpecialisation("Robotics");

        // Try to remove with all lowercase
        RemoveSpecialisationCommand cmd = new RemoveSpecialisationCommand("robotics", userProfile, storage);
        assertDoesNotThrow(() -> cmd.executeCommand(major, ui, specOverview));

        // Specialisation should still be identified despite casing, and removed
        assertTrue(userProfile.getUserSpecialisations().isEmpty());
    }

    @Test
    void execute_specialisationNotFound_throwsException() throws ClassMateException {
        // Add a specialisation first
        userProfile.addSpecialisation("Robotics");

        // Remove a different specialisation from the one added
        RemoveSpecialisationCommand cmd = new RemoveSpecialisationCommand("Space Technology", userProfile, storage);

        // Throw exception because spec to be removed isn't in user profile
        ClassMateException exception = assertThrows(ClassMateException.class,
                () -> cmd.executeCommand(major, ui, specOverview));

        assertEquals("Specialisation 'Space Technology' not found in your profile.", exception.getMessage());

        // Check that user's spec is not removed by accident
        assertEquals(1, userProfile.getUserSpecialisations().size());
        assertTrue(userProfile.getUserSpecialisations().contains("Robotics"));
    }

    @Test
    void execute_emptyProfile_throwsException() {
        // Profile has no specialisations
        RemoveSpecialisationCommand cmd = new RemoveSpecialisationCommand("Robotics", userProfile, storage);

        // Then removing a spec when there's no spec should throw an exception
        ClassMateException exception = assertThrows(ClassMateException.class,
                () -> cmd.executeCommand(major, ui, specOverview));

        assertEquals("You haven't selected any specialisations to remove.", exception.getMessage());
    }

    @Test
    void execute_emptyInput_throwsException() {
        RemoveSpecialisationCommand cmd = new RemoveSpecialisationCommand("", userProfile, storage);

        ClassMateException exception = assertThrows(ClassMateException.class,
                () -> cmd.executeCommand(major, ui, specOverview));

        assertEquals("Please provide a specialisation name. Format: removespecialisation <NAME>", exception.getMessage());
    }
}
