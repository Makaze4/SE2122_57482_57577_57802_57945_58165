package org.jabref.gui.entryeditor;

import javafx.scene.control.Tooltip;
import org.jabref.gui.DialogService;
import org.jabref.gui.StateManager;
import org.jabref.gui.autocompleter.SuggestionProviders;
import org.jabref.gui.externalfiletype.ExternalFileTypes;
import org.jabref.gui.icon.IconTheme;
import org.jabref.gui.util.TaskExecutor;
import org.jabref.logic.journals.JournalAbbreviationRepository;
import org.jabref.logic.l10n.Localization;
import org.jabref.model.database.BibDatabaseContext;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.BibEntryType;
import org.jabref.model.entry.BibEntryTypesManager;
import org.jabref.model.entry.field.*;
import org.jabref.preferences.PreferencesService;

import javax.swing.undo.UndoManager;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class AuthorInformationTab extends FieldsEditorTab2 {
    private final BibEntryTypesManager entryTypesManager;

    public AuthorInformationTab(BibDatabaseContext databaseContext,
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

        setText(Localization.lang("Author information"));
        setTooltip(new Tooltip(Localization.lang("Author information")));
        setGraphic(IconTheme.JabRefIcons.OPTIONAL.getGraphicNode());
    }
    @Override
    protected Set<Field> determineFieldsToShow(BibEntry entry) {
        Optional<BibEntryType> entryType = entryTypesManager.enrich(entry.getType(), databaseContext.getMode());
        Set<Field> fields = new LinkedHashSet<>();
        Map<Field, String> mapaEntries = entry.getFieldMap();

        if(mapaEntries.containsKey(StandardField.AUTHOR)){
            String st = mapaEntries.get(StandardField.AUTHOR);
            String[] authors = mapaEntries.get(StandardField.AUTHOR).split(" and ");
            LinkedHashSet<Field> lf = new LinkedHashSet<Field>();

            for (int i =0 ; i< authors.length; i++){
                String nomeF = "author " + (i+1);
                Field f = new UnknownField(nomeF);
                entry.setField(f,authors[i]);
                lf.add(f);
            }
            fields.addAll(lf);
        }

        return fields;
    }
}
