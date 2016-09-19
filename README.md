# ConsoleMenuLib
A console menu library for Java following the Command pattern.

#Usage
- Import JAR into your external libaries.
- Create the menu item you would like in a class that implements Command.
- Invoke it wherever you want.

#Example
```
public class DummyCommand implements Command{
    @Override
    public void execute() {
      System.out.print("Hi, I am a dummy.")
    }
}

Command dummy = new DummyCommand();
dummy.execute(); 
-> "Hi, I am a dummy."
```
