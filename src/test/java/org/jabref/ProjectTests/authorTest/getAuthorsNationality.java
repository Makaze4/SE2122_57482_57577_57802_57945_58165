package org.jabref.ProjectTests.authorTest;

import org.jabref.model.database.BibDatabase;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.EntryAuthor;
import org.jabref.model.entry.field.StandardField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.List;

public class getAuthorsNationality {

    BibDatabase dataBase;

    BibEntry entry1;
    BibEntry entry2;
    BibEntry entry3;
    BibEntry entry4;
    BibEntry entry5;

    @BeforeEach
    void setup() {
        List<BibEntry> entryList = new LinkedList<>();

        entry1 = new BibEntry();
        entry1.setField(StandardField.AUTHOR, "Joao");
        entry1.getAuthors();
        entryList.add(entry1);
        EntryAuthor a = new EntryAuthor("Joao", "Portugal");
        a.setNationality("Portugal");
        entry2 = new BibEntry();
        entry2.setField(StandardField.AUTHOR, "Diogo");
        entry2.setField(StandardField.NATIONALITY, "Portugal");
        entryList.add(entry2);

        entry3 = new BibEntry();
        entry3.setField(StandardField.AUTHOR, "Francisco");
        entry3.setField(StandardField.NATIONALITY, "Spain");
        entryList.add(entry3);

        dataBase = new BibDatabase(entryList);
    }

    @Test
    @DisplayName("Test1")
    void test1() {
        List<String> authorList = new LinkedList<>();
        authorList.add("Joao");
        authorList.add("Diogo");
        assertEquals(authorList, dataBase.getAuthorsNacionality("Portugal"), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }
}
