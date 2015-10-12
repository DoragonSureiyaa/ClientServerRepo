package client.common;

import javax.swing.*;

/**
 * Created by Doragon on 2015-10-12.
 */
public class FrameDesigner {

    protected JFrame frame;

    protected void createFrame(String frameText) {
        frame = new JFrame(frameText);
        frame.setSize(350, 350);
        frame.setLocation(300, 300);
        frame.setResizable(false);
        frame.setLayout(null);
    }

    protected JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setBounds(100, 180, 150, 20);
        return textField;
    }

    protected JButton createButton(String buttonText) {
        JButton button = new JButton(buttonText);
        button.setBounds(100, 220, 150, 20);
        return button;
    }
}
