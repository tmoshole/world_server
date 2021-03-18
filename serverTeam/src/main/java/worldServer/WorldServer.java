package worldServer;

import worldServer.clientHandler.InputHandler;
import worldServer.clientHandler.robot.Robot;

import java.net.*;
import java.io.*;


public class WorldServer extends Thread {
    private ServerSocket serverSocket;

    public WorldServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }

    public void run() {
        while(true) {
            try {
                System.out.println("World server running on port " +
                        serverSocket.getLocalPort() + "...");
                Socket server = serverSocket.accept();

                System.out.println("Connected to " + server.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println(in.readUTF());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());

                out.writeUTF("Your Robot is now turning on..");
                activateRobot(in, out);
                server.close();
            } catch (SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    private void activateRobot(DataInputStream in, DataOutputStream out) throws IOException {
         out.writeUTF("Give your Robot a name.");
         Robot robot = new Robot(in.readUTF().trim());
         out.writeUTF(robot.getStatus());
         while (true){
              String clientInput = in.readUTF().trim();
              out.writeUTF(new InputHandler(clientInput, robot).getOutput());
              if (in.readUTF() == "off")
                  break;
         }
    }

    public static void main(String [] args) {
        int port = Integer.parseInt(args[0]);
        try {
            Thread t = new WorldServer(port);
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

