package seedu.classmate;

import seedu.classmate.commands.ByeCommand;
import seedu.classmate.commands.Command;
import seedu.classmate.commands.HelpCommand;
import seedu.classmate.commands.PrereqCommand;
import seedu.classmate.commands.PrintModuleInfoCommand;
import seedu.classmate.commands.QueryModuleAvailabilityCommand;
import seedu.classmate.commands.SpecialisationInfoCommand;
import seedu.classmate.commands.ViewGradReqsCommand;
import seedu.classmate.commands.ViewSpecialisationsCommand;

public class CommandManager {

    public static Command createCommand(String commandWord, String arguments) {
        switch (commandWord) {
        case "help":
            return new HelpCommand();

        case "bye":
            return new ByeCommand();

        case "viewgradreqs":
            return new ViewGradReqsCommand();

        case "viewprereqs":
            return new PrereqCommand(arguments);

        case "printmoduleinfo":
            return new PrintModuleInfoCommand(arguments);

        case "querymoduleavailability":
            return new QueryModuleAvailabilityCommand(arguments);

        case "viewspecialisations":
            return new ViewSpecialisationsCommand();

        case "viewspecialisationinfo":
            return new SpecialisationInfoCommand(arguments);

        default:
            throw new ClassMateException("Unknown command. Enter 'help' for available commands.");
        }
    }
}
