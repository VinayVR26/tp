package seedu.classmate;

import seedu.classmate.commands.ByeCommand;
import seedu.classmate.commands.Command;
import seedu.classmate.commands.HelpCommand;
import seedu.classmate.commands.PrereqCommand;
import seedu.classmate.commands.PrintModuleInfoCommand;
import seedu.classmate.commands.QueryModuleAvailabilityCommand;
import seedu.classmate.commands.SpecialisationInfoCommand;
import seedu.classmate.commands.SpecialisationsCommand;
import seedu.classmate.commands.ViewGradReqCommand;

/**
 * Parses user input commands and returns the corresponding command description.
 * Maintains a mapping of valid commands to their descriptions.
 * The {@code parseCommand(String input)} method processes user input,
 * validates it, and checks whether it matches any known command.
 * If a valid command is found, the associated description is returned, else
 * return 'Unknown Message'.
 */
public class Parser {

    /**
     * Parses the user's input and determines whether it matches a valid command.
     *
     * @param input The raw command string entered by the user.
     * @return The description associated with the command if it exists,
     *         or a message associated with the command if it exists.
     * @throws ClassMateException If the input provided is empty after trimming.
     */
    public static Command parse(String input) {

        String trimmed = input.trim();

        if (trimmed.isEmpty()) {
            throw new ClassMateException("Please enter a non-empty input!");
        }

        String[] arguments = trimmed.split("\\s+", 2);
        String commandWord = arguments[0];
        String args = arguments.length > 1 ? arguments[1] : "";

        switch (commandWord) {
        case "help":
            return new HelpCommand();

        case "bye":
            return new ByeCommand();

        case "viewGradReqs":
            return new ViewGradReqCommand();

        case "viewPrereqs":
            return new PrereqCommand(args);

        case "printModuleInfo":
            return new PrintModuleInfoCommand(args);

        case "queryModuleAvailability":
            return new QueryModuleAvailabilityCommand(args);

        case "viewSpecialisations":
            return new SpecialisationsCommand();

        case "viewSpecialisationInfo":
            return new SpecialisationInfoCommand(args);

        default:
            throw new ClassMateException("Unknown command. Enter 'help' for available commands.");
        }
    }

    /**
     * Prints the list of ClassMate commands and their descriptions
     * to help users on how to use the application
     */
    public static void displayHelp() {
        System.out.println("Available commands:\n" +
                "- help: " +
                "Viewing help\n" +
                "- viewGradReqs: " +
                "Print CEG graduation requirements\n" +
                "- viewModuleInfo MODULE_CODE: " +
                "Show details for a specific module\n" +
                "- queryModuleAvailability MODULE_CODE SEM<1/2>: " +
                "Check if a module MODULE_CODE is available in a certain semester SEM<1/2>\n" +
                "- viewSpecialisations: " +
                "View list of all CEG specialisations\n" +
                "- viewSpecialisationInfo SPECIALISATION_INDEX: " +
                "View specific requirements for a specialisation. See viewSpecialisation for index");

    }
}

