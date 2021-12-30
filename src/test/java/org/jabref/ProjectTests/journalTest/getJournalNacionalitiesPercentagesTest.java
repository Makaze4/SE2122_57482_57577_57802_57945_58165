package org.jabref.ProjectTests.journalTest;

import javafx.util.Pair;
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
    BibEntry entry11;
    BibEntry entry12;
    BibEntry entry13;
    BibEntry entry14;
    BibEntry entry15;
    BibEntry entry16;


    @BeforeEach
    void setUp(){
        List<BibEntry> entryList = new LinkedList<>();

        entry1 = new BibEntry();
        entry1.setField(StandardField.AUTHOR, "Joao and Pedro and Tim");
        entry1.setField(StandardField.JOURNAL, "journal1");
        entry1.getAuthors().get(0).setNationality("Italia");
        entry1.getAuthors().get(1).setNationality("Portugal");
        entry1.getAuthors().get(2).setNationality("Brazil");
        entryList.add(entry1);

        entry2 = new BibEntry();
        entry2.setField(StandardField.AUTHOR, "Joao and Tim");
        entry2.setField(StandardField.JOURNAL, "journal2");
        entry2.getAuthors().get(0).setNationality("Italia");
        entry2.getAuthors().get(1).setNationality("Brazil");
        entryList.add(entry2);

        entry3 = new BibEntry();
        entry3.setField(StandardField.AUTHOR, "Pedro and Goncalo and Tiago");
        entry3.setField(StandardField.JOURNAL, "journal3");
        entry3.getAuthors().get(0).setNationality("Portugal");
        entry3.getAuthors().get(1).setNationality("Portugal");
        entry3.getAuthors().get(2).setNationality("Portugal");
        entryList.add(entry3);

        entry4 = new BibEntry();
        entry4.setField(StandardField.AUTHOR, "Tim");
        entry4.setField(StandardField.JOURNAL, "journal1");
        entry4.getAuthors().get(0).setNationality("Brazil");
        entryList.add(entry4);

        entry5 = new BibEntry();
        entry5.setField(StandardField.AUTHOR, "Diogo and Jose and Miguel");
        entry5.setField(StandardField.JOURNAL, "journal1");
        entry5.getAuthors().get(0).setNationality("Franca");
        entry5.getAuthors().get(1).setNationality("Espanha");
        entry5.getAuthors().get(2).setNationality("Alemanha");
        entryList.add(entry5);

        entry6 = new BibEntry();
        entry6.setField(StandardField.AUTHOR, "Miguel");
        entry6.setField(StandardField.JOURNAL, "journal2");
        entry6.getAuthors().get(0).setNationality("Alemanha");
        entryList.add(entry6);

        entry7 = new BibEntry();
        entry7.setField(StandardField.AUTHOR, "Alexandre");
        entry7.setField(StandardField.JOURNAL, "journal4");
        entry7.getAuthors().get(0).setNationality("Portugal");
        entryList.add(entry7);

        entry8 = new BibEntry();
        entry8.setField(StandardField.AUTHOR, "Alexandre and Pedro");
        entry8.setField(StandardField.JOURNAL, "journal4");
        entry8.getAuthors().get(0).setNationality("Portugal");
        entry8.getAuthors().get(1).setNationality("Portugal");
        entryList.add(entry8);

        entry9 = new BibEntry();
        entry9.setField(StandardField.AUTHOR, "Miguel and Matias");
        entry9.setField(StandardField.JOURNAL, "journal4");
        entry9.getAuthors().get(0).setNationality("Portugal");
        entry9.getAuthors().get(1).setNationality("Alemanha");
        entryList.add(entry9);

        entry10 = new BibEntry();
        entry10.setField(StandardField.AUTHOR, "Joao");
        entry10.setField(StandardField.JOURNAL, "journal4");
        entry10.getAuthors().get(0).setNationality("Italia");
        entryList.add(entry10);

        entry11 = new BibEntry();
        entry11.setField(StandardField.AUTHOR, "Author1");
        entry11.setField(StandardField.JOURNAL, "journal5");
        entry11.getAuthors().get(0).setNationality("Italia");
        entryList.add(entry11);

        entry12 = new BibEntry();
        entry12.setField(StandardField.AUTHOR, "Author2");
        entry12.setField(StandardField.JOURNAL, "journal5");
        entry12.getAuthors().get(0).setNationality("Italia");
        entryList.add(entry12);

        entry13 = new BibEntry();
        entry13.setField(StandardField.AUTHOR, "Author3");
        entry13.setField(StandardField.JOURNAL, "journal5");
        entry13.getAuthors().get(0).setNationality("Italia");
        entryList.add(entry13);

        entry14 = new BibEntry();
        entry14.setField(StandardField.AUTHOR, "Author4");
        entry14.setField(StandardField.JOURNAL, "journal5");
        entry14.getAuthors().get(0).setNationality("Quenia");
        entryList.add(entry14);

        entry15 = new BibEntry();
        entry15.setField(StandardField.AUTHOR, "Author5");
        entry15.setField(StandardField.JOURNAL, "journal5");
        entry15.getAuthors().get(0).setNationality("Quenia");
        entryList.add(entry15);

        entry16 = new BibEntry();
        entry16.setField(StandardField.AUTHOR, "Author6");
        entry16.setField(StandardField.JOURNAL, "journal5");
        entry16.getAuthors().get(0).setNationality("China");
        entryList.add(entry16);


        dataBase = new BibDatabase(entryList);
    }

    @Test
    @DisplayName("Test 1")
    void test1(){
        List<Pair<String, Integer>> sol = new LinkedList<>();
        sol.add(new Pair("espanha", 16));
        sol.add(new Pair("italia", 16));
        sol.add(new Pair("brazil", 16));
        sol.add(new Pair("alemanha", 16));
        sol.add(new Pair("franca", 16));
        sol.add(new Pair("portugal", 16));
        assertEquals(sol, dataBase.getJournalNacionalitiesPercentages("journal1"), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 2")
    void test2(){
        List<Pair<String, Integer>> sol = new LinkedList<>();
        sol.add(new Pair("italia", 33));
        sol.add(new Pair("brazil", 33));
        sol.add(new Pair("alemanha", 33));
        assertEquals(sol, dataBase.getJournalNacionalitiesPercentages("journal2"), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 3")
    void test3(){
        List<Pair<String, Integer>> sol = new LinkedList<>();
        sol.add(new Pair("portugal", 100));
        assertEquals(sol, dataBase.getJournalNacionalitiesPercentages("journal3"), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 4")
    void test4(){
        List<Pair<String, Integer>> sol = new LinkedList<>();
        sol.add(new Pair("portugal", 60));
        sol.add(new Pair("alemanha", 20));
        sol.add(new Pair("italia", 20));
        assertEquals(sol, dataBase.getJournalNacionalitiesPercentages("journal4"), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 5")
    void test5(){
        List<Pair<String, Integer>> sol = new LinkedList<>();
        sol.add(new Pair("italia", 50));
        sol.add(new Pair("quenia", 33));
        sol.add(new Pair("china", 16));
        assertEquals(sol, dataBase.getJournalNacionalitiesPercentages("journal5"), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

}
