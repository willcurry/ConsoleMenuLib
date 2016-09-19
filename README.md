# ConsoleMenuLib
A console menu library for Java following the Command pattern.

#Usage
Import JAR into your external libaries.

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
