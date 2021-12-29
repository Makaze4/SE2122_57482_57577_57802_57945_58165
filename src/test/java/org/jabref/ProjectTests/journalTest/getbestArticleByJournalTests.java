package org.jabref.ProjectTests.journalTest;

import org.jabref.model.database.BibDatabase;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.field.StandardField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.List;

public class getbestArticleByJournalTests {

    BibDatabase dataBase1;
    BibDatabase dataBase2;
    BibEntry entry1;
    BibEntry entry2;
    BibEntry entry3;

    @BeforeEach
    void setUp() {
        List<BibEntry> entryList = new LinkedList<>();

        entry1 = new BibEntry();
        entry1.setField(StandardField.AUTHOR, "Tim");
        entry1.setField(StandardField.TITLE, "Title1");
        entry1.setField(StandardField.JOURNAL, "journal2");
        entryList.add(entry1);

        entry2 = new BibEntry();
        entry2.setField(StandardField.AUTHOR, "Joao");
        entry2.setField(StandardField.TITLE, "Title2");
        entry2.setField(StandardField.JOURNAL, "journal2");
        entryList.add(entry2);

        entry3 = new BibEntry();
        entry3.setField(StandardField.AUTHOR, "Joao and Tim");
        entry3.setField(StandardField.TITLE, "Title3");
        entry3.setField(StandardField.JOURNAL, "journal2");
        entryList.add(entry3);


        dataBase1 = new BibDatabase(entryList);
        dataBase2 = new BibDatabase();
    }

    @Test
    @DisplayName("Test 1 - Simple Test")
    void test1() {
        String expected = "";
        String journal = "journal1";
        assertEquals(expected,dataBase1.getbestArticleByJournal(journal), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }
}
