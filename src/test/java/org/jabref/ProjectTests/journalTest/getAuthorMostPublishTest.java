package org.jabref.ProjectTests.journalTest;

import org.jabref.model.database.BibDatabase;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.EntryAuthor;
import org.jabref.model.entry.field.StandardField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class getAuthorMostPublishTest {
    BibDatabase dataBase1;
    BibDatabase dataBase2;
    BibDatabase dataBase3;
    BibDatabase dataBase4;
    BibEntry entry1;
    BibEntry entry2;
    BibEntry entry3;
    BibEntry entry4;
    BibEntry entry5;
    BibEntry entry6;
    BibEntry entry7;
    BibEntry entry8;
    BibEntry entry9;

    @BeforeEach
    void setUp() {
        List<BibEntry> entryList = new LinkedList<>();
        List<BibEntry> entryList2 = new LinkedList<>();
        List<BibEntry> entryList3 = new LinkedList<>();

        entry1 = new BibEntry();
        entry1.setField(StandardField.AUTHOR, "Tim");
        entry1.setField(StandardField.JOURNAL, "journal1");
        entryList2.add(entry1);

        entry2 = new BibEntry();
        entry2.setField(StandardField.AUTHOR, "Joao");
        entry2.setField(StandardField.JOURNAL, "journal2");
        entryList.add(entry2);
        entryList2.add(entry2);

        entry3 = new BibEntry();
        entry3.setField(StandardField.AUTHOR, "Tim");
        entry3.setField(StandardField.JOURNAL, "journal2");
        entryList.add(entry3);

        entry4 = new BibEntry();
        entry4.setField(StandardField.AUTHOR, "Joao and Andre");
        entry4.setField(StandardField.JOURNAL, "journal1");
        entryList2.add(entry4);

        entry5 = new BibEntry();
        entry5.setField(StandardField.AUTHOR, "Andre and Alex");
        entry5.setField(StandardField.JOURNAL, "journal1");
        entryList2.add(entry5);
        entryList3.add(entry5);

        entry6 = new BibEntry();
        entry6.setField(StandardField.AUTHOR, "Tim and Alex");
        entry6.setField(StandardField.JOURNAL, "journal2");
        entryList.add(entry6);

        entry7 = new BibEntry();
        entry7.setField(StandardField.AUTHOR, "Carla");
        entry7.setField(StandardField.JOURNAL, "journal2");
        entryList.add(entry7);
        entryList2.add(entry7);

        entry8 = new BibEntry();
        entry8.setField(StandardField.AUTHOR, "Joao and Carla");
        entry8.setField(StandardField.JOURNAL, "journal1");
        entryList2.add(entry8);
        entryList3.add(entry8);

        entry9 = new BibEntry();
        entry9.setField(StandardField.AUTHOR, "Carla and Andre");
        entry9.setField(StandardField.JOURNAL, "journal1");
        entryList2.add(entry9);
        entryList3.add(entry9);

        dataBase1 = new BibDatabase(new LinkedList<>());
        dataBase2 = new BibDatabase(entryList);
        dataBase3 = new BibDatabase(entryList2);
        dataBase4 = new BibDatabase(entryList3);
    }

    @Test
    @DisplayName("Test 1 - Empty Entry Test")
    void test1() {
        String expected = "";
        String journal = "journal2";
        assertEquals(expected,dataBase1.getAuthorWithMorePublish(journal), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 2 - Simple Test")
    void test2() {
       String expected = "[Tim]";
        String journal = "journal2";
        assertEquals(expected,dataBase2.getAuthorWithMorePublish(journal), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 3 - Complex Test")
    void test3() {
        String expected = "[Andre]";
        String journal = "journal1";
        assertEquals(expected,dataBase3.getAuthorWithMorePublish(journal), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 4 - Draw Test")
    void test4() {
        String expected = "[Andre, Carla]";
        String journal = "journal1";
        assertEquals(expected,dataBase4.getAuthorWithMorePublish(journal), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }
}
