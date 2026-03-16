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
        System.out.print("List of all CEG Specialisations:");
        for (int specialisationIndex = 0; specialisationIndex < specs.size(); specialisationIndex++) {
            System.out.println((specialisationIndex + 1) + ". " + specs.get(specialisationIndex).specialisationName);
        }
        System.out.println("Enter <view specialisationNumber> to preview specialisation information.");
    }

    public Specialisation getSpecialisationDetails(int specialisationNumber) {
        if (specialisationNumber < 0 || specialisationNumber >= specs.size()) {
            throw new ClassMateException("Invalid specialisation number. Please choose a number between 1 and " + specs.size());
        }
        return specs.get(specialisationNumber - 1);
    }

}
