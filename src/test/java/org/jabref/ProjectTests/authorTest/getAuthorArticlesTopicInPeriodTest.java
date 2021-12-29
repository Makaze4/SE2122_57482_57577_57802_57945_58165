package org.jabref.ProjectTests.authorTest;

import org.jabref.model.database.BibDatabase;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.field.StandardField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class getAuthorArticlesTopicInPeriodTest {

    BibDatabase dataBase1;
    BibDatabase dataBase2;

    BibEntry entry1;
    BibEntry entry2;
    BibEntry entry3;
    BibEntry entry4;
    BibEntry entry5;
    BibEntry entry6;

    @BeforeEach
    void setUp(){
        List<BibEntry> entryList = new LinkedList<>();

        entry1 = new BibEntry();
        entry1.setField(StandardField.AUTHOR, "Joao");
        entry1.setField(StandardField.TITLE, "Article1");
        entry1.setField(StandardField.TOPIC, "Computer Science");
        entry1.setField(StandardField.YEAR, "2020");
        entryList.add(entry1);

        entry2 = new BibEntry();
        entry2.setField(StandardField.AUTHOR, "Joao");
        entry2.setField(StandardField.TITLE, "Article2");
        entry2.setField(StandardField.TOPIC, "Computer Science");
        entry2.setField(StandardField.YEAR, "2018");
        entryList.add(entry2);

        entry3 = new BibEntry();
        entry3.setField(StandardField.AUTHOR, "Joao");
        entry3.setField(StandardField.TITLE, "Article3");
        entry3.setField(StandardField.TOPIC, "Physics");
        entry3.setField(StandardField.YEAR, "2019");
        entryList.add(entry3);

        entry4 = new BibEntry();
        entry4.setField(StandardField.AUTHOR, "Joao");
        entry4.setField(StandardField.TITLE, "Article4");
        entry4.setField(StandardField.TOPIC, "Computer Science");
        entry4.setField(StandardField.YEAR, "2014");
        entryList.add(entry4);

        entry5 = new BibEntry();
        entry5.setField(StandardField.AUTHOR, "Joao");
        entry5.setField(StandardField.TITLE, "Article5");
        entry5.setField(StandardField.TOPIC, "Mathematics");
        entry5.setField(StandardField.YEAR, "2012");
        entryList.add(entry5);

        entry6 = new BibEntry();
        entry6.setField(StandardField.AUTHOR, "Miguel");
        entry6.setField(StandardField.TITLE, "Article6");
        entry6.setField(StandardField.TOPIC, "Computer Science");
        entry6.setField(StandardField.YEAR, "2018");
        entryList.add(entry6);


        dataBase1 = new BibDatabase(entryList);
        dataBase2 = new BibDatabase();
    }

    @Test
    @DisplayName("Test 1")
    void test1(){
        List<String> journalList = new LinkedList<>();
        journalList.add("Article1");
        journalList.add("Article2");
        assertEquals(journalList, dataBase1.getAuthorArticlesTopicInPeriod("Joao", "Computer Science", 2018, 2020), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 2")
    void test2(){
        List<String> journalList = new LinkedList<>();
        journalList.add("Article1");
        journalList.add("Article2");
        journalList.add("Article4");
        assertEquals(journalList, dataBase1.getAuthorArticlesTopicInPeriod("Joao", "Computer Science", 2014, 2020), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 3")
    void test3(){
        List<String> journalList = new LinkedList<>();
        journalList.add("Article6");
        assertEquals(journalList, dataBase1.getAuthorArticlesTopicInPeriod("Miguel", "Computer Science", 2014, 2020), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 4")
    void test4(){
        List<String> journalList = new LinkedList<>();
        assertEquals(journalList, dataBase1.getAuthorArticlesTopicInPeriod("Miguel", "Computer Science", 2019, 2020), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 5")
    void test5(){
        List<String> journalList = new LinkedList<>();
        assertEquals(journalList, dataBase2.getAuthorArticlesTopicInPeriod("Miguel", "Computer Science", 2019, 2020), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }



}
