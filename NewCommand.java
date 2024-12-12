package mobilecompany.commands;


public class NewCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Я Нова команда.");
    }
    @Override
    public String getDesc(){
        return "нова команда";
    }
}
