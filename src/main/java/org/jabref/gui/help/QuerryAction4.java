package org.jabref.gui.help;


import javafx.util.Pair;
import org.jabref.gui.DialogService;
import org.jabref.gui.actions.SimpleCommand;

import com.airhacks.afterburner.injection.Injector;
import org.jabref.gui.search.RebuildFulltextSearchIndexAction;
import org.jabref.model.database.BibDatabase;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class QuerryAction4 extends SimpleCommand {
    RebuildFulltextSearchIndexAction.GetCurrentLibraryTab currentLibraryTab;

    public QuerryAction4(RebuildFulltextSearchIndexAction.GetCurrentLibraryTab aux) {

        currentLibraryTab = aux;

    }

    @Override
    public void execute() {

        final JFrame frame = new JFrame();

        List<String> list = currentLibraryTab.get().getBibDatabaseContext().getDatabase().getTopicRanking();

        frame.setBounds(200,200, 450,300);
        Container container = frame.getContentPane();
        container.setLayout(null);


        JLabel logo  = new JLabel("Query - Topic Rankings");
        logo.setBounds(10,5,400,20);

        container.add(logo);

        int i = 0;
        int j = 1;
        for(String l : list){
            String s = j + "º: " + l;
            JLabel teste  = new JLabel(s);
            teste.setBounds(25,40 + i,300,20);
            i+=20;
            j++;
            container.add(teste);
        }

        frame.setVisible(true);
        frame.toFront();
    }
}
