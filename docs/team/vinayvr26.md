# VinayVR26's Project Portfolio Page

## Project: ClassMate

ClassMate is an academic assistance application to help CEG students make their university journey easier. 
The user interacts with it using a CLI. It is written in Java.

### These are my contributions to the project.

#### Features

* **New Feature: `ModulesLoader`**:
   * What it does: On application startup, two text files - `core-modules.txt` and `specialisation-modules.txt`,
     containing module and specialisation information, are loaded into the application to answer user's 
     requests. 
   * Justification: This feature externalises module and specialisation information, adhering to the principle of
     Separation of Concerns. By decoupling data from the code, the application avoids having many hard-coded
     lines, improving maintainability.

* **New Feature: `viewSpecialisations`**:
   * What it does: Displays all the specialisations available as a numbered list and tells the user to use 
     the `viewSpecialisationInfo` command to know more about a specialisation.
   * Justification: Enhances user experience by providing an intuitive way to explore the CEG specialisations. It
     eliminates the need for users to memorise specific specialisation names, reducing the cognitive load when doing
     academic planning.

* **New Feature: `viewSpecialisationInfo`**:
   * What it does: Displays details about each specialisation - the description, list of core and elective modules 
     and the requirements to fulfill the specialisation.
   * Justification: Provides a clear overview of what the specialisation is about and the requirements. This facilitates
     informed decision-making and long-term academic timeline optimisation.

* **New Feature**: Case-insensitive command execution, by adding logic in `Parser`:
   * What it does: Automatically converts user input to lower case allowing the application to recognise the command
     and the arguments (if any). This allows the application to recognise commands and arguments that have mixed 
     capitalisation like `vIeWpReReQs cS2113`.
   * Justification: Increases the robustness of the application. By eliminating case-sensitivity, the application
     significantly reduces user friction. In a typing-intensive interface, strict casing requirements induce
     much cognitive load in the user, leading to command failures. By removing these constraints, the user experience
     is more seamless.

* **Bugs Fixed (v1.0 and 2.0)**:
    * Added fallback logic to `QueryModuleAvailabilityCommand` and `CheckPrereqStatusCommand` classes to ensure
      that modules belonging only to the `Specialisation` class are correctly identified by the application, preventing
      false `Module not found` errors, which were happening because the module code was only checked against the major
      requirements and if not a major requirement, the error message would be thrown.
    * Resolved data visibility issue where modules that were prerequisites for specialisation modules were unreachable
      via the commands. Hence, I added all the details (such as module name, code, units and semester availability) in 
      `specialisation.txt`, which helps in academic planning.

* **Bugs Fixed (v2.1: After PE Dry Run)**:
   * Fixed error where 6 specialisations were displayed in the application, when there are only 5 specialisations.
   * Converted `viewPreReqs` sequence diagram that was made from raw text to a plantUML diagram, 
     to standardise it with the other UML diagrams in the DG and also to show more logic details.

* **Code contributed:** [RepoSense link](https://nus-cs2113-ay2526-s2.github.io/tp-dashboard/?search=vinayvr26)

* **Documentation:**
   * **User Guide:** 
     * Wrote documentation for the feature `help` 
     * Added more important information for the feature `viewSpecialisations`, to make it clearer
   * **Developer Guide:**
     * Wrote documentation for the features `viewSpecialisations` and `viewSpecialisationInfo`
     * Created Sequence Diagrams for `viewSpecialisations` and `viewSpecialisationInfo` commands

* **Contributions to team tasks:**
   * Maintained Continuous Integration/Deployment (CI/CD) by refactoring existing test cases to ensure compatibility 
     with the `ModulesLoader` system.
   * Made JavaDoc comments clearer for methods that were authored by my teammates.
   * Suggested the shift from hard-coded data to an external storage system (`ModulesLoader`), eliminating inefficient
     instantiation of module information, improving maintainability and adhering to coding standards.
   * Modified other classes - `ClassMate`, `Major`, `Module` to incorporate the `ModulesLoader` architecture of 
     automated loading of module information.
   * Fixed checkstyle errors (such as removing wildcard imports).
   * Fixed bugs in all versions (v1.0, v2.0, v2.1) and those reported during PE Dry Run.
