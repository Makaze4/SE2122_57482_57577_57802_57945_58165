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

public class QuerryAction extends SimpleCommand {

    RebuildFulltextSearchIndexAction.GetCurrentLibraryTab currentLibraryTab;

    public QuerryAction(RebuildFulltextSearchIndexAction.GetCurrentLibraryTab aux) {
        currentLibraryTab = aux;
    }

    @Override
    public void execute() {
        final JFrame frame = new JFrame();

        List<Pair<String, Integer>> list = currentLibraryTab.get().getBibDatabaseContext().getDatabase().getPercentageOfAuthorsByNationality();

        frame.setBounds(200,200, 700,300);
        Container container = frame.getContentPane();
        container.setLayout(null);


        JLabel logo  = new JLabel("Query - Percentage Of Author By Nacionatity");
        logo.setBounds(100,10,400,50);

        JLabel result  = new JLabel("Result:");
        result.setBounds(25,10,450,200);

        container.add(logo);
        container.add(result);
        int i = 0;
        for(Pair<String, Integer> pair : list){
            String s = pair.getKey() + "  ->  " + pair.getValue() + "%";
            JLabel teste  = new JLabel(s);
            teste.setBounds(25,50 + i,450,200);
            i+=20;
            container.add(teste);
        }


        frame.setVisible(true);
        frame.toFront();
    }


}
