public class Quit implements Command {

    private final String name;
    private boolean hasQuit = false;

    public Quit(String name) {
        this.name = name;
    }

    @Override
    public void execute() {
        hasQuit = true;
    }

    @Override
    public String name() {
        return name;
    }
}
