package seedu.classmate;

import java.util.ArrayList;

public class Module {
    private String moduleCode;
    private String moduleName;
    private ArrayList<String> prerequisites;

    public Module(String moduleCode, String moduleName) {
        // Add guard clause against empty details
        if (moduleCode.trim().isEmpty() || moduleName.trim().isEmpty()) {
            throw new ClassMateException("Module details cannot be empty.");
        }

        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.prerequisites = new ArrayList<>();
    }

    public void addPrerequisite(String prereqCode) {
        // Add guard clause against duplicate prerequisite entry: See ModuleTest class
        boolean isDuplicate = prerequisites.contains(prereqCode);
        if (!isDuplicate) {
            this.prerequisites.add(prereqCode);
        }
    }

    @Override
    public String toString() {
        return moduleCode + " " + moduleName;
    }

    public String toStringPrerequisites() {
        if (prerequisites.isEmpty()) {
            return moduleCode + " has no prerequisites.";
        }
        return "Prerequisites for " + moduleCode +
                ": " + String.join(", ", prerequisites);
    }

    public ArrayList<String> getPrerequisites() {
        return prerequisites;
    }
}
