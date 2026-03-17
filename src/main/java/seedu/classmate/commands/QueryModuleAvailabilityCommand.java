package seedu.classmate.commands;

import seedu.classmate.ClassMateException;
import seedu.classmate.Display;
import seedu.classmate.Major;
import seedu.classmate.Module;
import seedu.classmate.SpecialisationOverview;

public class QueryModuleAvailabilityCommand extends Command {

    private final String moduleCode;
    private final String semester;

    public QueryModuleAvailabilityCommand(String args) {

        String[] parts = args.trim().split("\\s+");

        if (parts.length < 2) {
            throw new ClassMateException("Format: queryModuleAvailability <module code> <sem1/sem2>");
        }

        this.moduleCode = parts[0].toUpperCase();
        this.semester = parts[1].toLowerCase();
    }

    @Override
    public void executeCommand(Major major, Display display, SpecialisationOverview specialisationOverview) {

        Module module = major.findModule(moduleCode);

        if (module == null) {
            throw new ClassMateException("Module not found: " + moduleCode);
        }

        String result = module.checkAvailability(semester);
        System.out.println(result);
    }
}
