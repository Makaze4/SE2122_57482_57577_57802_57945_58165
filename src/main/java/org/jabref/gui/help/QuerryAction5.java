package org.jabref.gui.help;


import javafx.util.Pair;
import org.jabref.gui.DialogService;
import org.jabref.gui.actions.SimpleCommand;

import com.airhacks.afterburner.injection.Injector;
import org.jabref.gui.search.RebuildFulltextSearchIndexAction;
import org.jabref.model.database.BibDatabase;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class QuerryAction5 extends SimpleCommand {

    RebuildFulltextSearchIndexAction.GetCurrentLibraryTab currentLibraryTab;

    public QuerryAction5(RebuildFulltextSearchIndexAction.GetCurrentLibraryTab aux) {
        currentLibraryTab = aux;
    }

    @Override
    public void execute() {
        final JFrame frame = new JFrame();

        frame.setBounds(200,200, 400,300);
        Container container = frame.getContentPane();
        container.setLayout(null);


        JLabel logo  = new JLabel("Query - Journals Related To Author");
        logo.setBounds(10,5,400,50);

        JLabel author  = new JLabel("Author: Inserir");
        author.setBounds(10,45,100,50);

        JTextField text = new JTextField("");
        text.setBounds(10,80,300,35);

        JButton button = new JButton("Confirmar");
        button.setBounds(10,150,100, 40);

        container.add(logo);
        container.add(author);
        container.add(text);
        container.add(button);

        button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String name = text.getText();
                String result = "";
                List<String> list = currentLibraryTab.get().getBibDatabaseContext().getDatabase().getEditorsRelatedToAuthor(name);
                for(String st: list){
                    result += "Journal: " + st + "\n";
                }
                JOptionPane.showMessageDialog(frame, result);
            }
        });

        frame.setVisible(true);

    }


}

