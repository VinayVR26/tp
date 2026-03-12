package seedu.classmate;

public class Parser {

    public static Command parse(String input) {

        String trimmed = input.trim();

        if (trimmed.isEmpty()) {
            throw new ClassMateException("Please enter a non-empty input!");
        }

        if (trimmed.equals("view grad req")) {
            return new Command("viewGradReq", "");
        }

        String[] parts = trimmed.split("\\s+", 2);

        String commandWord = parts[0].toLowerCase();
        String args = parts.length > 1 ? parts[1] : "";

        return new Command(commandWord, args);
    }
}
