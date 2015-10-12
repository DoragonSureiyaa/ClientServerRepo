package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Doragon on 2015-10-12.
 */
public class Exchange extends Thread {

    private Socket client;
    private PrintWriter sendToClient;
    private BufferedReader readFromClient;

    public Exchange(Socket client) {
        this.client = client;
    }

    public void run() {
        try{
            sendToClient = new PrintWriter(client.getOutputStream(), true);
            readFromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));

            if (login()) {
                sendToClient.println("logged");

                while (true) {
                    //ManuPageExchanger
                    String echo = readFromClient.readLine();
                    System.out.println("MenuPage / Received: " + echo);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean login() {
        try {
            while (true) {
                String echo = readFromClient.readLine();
                System.out.println("From Client: " + client.toString() + " / Received: " + echo);

                if (echo.equals("admin")) {
                    System.out.println("Logged in");
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
    }
}
