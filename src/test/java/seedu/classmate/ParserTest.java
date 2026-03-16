package seedu.classmate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Contains unit tests for the Parser class.
 * Tests whether user input is correctly parsed into Command objects,
 * such as valid commands and invalid or empty inputs.
 */
class ParserTest {

    @Test
    public void testHelpCommand() {
        String result = Parser.parseCommand("help");

        assertEquals("Viewing help", result);
    }

    @Test
    public void testEmptyCommand() {
        Exception exception = assertThrows(ClassMateException.class, () -> Parser.parseCommand(""));
        assertEquals("Please enter a non-empty input!", exception.getMessage());
    }
}
