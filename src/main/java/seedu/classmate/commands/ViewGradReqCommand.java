package seedu.classmate.commands;

import seedu.classmate.Display;
import seedu.classmate.Major;
import seedu.classmate.SpecialisationOverview;

/**
 * Prints the CEG graduation requirements.
 */
public class ViewGradReqCommand extends Command{

    @Override
    public void executeCommand(Major major, Display display, SpecialisationOverview specialisationOverview) {
        System.out.println(major);
    }
}
