package org.jabref.gui.help;


import javafx.util.Pair;
import org.jabref.gui.DialogService;
import org.jabref.gui.actions.SimpleCommand;

import com.airhacks.afterburner.injection.Injector;
import org.jabref.gui.search.RebuildFulltextSearchIndexAction;
import org.jabref.model.database.BibDatabase;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;

public class QuerryAction9 extends SimpleCommand {

    RebuildFulltextSearchIndexAction.GetCurrentLibraryTab currentLibraryTab;

    public QuerryAction9(RebuildFulltextSearchIndexAction.GetCurrentLibraryTab aux) {
        currentLibraryTab = aux;
    }

    @Override
    public void execute() {
        final JFrame frame = new JFrame();

        frame.setBounds(200,200, 400,500);
        Container container = frame.getContentPane();
        container.setLayout(null);


        JLabel logo  = new JLabel("Query - Articles by an author about a topic in a time period");
        logo.setBounds(10,5,400,50);

        JLabel author  = new JLabel("Author: Inserir");
        author.setBounds(10,45,400,50);

        JTextField textA = new JTextField("");
        textA.setBounds(10,80,300,35);

        JLabel topic  = new JLabel("Topic: Inserir");
        topic.setBounds(10,110,400,50);

        JTextField textT = new JTextField("");
        textT.setBounds(10,145,300,35);

        JLabel year1  = new JLabel("Ano anterior: Inserir");
        year1.setBounds(10,185,400,50);

        JTextField textY1 = new JTextField("");
        textY1.setBounds(10,220,300,35);

        JLabel year2  = new JLabel("Ano seguinte: Inserir");
        year2.setBounds(10,260,400,50);

        JTextField textY2 = new JTextField("");
        textY2.setBounds(10,295,300,35);

        JButton button = new JButton("Confirmar");
        button.setBounds(10,375,100, 40);

        container.add(logo);
        container.add(author);
        container.add(textA);
        container.add(topic);
        container.add(textT);
        container.add(year1);
        container.add(textY1);
        container.add(year2);
        container.add(textY2);
        container.add(button);

        button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String nameAuthor = textA.getText();
                String nameTopic = textT.getText();
                int year1S = Integer.parseInt(textY1.getText());
                int year2S = Integer.parseInt(textY2.getText());
                String result = "";
                List<String> list = currentLibraryTab.get().getBibDatabaseContext().getDatabase().getAuthorArticlesTopicInPeriod(nameAuthor,nameTopic,year1S,year2S);

                for(String st: list){
                    result += "Article: " + st + "\n";
                }
                JOptionPane.showMessageDialog(frame, result);
            }
        });

        frame.setVisible(true);
        frame.toFront();

    }


}
