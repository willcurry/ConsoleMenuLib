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
    private MenuItem item;

    @Before
    public void setUp() throws Exception {
        output = new ByteArrayOutputStream();
        writer = new PrintWriter(output);
        inputStream = new ByteArrayInputStream("Test".getBytes());
        item = new TestItem("Test");
    }

    @Test
    public void menuHasItems() {
        ArrayList<MenuItem> items = new ArrayList<>();
        items.add(item);
        ConsoleMenu consoleMenu = new ConsoleMenu(items, inputStream, writer);
        assertThat(consoleMenu.getItems(), is(items));
    }

    @Test
    public void itemsHaveNames() {
        ArrayList<MenuItem> items = new ArrayList<>();
        items.add(item);
        ConsoleMenu consoleMenu = new ConsoleMenu(items, inputStream, writer);
        assertThat(consoleMenu.getItems().get(0).name(), is("Test"));
    }

    @Test
    public void itemsDisplayTheirIDAndName() {
        ArrayList<MenuItem> items = new ArrayList<>();
        items.add(item);
        ConsoleMenu consoleMenu = new ConsoleMenu(items, inputStream, writer);
        consoleMenu.displayItems();
        assertThat(output.toString(), containsString("0) Test"));
    }

    @Test
    public void quitIsTheLastItemAndHasTheLastID() {
        ArrayList<MenuItem> items = new ArrayList<>();
        items.add(item);
        ConsoleMenu consoleMenu = new ConsoleMenu(items, inputStream, writer);
        consoleMenu.displayItems();
        assertThat(output.toString(), containsString("1) Quit"));
    }

    @Test
    public void canExecuteItems() {
        ArrayList<MenuItem> items = new ArrayList<>();
        items.add(item);
        ConsoleMenu consoleMenu = new ConsoleMenu(items, inputStream, writer);
        consoleMenu.getItems().get(0).execute("Test2");
        assertThat(consoleMenu.getItems().get(0).name(), is("Test2"));
    }

    @Test
    public void itemsExecuteWhenSelectedByUser() {
        ArrayList<MenuItem> items = new ArrayList<>();
        MenuItem item2 = new TestItem("AnotherItem");
        items.add(item);
        items.add(item2);
        ConsoleMenu consoleMenu = new ConsoleMenu(items, inputStream, writer);
        consoleMenu.userSelectItem("Test2");
        assertThat(consoleMenu.getItems().get(0).name(), is("Test2"));
    }
}
