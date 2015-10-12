package client;

import client.pages.LoginPage;
import client.pages.ManuPage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Doragon on 2015-10-12.
 */
public class Client {

    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost", 2000);

            PrintWriter sendToServer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader readFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            LoginPage loginPage = new LoginPage(sendToServer);
            loginPage.openLoginPage();

            while(true){
                if (readFromServer.readLine().equals("logged")) {
                    loginPage.closeLoginPage();
                    new ManuPage(sendToServer).openMenuPage();
                }
            }

        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        } catch (IOException e) {
            System.out.println("No I/O");
            System.exit(1);
        }
    }
}
