package seedu.classmate;

import java.util.ArrayList;

public class SpecialisationOverview {
    private ArrayList<Specialisation> specs;

    public SpecialisationOverview() {
        specs = new ArrayList<>();
        specs.add(new Specialisation("Internet of Things"));
        specs.add(new Specialisation("Advanced Electronics"));
        specs.add(new Specialisation("Space Technology"));
        specs.add(new Specialisation("Industry 4.0"));
        specs.add(new Specialisation("Robotics"));
    }

    public void listAllSpecialisations() {
        for (int specialisationIndex = 0; specialisationIndex < specs.size(); specialisationIndex++) {
            System.out.println((specialisationIndex + 1) + ". " + specs.get(specialisationIndex).getSpecialisationName());
        }
        System.out.println("Enter <view specialisationNumber> to preview specialisation information.");
    }

    public void displaySpecialisationDetails(Specialisation selectedSpecialisation) {
        System.out.println("Specialisation: " + selectedSpecialisation.getSpecialisationName());

        System.out.println("Core Modules:");
        for (Module coreModule : selectedSpecialisation.getSpecialisationCoreModules()) {
            System.out.println(coreModule.getModuleCode() + " : " + coreModule.getModuleName());
        }

        System.out.println();

        System.out.println("Elective Modules:");
        for (Module electiveModule : selectedSpecialisation.getSpecialisationElectiveModules()) {
            System.out.println(electiveModule.getModuleCode() + " : " + electiveModule.getModuleName());
        }
    }

    public Specialisation getSpecialisationDetails(int specialisationNumber) {
        if (specialisationNumber < 0 || specialisationNumber >= specs.size()) {
            throw new ClassMateException("Invalid specialisation number. Please choose a number between 1 and " + specs.size());
        }
        return specs.get(specialisationNumber - 1);
    }

}
