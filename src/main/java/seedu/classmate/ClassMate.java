package seedu.classmate;

import java.util.Scanner;

public class ClassMate {
    /**
     * Main entry-point for the java.classmate.Classmate application.
     */
    public static void main(String[] args) {
        String logo = "  ____ _               __  __       _\n"
                + " / ___| | __ _ ___ ___|  \\/  | __ _| |_ ___\n"
                + "| |   | |/ _` / __/ __| |\\/| |/ _` | __/ _ \\\n"
                + "| |___| | (_| \\__ \\__ \\ |  | | (_| | ||  __/\n"
                + " \\____|_|\\__,_|___/___/_|  |_|\\__,_|\\__\\___|\n";
        System.out.println("Welcome to\n" + logo);
        System.out.println("I'm your CEG course planning assistant!");
        System.out.println("Type 'help' to see available commands.");
        Scanner in = new Scanner(System.in);
        Major major = new Major();
        while (true) {
            String input = in.nextLine();
            try {
                Command command = Parser.parse(input);
                switch (command.getCommandWord()) {
                case "help":
                    printHelp();
                    break;
                case "bye":
                    goodbyeMessage();
                    return;
                case "viewGradReq":
                    System.out.println(major);
                    break;
                case "prereq":
                    String moduleCode = command.getArgs();
                    Module module = major.findModule(moduleCode);
                    System.out.println(module.printPrereqTree(major));
                    break;
                case "printmoduleinfo":
                    String[] moduleCodes = command.getArgs().split("\\s+");
                    System.out.println("Module Info for " + command.getArgs());
                    for (String code : moduleCodes) {
                        Module m = major.findModule(code.trim());
                        if (m != null) {
                            System.out.println(m.printInfo());
                        } else {
                            System.out.println("Module " + code + " not found.");
                        }
                    }
                    break;
                case "specialisations":
                    System.out.println("Listing all specifications:");
                    break;
                case "specialisation":
                    String specialisationName = command.getArgs();
                    System.out.println("Listing details for " + specialisationName);
                    Specialisation spec = new Specialisation(specialisationName);
                    break;
                default:
                    throw new ClassMateException("Unknown command.");
                }
            } catch (ClassMateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Prints the list of ClassMate commands and their descriptions
     * to help users on how to use the application
     */
    private static void printHelp() {
        System.out.println("List of commands:");
        System.out.println("Command: view grad req");
        System.out.println("- Print CEG graduation requirements");
        System.out.println("Command: prereq <module code>");
        System.out.println("- Show prerequisites for a module");
        System.out.println("Command: printModuleInfo <module code(s)>");
        System.out.println("- Show information for one or more modules");
        System.out.println("Command: specialisations");
        System.out.println("- List all CEG specialisations");
        System.out.println("Command: specialisation <name>");
        System.out.println("- Show detailed info for a specialisation");
        System.out.println("Command: bye");
        System.out.println("- Exit ClassMate");
    }

    private static void goodbyeMessage() {
        System.out.println("Goodbye! Happy course planning!");
    }
}
