public class Quit implements Command {

    private final String name = "Quit";
    private boolean hasQuit = false;

    @Override
    public void execute() {
        hasQuit = true;
    }

    @Override
    public String name() {
        return name;
    }

    public boolean hasQuit() {
        return hasQuit;
    }
}
