package org.jabref.gui.help;


import org.jabref.gui.DialogService;
import org.jabref.gui.actions.SimpleCommand;

import com.airhacks.afterburner.injection.Injector;

import javax.swing.*;

public class QuerryAction extends SimpleCommand {

    public QuerryAction() {
    }

    @Override
    public void execute() {
        final JFrame frame = new JFrame();
        JButton button = new JButton();

        button.setText("Click me to show dialog!");
        frame.add(button);
        frame.pack();
        frame.setVisible(true);

        button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String name = JOptionPane.showInputDialog(frame,
                        "What is your name?", null);
            }
        });
    }


}
