package Factories;

import Command.*;

public class ExitCommandFactory extends CommandFactory{
    @Override
    public Command create() throws Exception {

        System.out.println("Exit..");
        return new ExitCommand();
    }
}
