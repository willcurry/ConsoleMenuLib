public class TestItem implements MenuItem<String> {

    private String name;

    public TestItem(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String execute(String newName) {
        changeName(newName);
        return newName;
    }

    private void changeName(String name) {
        this.name = name;
    }
}
