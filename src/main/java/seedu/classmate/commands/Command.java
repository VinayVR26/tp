package seedu.classmate.commands;

import seedu.classmate.Display;
import seedu.classmate.Major;
import seedu.classmate.SpecialisationOverview;

/**
 * Represents a command that can be executed by the user.
 */
public abstract class Command {

    /**
     * Executes the command.
     *
     * @param major Major class.
     * @param display The UI handler.
     * @param specialisationOverview Overview of all specialisations.
     */
    public abstract void executeCommand(Major major, Display display, SpecialisationOverview specialisationOverview);

}
