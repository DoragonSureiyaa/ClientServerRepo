package client.pages;

import client.common.FrameDesigner;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

/**
 * Created by Doragon on 2015-10-12.
 */
public class ManuPage extends FrameDesigner {

    private PrintWriter sendToServer;
    private JTextField textField;
    private JButton submitButton;

    public ManuPage(PrintWriter sendToServer) {
        this.sendToServer = sendToServer;
    }

    public void openMenuPage() {
        createFrame("MenuPage");
        textField = createTextField();
        submitButton = createButton("ManuPageButton");

        frame.add(textField);
        frame.add(submitButton);
        frame.setVisible(true);

        submitButtonAction();
    }

    private void submitButtonAction() {
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                sendToServer.println(textField.getText());
            }
        });
    }
}
