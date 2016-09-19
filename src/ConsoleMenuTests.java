import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConsoleMenuTests {

    private Writer writer;
    private ByteArrayOutputStream output;
    private InputStream inputStream;
    private Command command;
    ArrayList<Command> commands;

    @Before
    public void setUp() throws Exception {
        output = new ByteArrayOutputStream();
        writer = new PrintWriter(output);
        inputStream = new ByteArrayInputStream("Test".getBytes());
        command = new DummyCommand("Test");
        commands = new ArrayList<>();
    }

    @Test
    public void menuHasItems() {
        commands.add(command);
        ConsoleMenu consoleMenu = new ConsoleMenu(commands, inputStream, writer);
        assertThat(consoleMenu.getCommands(), is(commands));
    }

    @Test
    public void itemsHaveNames() {
        commands.add(command);
        ConsoleMenu consoleMenu = new ConsoleMenu(commands, inputStream, writer);
        assertThat(consoleMenu.getCommands().get(0).name(), is("Test"));
    }

    @Test
    public void itemsDisplayTheirIDAndName() {
        commands.add(command);
        ConsoleMenu consoleMenu = new ConsoleMenu(commands, inputStream, writer);
        consoleMenu.displayItems();
        assertThat(output.toString(), containsString("0) Test"));
    }

    @Test
    public void canExecuteCommands() {
        commands.add(command);
        command.execute();
        assertThat(command.name(), is("newName"));
    }

    @Test
    public void itemsExecuteWhenSelectedByUser() {
        commands.add(command);
        ConsoleMenu consoleMenu = new ConsoleMenu(commands, inputStream, writer);
        consoleMenu.userSelectCommand();
        assertThat(command.name(), is("newName"));
    }
}
