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

    }


}
