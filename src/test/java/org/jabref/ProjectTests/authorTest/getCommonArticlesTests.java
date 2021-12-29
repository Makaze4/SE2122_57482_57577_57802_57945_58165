
package org.jabref.ProjectTests.authorTest;

import org.jabref.model.database.BibDatabase;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.field.StandardField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.List;

public class  getCommonArticlesTests {

    BibDatabase dataBase1;
    BibDatabase dataBase2;
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

        entry1 = new BibEntry();
        entry1.setField(StandardField.AUTHOR, "Joao and Tim");
        entry1.setField(StandardField.TITLE, "title2");
        entryList.add(entry1);

        entry2 = new BibEntry();
        entry2.setField(StandardField.AUTHOR, "Joao and Manel");
        entry2.setField(StandardField.TITLE, "title1");
        entryList.add(entry2);

        entry3 = new BibEntry();
        entry3.setField(StandardField.AUTHOR, "Joao");
        entry3.setField(StandardField.TITLE, "title1");
        entryList.add(entry3);

        entry4 = new BibEntry();
        entry4.setField(StandardField.AUTHOR, "Tim");
        entry4.setField(StandardField.TITLE, "title1");
        entryList.add(entry4);

        entry5 = new BibEntry();
        entry5.setField(StandardField.AUTHOR, "Miguel");
        entry5.setField(StandardField.TITLE, "title2");
        entryList.add(entry5);

        entry6 = new BibEntry();
        entry6.setField(StandardField.AUTHOR, "Miguel");
        entry6.setField(StandardField.TITLE, "title2");
        entryList.add(entry6);

        entry7 = new BibEntry();
        entry7.setField(StandardField.AUTHOR, "Alexandre and Joao and Miguel");
        entry7.setField(StandardField.TITLE, "title1");
        entryList.add(entry7);

        entry8 = new BibEntry();
        entry8.setField(StandardField.AUTHOR, "Manel and Joao");
        entry8.setField(StandardField.TITLE, "title1");
        entryList.add(entry8);

        entry9 = new BibEntry();
        entry9.setField(StandardField.AUTHOR, "Virtudes");
        entry9.setField(StandardField.TITLE, "title2");
        entryList.add(entry8);

        dataBase1 = new BibDatabase(entryList);
        dataBase2 = new BibDatabase();
    }

    @Test
    @DisplayName("Test 1 - General Test - Test all the functionalities")
    void test1() {
        String timeperiodList = "";
        String author = "Joao";
        assertEquals(timeperiodList,dataBase1.getCommonArticles(author), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }



}
