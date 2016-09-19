public class DummyCommand implements Command {

    private String name;

    public DummyCommand(String name) {
        this.name = name;
    }

    @Override
    public void execute() {
        name = "newName";
    }

    @Override
    public String name() {
        return name;
    }
}
