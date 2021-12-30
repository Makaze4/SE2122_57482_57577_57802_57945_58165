package org.jabref.gui.entryeditor;

import javafx.scene.control.Tooltip;
import javafx.util.Pair;
import org.jabref.gui.DialogService;
import org.jabref.gui.StateManager;
import org.jabref.gui.autocompleter.SuggestionProviders;
import org.jabref.gui.externalfiletype.ExternalFileTypes;
import org.jabref.gui.icon.IconTheme;
import org.jabref.gui.util.TaskExecutor;
import org.jabref.logic.journals.JournalAbbreviationRepository;
import org.jabref.logic.l10n.Localization;
import org.jabref.model.database.BibDatabase;
import org.jabref.model.database.BibDatabaseContext;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.BibEntryType;
import org.jabref.model.entry.BibEntryTypesManager;
import org.jabref.model.entry.field.*;
import org.jabref.preferences.PreferencesService;

import javax.swing.undo.UndoManager;
import java.util.*;

public class JournalInformationTab extends FieldsEditorTab2 {
    private final BibEntryTypesManager entryTypesManager;

    public JournalInformationTab(BibDatabaseContext databaseContext,
                                SuggestionProviders suggestionProviders,
                                UndoManager undoManager,
                                DialogService dialogService,
                                PreferencesService preferences,
                                StateManager stateManager,
                                BibEntryTypesManager entryTypesManager,
                                ExternalFileTypes externalFileTypes,
                                TaskExecutor taskExecutor,
                                JournalAbbreviationRepository journalAbbreviationRepository) {

        super(false, databaseContext, suggestionProviders, undoManager, dialogService,
                preferences, stateManager, externalFileTypes, taskExecutor, journalAbbreviationRepository);
        this.entryTypesManager = entryTypesManager;

        setText(Localization.lang("Journal information"));
        setTooltip(new Tooltip(Localization.lang("Journal information")));
        setGraphic(IconTheme.JabRefIcons.OPTIONAL.getGraphicNode());
    }
    @Override
    protected Set<Field> determineFieldsToShow(BibEntry entry) {
        Set<Field> fields = new LinkedHashSet<>();
        Map<Field, String> mapaEntries = entry.getFieldMap();

        if (mapaEntries.containsKey(StandardField.JOURNAL)) {
            String s = mapaEntries.get(StandardField.JOURNAL);
            Field nomeF = new UnknownField("Journal_name:");
            entry.setField(nomeF, s);

            fields.add(nomeF);

            Field authorPercentages = new UnknownField("Nacionality_percentages:");

            BibDatabase bd = databaseContext.getDatabase();
            List<Pair<String, Integer>> nac = bd.getJournalNacionalitiesPercentages(s);
            String totalNacionalities = "";

            for(int i = 0; i<nac.size();i++){
                    totalNacionalities += nac.get(i).getKey() + ": " + nac.get(i).getValue().toString() + " %\n";
            }


            entry.setField(authorPercentages, totalNacionalities);
            fields.add(authorPercentages);

            Field decadeF = new UnknownField("Most_active_decade:");
            String decade = bd.getTimePeriodWithMostArticles(s);
            entry.setField(decadeF,decade);

            fields.add(decadeF);


            Field authorWithMorePublicationsF = new UnknownField("Authors_with_more_publications:");

            String author = bd.getAuthorWithMorePublish(s);

            author = author.replace("[","");
            author = author.replace("]","");
            entry.setField(authorWithMorePublicationsF, author);
            fields.add(authorWithMorePublicationsF);

            Field bestArticleF = new UnknownField("Best_article:");
            String title = bd.getbestArticleByJournal(s);

            if(title == null){
                title = "N/A";
            }

            entry.setField(bestArticleF, title);

            fields.add(bestArticleF);
        }


        return fields;
    }
}
