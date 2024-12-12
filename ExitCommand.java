package mobilecompany.commands;

public class ExitCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Exiting...");
        System.exit(0);
    }

    @Override
    public String getDesc() {
        return "❌ Exit Program";
    }
}
