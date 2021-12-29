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
        Optional<BibEntryType> entryType = entryTypesManager.enrich(entry.getType(), databaseContext.getMode());
        Set<Field> fields = new LinkedHashSet<>();
        Map<Field, String> mapaEntries = entry.getFieldMap();

        if (mapaEntries.containsKey(StandardField.JOURNAL)) {
            String s = mapaEntries.get(StandardField.JOURNAL);
            Field nomeF = new UnknownField("Journal name ");
            entry.setField(nomeF, s);

            fields.add(nomeF);

            Field authorPercentages = new UnknownField("Nacionality percentages ");

            BibDatabase bd = databaseContext.getDatabase();
            String nac = bd.getJournalNacionalitiesPercentages(s);

            entry.setField(authorPercentages, nac);
            fields.add(authorPercentages);
        }


        return fields;
    }
}
