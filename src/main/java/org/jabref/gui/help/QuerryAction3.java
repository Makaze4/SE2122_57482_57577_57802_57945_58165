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

public class QuerryAction3 extends SimpleCommand {
    RebuildFulltextSearchIndexAction.GetCurrentLibraryTab currentLibraryTab;

    public QuerryAction3(RebuildFulltextSearchIndexAction.GetCurrentLibraryTab aux) {

        currentLibraryTab = aux;

    }

    @Override
    public void execute() {

        final JFrame frame = new JFrame();

        String s = currentLibraryTab.get().getBibDatabaseContext().getDatabase().getMostActiveAuthor();

        frame.setBounds(200,200, 450,300);
        Container container = frame.getContentPane();
        container.setLayout(null);


        JLabel logo  = new JLabel("Query - Most Active Author");
        logo.setBounds(10,5,400,20);

        JLabel result  = new JLabel("Result - The most active user is:");
        result.setBounds(25,40,450,20);

        JLabel str = new JLabel(s);
        str.setBounds(100,65,450,20);

        container.add(logo);
        container.add(result);
        container.add(str);


        frame.setVisible(true);
        frame.toFront();
    }
}
