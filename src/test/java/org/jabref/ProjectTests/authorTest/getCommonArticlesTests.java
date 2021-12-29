
package org.jabref.ProjectTests.authorTest;

import org.jabref.model.database.BibDatabase;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.field.StandardField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
    BibEntry entry10;

    @BeforeEach
    void setUp() {
        List<BibEntry> entryList = new LinkedList<>();

        entry1 = new BibEntry();
        entry1.setField(StandardField.AUTHOR, "Joao and Tim");
        entry1.setField(StandardField.TITLE, "title1");
        entryList.add(entry1);

        entry2 = new BibEntry();
        entry2.setField(StandardField.AUTHOR, "Manel");
        entry2.setField(StandardField.TITLE, "title2");
        entryList.add(entry2);

        entry3 = new BibEntry();
        entry3.setField(StandardField.AUTHOR, "Joao");
        entry3.setField(StandardField.TITLE, "title3");
        entryList.add(entry3);

        entry4 = new BibEntry();
        entry4.setField(StandardField.AUTHOR, "Tim and Alexandre and Miguel");
        entry4.setField(StandardField.TITLE, "title4");
        entryList.add(entry4);

        entry5 = new BibEntry();
        entry5.setField(StandardField.AUTHOR, "Miguel");
        entry5.setField(StandardField.TITLE, "title5");
        entryList.add(entry5);

        entry6 = new BibEntry();
        entry6.setField(StandardField.AUTHOR, "Miguel");
        entry6.setField(StandardField.TITLE, "title6");
        entryList.add(entry6);

        entry7 = new BibEntry();
        entry7.setField(StandardField.AUTHOR, "Alexandre and Joao and Miguel");
        entry7.setField(StandardField.TITLE, "title7");
        entryList.add(entry7);

        entry8 = new BibEntry();
        entry8.setField(StandardField.AUTHOR, "Manel and Joao");
        entry8.setField(StandardField.TITLE, "title8");
        entryList.add(entry8);

        entry9 = new BibEntry();
        entry9.setField(StandardField.AUTHOR, "Virtudes");
        entry9.setField(StandardField.TITLE, "title2");
        entryList.add(entry9);

        entry10 = new BibEntry();
        entry10.setField(StandardField.AUTHOR, "Miguel and Alexandre");
        entry10.setField(StandardField.TITLE, "title10");
        entryList.add(entry10);

        dataBase1 = new BibDatabase(entryList);
        dataBase2 = new BibDatabase();
    }

    @Test
    @DisplayName("Test 1 - Simple Test")
    void test1() {
        Map<String, List<String>> expected = new HashMap<>();
        List<String> articles = new LinkedList<>();
        articles.add("title8");
        expected.put("Joao",articles);
        String author = "Manel";
        assertEquals(expected,dataBase1.getCommonArticles(author), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 2 - Test when the author hasn't worked with no one")
    void test2() {
        Map<String, List<String>> expected = new HashMap<>();
        List<String> articles = new LinkedList<>();
        String author = "Virtudes";
        assertEquals(expected,dataBase1.getCommonArticles(author), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 3 - Extensive test")
    void test3() {
        Map<String, List<String>> expected = new HashMap<>();
        List<String> articles = new LinkedList<>();
        articles.add("title7");
        expected.put("Alexandre",articles);

        articles = new LinkedList<>();
        articles.add("title1");
        expected.put("Tim",articles);

        articles = new LinkedList<>();
        articles.add("title8");
        expected.put("Manel",articles);

        articles = new LinkedList<>();
        articles.add("title7");
        expected.put("Miguel",articles);

        String author = "Joao";
        assertEquals(expected,dataBase1.getCommonArticles(author), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 4 - Test when the same author work together multiple times")
    void test4() {
        Map<String, List<String>> expected = new HashMap<>();
        List<String> articles = new LinkedList<>();
        articles.add("title7");
        expected.put("Joao",articles);

        articles = new LinkedList<>();
        articles.add("title4");
        articles.add("title7");
        articles.add("title10");
        expected.put("Alexandre",articles);

        articles = new LinkedList<>();
        articles.add("title4");
        expected.put("Tim",articles);

        String author = "Miguel";
        assertEquals(expected,dataBase1.getCommonArticles(author), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 1 - Test with a null database")
    void test5() {
        Map<String, List<String>> expected = new HashMap<>();
        List<String> articles = new LinkedList<>();
        String author = "Manel";
        assertEquals(expected,dataBase2.getCommonArticles(author), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }



}
