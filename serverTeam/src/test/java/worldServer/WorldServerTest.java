package worldServer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.*;

class WorldServerTest {
    private final PrintStream standardOut = System.out;
    private final InputStream standardIn = System.in;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
        System.setIn(standardIn);
    }

    @Test
    void testInvalidPort(){
        try {
            WorldServer server = new WorldServer(1);
            // try to connect to client with invalid port and server name.
            Socket client = new Socket("unknown", 12425364);
            fail("IT Must throw IOException.");
        } catch (IOException e){
            assertTrue(true, "IT Must throw IOException. "+e.getMessage());
        }
    }

//    @Test
//    void  testValidPort(){
//
//    }

    @Test
    void testIfClientCanConnect() throws IOException {
        WorldServer server = new WorldServer(6066);
        server.run();
        Socket client = new Socket("localhost", 6066);
        System.setOut(standardOut);
        System.out.println(outputStreamCaptor.toString().trim());
        assertEquals(outputStreamCaptor.toString().trim(), "fysdhyfh",
                "Client Must connect and Server outputs message.");
    }


}