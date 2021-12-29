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

public class getMostActiveAuthorTest {

    BibDatabase dataBase;
    BibDatabase dataBase2;
    BibDatabase dataBase3;
    BibDatabase database4;

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

    @BeforeEach
    void setUp(){
        List<BibEntry> entryList = new LinkedList<>();

        entry1 = new BibEntry();
        entry1.setField(StandardField.AUTHOR, "Joao");
        entryList.add(entry1);

        entry2 = new BibEntry();
        entry2.setField(StandardField.AUTHOR, "Joao and Miguel and Pedro");
        entryList.add(entry2);

        entry3 = new BibEntry();
        entry3.setField(StandardField.AUTHOR, "Pedro and Joao");
        entryList.add(entry3);

        entry4 = new BibEntry();
        entry4.setField(StandardField.AUTHOR, "Tim");
        entryList.add(entry4);

        entry5 = new BibEntry();
        entry5.setField(StandardField.AUTHOR, "Alexandre and Joao");
        entryList.add(entry5);

        entry6 = new BibEntry();
        entry6.setField(StandardField.AUTHOR, "Alexandre");
        entryList.add(entry6);

        entry7 = new BibEntry();
        entry7.setField(StandardField.AUTHOR, "Alexandre");
        entryList.add(entry7);

        entry8 = new BibEntry();
        entry8.setField(StandardField.AUTHOR, "Tim and Joao");
        entryList.add(entry8);

        entry9 = new BibEntry();
        entry9.setField(StandardField.AUTHOR, "Miguel and Goncalo and Jesus");
        entryList.add(entry9);

        entry10 = new BibEntry();
        entry10.setField(StandardField.AUTHOR, "Joao and Pedro");
        entryList.add(entry10);

        entry11 = new BibEntry();
        entry11.setField(StandardField.AUTHOR, "Lourenco and Bernardo");
        entryList.add(entry11);

        entry12 = new BibEntry();
        entry12.setField(StandardField.AUTHOR, "Pedro");
        entryList.add(entry12);


        dataBase = new BibDatabase(entryList);

        List<BibEntry> entryList2 = new LinkedList<>();

        entryList2.add(entry5);
        entryList2.add(entry7);
        entryList2.add(entry2);
        entryList2.add(entry4);

        dataBase2 = new BibDatabase(entryList);

        List<BibEntry> entryList3 = new LinkedList<>();

        entryList3.add(entry8);
        entryList3.add(entry9);
        entryList3.add(entry10);
        entryList3.add(entry11);
        entryList3.add(entry12);
        entryList3.add(entry1);
        entryList3.add(entry2);
        entryList3.add(entry5);


        dataBase3 = new BibDatabase(entryList3);

        List<BibEntry> entryList4 = new LinkedList<>();
        database4 = new BibDatabase(entryList4);

    }

    @Test
    @DisplayName("Test 1")
    void test1(){
        String sol = "Joao";
        assertEquals(sol, dataBase2.getMostActiveAuthor(), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 2")
    void test2(){
        String sol = "Alexandre";
        assertEquals(sol, dataBase2.getMostActiveAuthor(), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 3")
    void test3(){
        String sol = "Joao";
        assertEquals(sol, dataBase3.getMostActiveAuthor(), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 4")
    void test4(){
        String sol = "";
        assertEquals(sol, database4.getMostActiveAuthor(), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

}
