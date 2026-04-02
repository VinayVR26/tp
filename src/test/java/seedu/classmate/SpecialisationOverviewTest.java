package seedu.classmate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SpecialisationOverviewTest {

    private SpecialisationOverview specOverview;

    @BeforeEach
    void setUp() {
        HashMap<String, ArrayList<Module>> map = new HashMap<>();
        ArrayList<Module> modules = new ArrayList<>();
        modules.add(new Module("CS2113", "Software Engineering & OOP", 4));
        map.put("Robotics", modules);

        specOverview = new SpecialisationOverview(map);
    }

    @Test
    void getSpecialisationDetails_validIndex_returnsSpecialisation() {
        Specialisation spec = specOverview.getSpecialisationDetails(1);
        assertEquals("Robotics", spec.getSpecialisationName());
    }

    @Test
    void getSpecialisationDetails_zero_throwsException() {
        ClassMateException exception = assertThrows(
                ClassMateException.class, () -> specOverview.getSpecialisationDetails(0)
        );

        assertEquals("Invalid specialisation number. Please choose a number between 1 and 1",
                exception.getMessage());
    }

    @Test
    void getSpecialisationDetails_outOfRange_throwsException() {
        ClassMateException exception = assertThrows(
                ClassMateException.class,
                () -> specOverview.getSpecialisationDetails(2)
        );
        assertEquals("Invalid specialisation number. Please choose a number between 1 and 1",
                exception.getMessage());
    }
}
