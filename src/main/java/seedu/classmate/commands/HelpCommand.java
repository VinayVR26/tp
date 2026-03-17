package seedu.classmate.commands;

import seedu.classmate.Display;
import seedu.classmate.Major;
import seedu.classmate.Parser;
import seedu.classmate.SpecialisationOverview;

/**
 * Displays the help message containing all commands to the user.
 */
public class HelpCommand extends Command {

    @Override
    public void executeCommand(Major major, Display display, SpecialisationOverview specialisationOverview) {
        Parser.displayHelp();
    }
}
