package client.pages;

import client.common.FrameDesigner;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

/**
 * Created by Doragon on 2015-10-12.
 */
public class LoginPage extends FrameDesigner {

    private PrintWriter sendToServer;
    private JTextField loginTextBox;
    private JButton submitButton;

    public LoginPage(PrintWriter sendToServer) {
        this.sendToServer = sendToServer;
    }

    public void openLoginPage() {
        createFrame("LoginPage");
        loginTextBox = createTextField();
        submitButton = createButton("Login");

        frame.add(loginTextBox);
        frame.add(submitButton);
        frame.setVisible(true);

        submitButtonAction();
    }

    public void closeLoginPage() {
        frame.setVisible(false);
    }

    private void submitButtonAction() {
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                sendToServer.println(loginTextBox.getText());
            }
        });
    }
}
