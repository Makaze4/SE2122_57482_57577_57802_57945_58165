package org.jabref.authorTests;

import org.jabref.model.database.BibDatabase;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.field.StandardField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.List;

public class getEditorRelatedToAuthorTest {

    BibDatabase dataBase;

    BibEntry entry1;
    BibEntry entry2;
    BibEntry entry3;
    BibEntry entry4;
    BibEntry entry5;
    BibEntry entry6;
    BibEntry entry7;

    @BeforeEach
    void setUp(){
        List<BibEntry> entryList = new LinkedList<>();

        entry1 = new BibEntry();
        entry1.setField(StandardField.AUTHOR, "Joao");
        entry1.setField(StandardField.JOURNAL, "journal1");
        entryList.add(entry1);

        entry2 = new BibEntry();
        entry2.setField(StandardField.AUTHOR, "Joao");
        entry2.setField(StandardField.JOURNAL, "journal2");
        entryList.add(entry2);

        entry3 = new BibEntry();
        entry3.setField(StandardField.AUTHOR, "Joao");
        entry3.setField(StandardField.JOURNAL, "journal3");
        entryList.add(entry3);

        entry4 = new BibEntry();
        entry4.setField(StandardField.AUTHOR, "Tim");
        entry4.setField(StandardField.JOURNAL, "journal1");
        entryList.add(entry4);

        entry5 = new BibEntry();
        entry5.setField(StandardField.AUTHOR, "Miguel");
        entry5.setField(StandardField.JOURNAL, "journal1");
        entryList.add(entry5);

        entry6 = new BibEntry();
        entry6.setField(StandardField.AUTHOR, "Miguel");
        entry6.setField(StandardField.JOURNAL, "journal2");
        entryList.add(entry6);

        entry7 = new BibEntry();
        entry7.setField(StandardField.AUTHOR, "Alexandre");
        entry7.setField(StandardField.JOURNAL, "journal4");
        entryList.add(entry7);


        dataBase = new BibDatabase(entryList);
    }

    @Test
    @DisplayName("Test 1")
    void test1(){
        List<String> journalList = new LinkedList<>();
        journalList.add("journal1");
        journalList.add("journal2");
        journalList.add("journal3");
        assertEquals(dataBase.getEditorsRelatedToAuthor("Joao"), journalList, "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 2")
    void test2(){
        List<String> journalList = new LinkedList<>();
        journalList.add("journal1");
        assertEquals(dataBase.getEditorsRelatedToAuthor("Tim"), journalList, "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }


}
