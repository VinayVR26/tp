package seedu.classmate.commands;

import seedu.classmate.ClassMateException;
import seedu.classmate.Display;
import seedu.classmate.Major;
import seedu.classmate.Specialisation;
import seedu.classmate.SpecialisationOverview;

public class SpecialisationInfoCommand extends Command {

    private final String args;

    public SpecialisationInfoCommand(String args) {
        this.args = args.trim();
    }

    @Override
    public void executeCommand(Major major, Display display, SpecialisationOverview specialisationOverview) {

        if (args.isEmpty()) {
            throw new ClassMateException("Please provide a specialisation number:" +
                    " specialisation <index>");
        }

        try {
            int index = Integer.parseInt(args);

            Specialisation spec = specialisationOverview.getSpecialisationDetails(index);
            specialisationOverview.displaySpecialisationDetails(spec);

        } catch (NumberFormatException e) {
            throw new ClassMateException("Specialisation index must be a number.");
        }
    }
}
