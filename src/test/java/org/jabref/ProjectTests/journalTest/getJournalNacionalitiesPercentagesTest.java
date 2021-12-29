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

public class getJournalNacionalitiesPercentagesTest {

    BibDatabase dataBase;

    BibEntry entry1;
    BibEntry entry2;
    BibEntry entry3;
    BibEntry entry4;
    BibEntry entry5;
    BibEntry entry6;
    BibEntry entry7;
    BibEntry entry8;
    BibEntry entry9;
    BibEntry entry10;


    @BeforeEach
    void setUp(){
        List<BibEntry> entryList = new LinkedList<>();

        entry1 = new BibEntry();
        entry1.setField(StandardField.AUTHOR, "Joao and Pedro and Tim");
        entry1.setField(StandardField.JOURNAL, "journal1");
        entryList.add(entry1);

        entry2 = new BibEntry();
        entry2.setField(StandardField.AUTHOR, "Joao and Tim");
        entry2.setField(StandardField.JOURNAL, "journal2");
        entryList.add(entry2);

        entry3 = new BibEntry();
        entry3.setField(StandardField.AUTHOR, "Pedro and Goncalo and Tiago");
        entry3.setField(StandardField.JOURNAL, "journal3");
        entryList.add(entry3);

        entry4 = new BibEntry();
        entry4.setField(StandardField.AUTHOR, "Tim");
        entry4.setField(StandardField.JOURNAL, "journal1");
        entryList.add(entry4);

        entry5 = new BibEntry();
        entry5.setField(StandardField.AUTHOR, "Diogo and Jose and Miguel");
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

        entry8 = new BibEntry();
        entry8.setField(StandardField.AUTHOR, "Alexandre and Pedro");
        entry8.setField(StandardField.JOURNAL, "journal4");
        entryList.add(entry8);

        entry9 = new BibEntry();
        entry9.setField(StandardField.AUTHOR, "Miguel and Matias");
        entry9.setField(StandardField.JOURNAL, "journal4");
        entryList.add(entry9);

        entry10 = new BibEntry();
        entry10.setField(StandardField.AUTHOR, "Joao");
        entry10.setField(StandardField.JOURNAL, "journal4");
        entryList.add(entry10);


        dataBase = new BibDatabase(entryList);
    }

    @Test
    @DisplayName("Test 1")
    void test1(){
        String sol = "Italia: 16%\nPortugal: 16%\nBrazil: 16%\nFranca: 16%\nEspanha: 16%\nAlemanha: 16%\n")
        assertEquals(sol, dataBase.getJournalNacionalitiesPercentages("journal1"), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 2")
    void test2(){
        String sol = "Italia: 33%\nBrazil: 33%\nAlemanha: 33%";
        assertEquals(sol, dataBase.getJournalNacionalitiesPercentages("journal2"), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 3")
    void test3(){
        String sol = "Portugal: 100%\n"
        assertEquals(sol, dataBase.getJournalNacionalitiesPercentages("journal3"), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 4")
    void test4(){
        String sol = "Portugal: 40%\nAlemanha: 40%\nBrazil: 20%\n"
        assertEquals(sol, dataBase.getEditorsRelatedToAuthor("journal4"), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }


}

