package worldServer.clientHandler;

import worldServer.clientHandler.robot.Robot;
import worldServer.worldCommands.Command;

public class InputHandler {
    String input;
    Robot target;

    public InputHandler(String input, Robot target){
        this.input = input;
        this.target = target;
    }

    public String getOutput(){
        Command command = Command.create(this.input);;
        if (target.handleCommand(command))
            return target.getStatus();
        return "Invalid Instructions please try help!";
    }
}
