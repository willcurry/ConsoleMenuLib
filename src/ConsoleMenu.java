import java.io.*;
import java.util.ArrayList;

public class ConsoleMenu<E> {
    private ArrayList<MenuItem> items;
    private final InputStream stream;
    private final BufferedReader inputReader;
    private final Writer writer;

    public ConsoleMenu(ArrayList<MenuItem> items, InputStream stream, Writer writer) {
        this.items = items;
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

    public void userSelectItem(E arg) {
        String input = userInput();
        for (MenuItem item : items) {
             if (input.equals(item.name())) {
                item.execute(arg);
             }
        }
    }

    public ArrayList<MenuItem> getItems() {
        return this.items;
    }

    public void displayItems() {
        for (MenuItem item : items) {
            print(items.indexOf(item) + ") " + item.name());
        }
        print(items.size() + ") Quit");
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
