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
import org.jabref.model.entry.field.Field;
import org.jabref.model.entry.field.InternalField;
import org.jabref.model.entry.field.OrFields;
import org.jabref.model.entry.field.StandardField;
import org.jabref.preferences.PreferencesService;

import javax.swing.undo.UndoManager;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.Spliterator;

public class ArticleInformationTab extends FieldsEditorTab {

    private final BibEntryTypesManager entryTypesManager;

    public ArticleInformationTab(BibDatabaseContext databaseContext,
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

        setText(Localization.lang("Article information"));
        setTooltip(new Tooltip(Localization.lang("Show article information")));
        setGraphic(IconTheme.JabRefIcons.OPTIONAL.getGraphicNode());
    }

    @Override
    protected Set<Field> determineFieldsToShow(BibEntry entry) {
        Set<Field> fields = new LinkedHashSet<>();
        fields.add(StandardField.TOPIC);
        fields.add(StandardField.NUMBERCITATIONS);

        return fields;
    }
}
