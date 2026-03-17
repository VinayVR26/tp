package seedu.classmate.commands;

import seedu.classmate.Display;
import seedu.classmate.Major;
import seedu.classmate.SpecialisationOverview;


public class SpecialisationsCommand extends Command {

    @Override
    public void executeCommand(Major major, Display display, SpecialisationOverview specialisationOverview) {
        System.out.println("List of all CEG Specialisations:");
        SpecialisationOverview.listAllSpecialisations();
    }
}
