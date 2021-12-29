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

public class getTimePeriodWithMostArticlesTests {

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
    BibEntry entry10;
    BibEntry entry11;
    BibEntry entry12;
    BibEntry entry13;
    BibEntry entry14;
    BibEntry entry15;


    @BeforeEach
    void setUp() {
        List<BibEntry> entryList = new LinkedList<>();

        entry1 = new BibEntry();
        entry1.setField(StandardField.YEAR, "2001");
        entry1.setField(StandardField.JOURNAL, "journal2");
        entryList.add(entry1);

        entry2 = new BibEntry();
        entry2.setField(StandardField.YEAR, "2010");
        entry2.setField(StandardField.JOURNAL, "journal2");
        entryList.add(entry2);

        entry3 = new BibEntry();
        entry3.setField(StandardField.YEAR, "2014");
        entry3.setField(StandardField.JOURNAL, "journal2");
        entryList.add(entry3);

        entry4 = new BibEntry();
        entry4.setField(StandardField.YEAR, "2020");
        entry4.setField(StandardField.JOURNAL, "journal2");
        entryList.add(entry4);

        entry5 = new BibEntry();
        entry5.setField(StandardField.YEAR, "2015");
        entry5.setField(StandardField.JOURNAL, "journal1");
        entryList.add(entry5);

        entry6 = new BibEntry();
        entry6.setField(StandardField.YEAR, "2016");
        entryList.add(entry6);

        entry7 = new BibEntry();
        entry7.setField(StandardField.YEAR, "2017");
        entry7.setField(StandardField.JOURNAL, "journal1");
        entryList.add(entry7);

        entry8 = new BibEntry();
        entry8.setField(StandardField.YEAR, "2017");
        entry8.setField(StandardField.JOURNAL, "journal4");
        entryList.add(entry8);

        entry9 = new BibEntry();
        entry9.setField(StandardField.AUTHOR, "Virtudes");
        entry9.setField(StandardField.YEAR, "2007");
        entry9.setField(StandardField.JOURNAL, "journal4");
        entryList.add(entry9);

        entry10 = new BibEntry();
        entry10.setField(StandardField.YEAR, "2005");
        entry10.setField(StandardField.JOURNAL, "journal2");
        entryList.add(entry10);

        entry11 = new BibEntry();
        entry11.setField(StandardField.YEAR, "2021");
        entry11.setField(StandardField.JOURNAL, "journal2");
        entryList.add(entry11);

        entry12 = new BibEntry();
        entry12.setField(StandardField.YEAR, "1995");
        entry12.setField(StandardField.JOURNAL, "journal5");
        entryList.add(entry12);

        entry13 = new BibEntry();
        entry13.setField(StandardField.YEAR, "1999");
        entry13.setField(StandardField.JOURNAL, "journal5");
        entryList.add(entry13);

        entry14 = new BibEntry();
        entry14.setField(StandardField.YEAR, "2021");
        entry14.setField(StandardField.JOURNAL, "journal5");
        entryList.add(entry14);

        entry15 = new BibEntry();
        entry15.setField(StandardField.YEAR, "2009");
        entry15.setField(StandardField.JOURNAL, "journal5");
        entryList.add(entry15);

        dataBase1 = new BibDatabase(entryList);
        dataBase2 = new BibDatabase();
    }

    @Test
    @DisplayName("Test 1 - Simple Test")
    void test1() {
        String timeperiodList = "Decada 2010-20 ";
        String journal = "journal1";
        assertEquals(timeperiodList,dataBase1.getTimePeriodWithMostArticles(journal), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 2 - Test with null databases")
    void test2() {
        String timeperiodList = "";
        String journal = "journal1";
        assertEquals(timeperiodList,dataBase2.getTimePeriodWithMostArticles(journal), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 3 - Test with draw of decades")
    void test3() {
        String timeperiodList = "Decada 2010-20 Decada 2000-10 " ;
        String journal = "journal4";
        assertEquals(timeperiodList, dataBase1.getTimePeriodWithMostArticles(journal),  "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 4 - Test with a 3 draw of decades and multiple years to check")
    void test4() {
        String timeperiodList = "Decada 2000-10 Decada 2010-20 Decada 2020-30 " ;
        String journal = "journal2";
        assertEquals(timeperiodList, dataBase1.getTimePeriodWithMostArticles(journal),  "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 5 - Test a bit more complex with more years to filter")
    void test5() {
        String timeperiodList = "Decada 1990-00 " ;
        String journal = "journal5";
        assertEquals(timeperiodList, dataBase1.getTimePeriodWithMostArticles(journal),  "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }


}
