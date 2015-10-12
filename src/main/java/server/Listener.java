package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Doragon on 2015-10-12.
 */
public class Listener extends Thread {

    public void run() {
        try {
            ServerSocket server = new ServerSocket(2000);

            while(true) {
                System.out.println("Waiting for connection...");
                Socket client = server.accept();

                System.out.println("Client connected: " + client.getInetAddress().getHostName());
                new Exchange(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
