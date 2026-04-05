package seedu.classmate.commands;

import seedu.classmate.Major;
import seedu.classmate.Module;
import seedu.classmate.Specialisation;
import seedu.classmate.SpecialisationOverview;
import seedu.classmate.Ui;
import seedu.classmate.UserProfile;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Represents a command that displays the user's academic profile.
 * This includes their selected specialization and a list of completed modules.
 */
public class CheckProfileCommand extends Command {

    // @@author Michael-coding06
    private static final Logger logger = Logger.getLogger(CheckProfileCommand.class.getName());
    private final UserProfile userProfile;

    /**
     * Constructs a {@code CheckProfileCommand} with the user's profile.
     *
     * @param userProfile The UserProfile object holding the state of academic progress.
     */
    public CheckProfileCommand(UserProfile userProfile) {
        assert userProfile != null : "UserProfile should not be null";
        this.userProfile = userProfile;
    }

    /**
     * Executes the command by printing the user's specialization and completed modules.
     *
     * @param major                   The Major instance (unused).
     * @param ui                      The Ui handler.
     * @param specialisationOverview  The overview of specialisations (unused).
     */
    @Override
    public void executeCommand(Major major, Ui ui, SpecialisationOverview specialisationOverview) {
        logger.info("Executing CheckProfileCommand");
    // @@author

        // @@author lauwn-mower
        /*
         * Review CheckProfile command:
         * command to additionally show a list of uncompleted modules.
         * implementation: import CEG module list from major.getCoreModules()
         *                 create new ArrayList of incomplete modules
         *                  create a progress tracker via Ui
         *                  pass in userprofile, remaining major and remaining spec modules
         *                  for spec elective modules, tell user how many completed
         *                      and show options as to what else they can do
         */

        // settle completed major modules first
        ArrayList<String> completedModules = userProfile.getUserCompletedModules();

        // calculate remaining modules
        ArrayList<Module> remainingMajorModules = new ArrayList<>();
        for (seedu.classmate.Module m : major.getCoreModules()) {
            if (!completedModules.contains(m.getModuleCode())) {
                remainingMajorModules.add(m);
            }
        }

        ui.showBasicProfile(completedModules, remainingMajorModules);

        // settle spec modules
        // first check if spec is empty
        // else, show specs and modules yet to complete
        ArrayList<String> userSpecialisations = userProfile.getUserSpecialisations();

        if (userSpecialisations.isEmpty()) {
            System.out.println("No specialisations selected yet.");
            Ui.printLine();
            return;
        }

        for (String specName : userSpecialisations) {
            // Find the actual Specialisation object based on the user's saved string
            Specialisation spec = specialisationOverview.getSpecialisationByName(specName);

            if (spec != null) {
                calculateAndShowSpecProgress(spec, completedModules, ui);
            } else {
                logger.warning("Could not find specialisation data for: " + specName);
            }
        }

        System.out.println("Keep up the great work!");
        Ui.printLine();
    }

    /**
     * Helper method to calculate the progress for a specific specialisation.
     */
    private void calculateAndShowSpecProgress(Specialisation spec, ArrayList<String> completedCodes, Ui ui) {
        // Calculate remaining Core modules
        ArrayList<Module> remainingSpecCore = new ArrayList<>();
        for (Module m : spec.getSpecialisationCoreModules()) {
            if (!completedCodes.contains(m.getModuleCode())) {
                remainingSpecCore.add(m);
            }
        }

        // Calculate Electives by counting no. of completed mods and listing remaining mods
        ArrayList<Module> remainingElectives = new ArrayList<>();
        int completedElectivesCount = 0;

        for (Module m : spec.getSpecialisationElectiveModules()) {
            if (completedCodes.contains(m.getModuleCode())) {
                completedElectivesCount++;
            } else {
                remainingElectives.add(m);
            }
        }

        // Pass calculated data to Ui to format and print
        ui.showSpecialisationProgress(spec, remainingSpecCore, remainingElectives, completedElectivesCount);
    }

    // @@author
}
