public class TestCommand implements Command {

    private String name;

    public TestCommand(String name) {
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
