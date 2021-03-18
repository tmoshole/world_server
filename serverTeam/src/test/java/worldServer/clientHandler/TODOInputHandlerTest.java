package worldServer.clientHandler;

import org.junit.jupiter.api.Test;
import worldServer.clientHandler.robot.Robot;

import static org.junit.jupiter.api.Assertions.*;

class TODOInputHandlerTest {

    @Test
    void testInvalidInputGetOutput() {
        Robot robot = new Robot("test");
        InputHandler inputHandler = new InputHandler("InValidStringInput", robot);
        assertEquals(inputHandler.getOutput(),
                "Invalid input : 'InValidStringInput', try 'help'.",
                "Must return String saying invalid.");
    }

//    @Test
//    void testValidInputOff(){
//        InputHandler inputHandler = new InputHandler("OfF");
//        assertEquals(inputHandler.getOutput(),
//                "Shutting Down..",
//                "Must return String with off status.");
//    }
//
//    @Test
//    void testValidInputHelp(){
//        String helpMessage =  "I can understand these commands:\n" +
//                "OFF  - Shut down robot\n" +
//                "HELP - provide information about commands\n" +
//                "FORWARD - move forward by specified number of steps, e.g. 'FORWARD 10'";
//
//        InputHandler inputHandler = new InputHandler("hElP");
//        assertEquals(inputHandler.getOutput(),
//                helpMessage,
//                "Must return String with help status.");
//    }
//
//    @Test
//    void testValidInputForward(){
//        InputHandler inputHandler = new InputHandler("ForWarD 10");
//        assertEquals(inputHandler.getOutput(),
//                "Moved forward by 10 steps.",
//                "Must return String with forward status.");
//    }
}