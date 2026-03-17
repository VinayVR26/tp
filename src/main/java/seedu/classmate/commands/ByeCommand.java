package seedu.classmate.commands;

import seedu.classmate.Display;
import seedu.classmate.Major;
import seedu.classmate.SpecialisationOverview;

/**
 * Terminated the program after displaying goodbye message.
 */
public class ByeCommand extends Command {

    @Override
    public void executeCommand(Major major, Display display, SpecialisationOverview specialisationOverview) {
        display.showGoodbye();
    }
}
