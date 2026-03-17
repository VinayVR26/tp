package seedu.classmate.commands;

import seedu.classmate.ClassMateException;
import seedu.classmate.Display;
import seedu.classmate.Major;
import seedu.classmate.Module;
import seedu.classmate.SpecialisationOverview;

public class PrereqCommand extends Command{

    private final String moduleCode;

    public PrereqCommand(String args) {
        this.moduleCode = args.trim();
    }

    @Override
    public void executeCommand(Major major, Display display, SpecialisationOverview specialisationOverview) {
        if (moduleCode.isEmpty()) {
            throw new ClassMateException("Please provide a module code: prereq <module code>");
        }

        Module module = major.findModule(moduleCode);

        if (module == null) {
            System.out.println("Module " + moduleCode + " not found.");
        }

        assert module != null;
        System.out.println(module.printPrereqTree(major));
    }
}
