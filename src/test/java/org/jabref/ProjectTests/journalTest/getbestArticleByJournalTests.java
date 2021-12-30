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
    BibEntry entry4;
    BibEntry entry5;
    BibEntry entry6;

    @BeforeEach
    void setUp() {
        List<BibEntry> entryList = new LinkedList<>();

        entry1 = new BibEntry();
        entry1.setField(StandardField.TITLE, "Title1");
        entry1.setField(StandardField.JOURNAL, "journal2");
        entry1.setField(StandardField.NUMBERCITATIONS, "3");
        entryList.add(entry1);

        entry2 = new BibEntry();
        entry2.setField(StandardField.TITLE, "Title2");
        entry2.setField(StandardField.JOURNAL, "journal2");
        entry2.setField(StandardField.NUMBERCITATIONS, "15");
        entryList.add(entry2);

        entry3 = new BibEntry();
        entry3.setField(StandardField.TITLE, "Title3");
        entry3.setField(StandardField.JOURNAL, "journal2");
        entry3.setField(StandardField.NUMBERCITATIONS, "27");
        entryList.add(entry3);

        entry4 = new BibEntry();
        entry4.setField(StandardField.TITLE, "Title4");
        entry4.setField(StandardField.JOURNAL, "journal3");
        entry4.setField(StandardField.NUMBERCITATIONS, "6");
        entryList.add(entry4);

        entry5 = new BibEntry();
        entry5.setField(StandardField.TITLE, "Title5");
        entry5.setField(StandardField.JOURNAL, "journal3");
        entry5.setField(StandardField.NUMBERCITATIONS, "217");
        entryList.add(entry5);

        entry6 = new BibEntry();
        entry6.setField(StandardField.TITLE, "Title6");
        entry6.setField(StandardField.JOURNAL, "journal3");
        entry6.setField(StandardField.NUMBERCITATIONS, "0");
        entryList.add(entry6);


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

    @Test
    @DisplayName("Test 2")
    void test2() {
        String expected = "Title3";
        String journal = "journal2";
        assertEquals(expected,dataBase1.getbestArticleByJournal(journal), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        String expected = "Title5";
        String journal = "journal3";
        assertEquals(expected,dataBase1.getbestArticleByJournal(journal), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }
}
