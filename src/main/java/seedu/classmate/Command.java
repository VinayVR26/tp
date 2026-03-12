package seedu.classmate;

public class Command {

    private String commandWord;
    private String args;

    public Command(String commandWord, String args) {
        this.commandWord = commandWord;
        this.args = args;
    }

    public String getCommandWord() {
        return commandWord;
    }

    public String getArgs() {
        return args;
    }

}
