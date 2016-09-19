import java.io.*;
import java.util.ArrayList;

public class ConsoleMenu {
    private ArrayList<Command> commands;
    private final InputStream stream;
    private final BufferedReader inputReader;
    private final Writer writer;

    public ConsoleMenu(ArrayList<Command> commands, InputStream stream, Writer writer) {
        this.commands = commands;
        this.stream = stream;
        this.writer = writer;
        inputReader = new BufferedReader(new InputStreamReader(stream));
    }

    public String userInput() {
        try {
            return inputReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Command> getCommands() {
        return commands;
    }

    public void userSelectCommand() {
        String userInput = userInput();
        for (Command command : commands) {
            if (userInput.equals(command.name())) {
                command.execute();
            }
        }
    }

    public void displayItems() {
        for (Command command : commands) {
            print(commands.indexOf(command) + ") " + command.name());
        }
    }

    private void print(String text) {
        try {
            writer.write(text + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
