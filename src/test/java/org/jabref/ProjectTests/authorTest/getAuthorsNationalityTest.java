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

public class getAuthorsNationalityTest {

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
        entry1.getAuthors().get(0).setNationality("Portugal");
        entryList.add(entry1);

        entry2 = new BibEntry();
        entry2.setField(StandardField.AUTHOR, "Diogo");
        entry2.getAuthors().get(0).setNationality("Portugal");
        entryList.add(entry2);

        entry3 = new BibEntry();
        entry3.setField(StandardField.AUTHOR, "Francisco and Alexandre");
        entry3.getAuthors().get(0).setNationality("Spain");
        entry3.getAuthors().get(1).setNationality("France");
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

    @Test
    @DisplayName("Test2")
    void test2() {
        List<String> authorList = new LinkedList<>();
        authorList.add("Alexandre");
        assertEquals(authorList, dataBase.getAuthorsNacionality("France"), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test3")
    void test3() {
        List<String> authorList = new LinkedList<>();
        assertEquals(authorList, dataBase.getAuthorsNacionality("Brazil"), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }
}
