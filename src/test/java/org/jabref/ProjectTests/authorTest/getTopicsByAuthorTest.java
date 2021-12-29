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

public class getTopicsByAuthorTest {
    BibDatabase dataBase;

    BibEntry entry1;
    BibEntry entry2;
    BibEntry entry3;
    BibEntry entry4;
    BibEntry entry5;
    BibEntry entry6;

    @BeforeEach
    void setup() {
        List<BibEntry> entryList = new LinkedList<>();

        entry1 = new BibEntry();
        entry1.setField(StandardField.AUTHOR, "Joao and Bernardo");
        entry1.setField(StandardField.TOPIC, "Computer Science");
        entryList.add(entry1);

        entry2 = new BibEntry();
        entry2.setField(StandardField.AUTHOR, "Joao");
        entry2.setField(StandardField.TOPIC, "Computer Science");
        entryList.add(entry2);

        entry3 = new BibEntry();
        entry3.setField(StandardField.AUTHOR, "Bernardo and Pedro");
        entry3.setField(StandardField.TOPIC, "Sports");
        entryList.add(entry3);

        entry4 = new BibEntry();
        entry4.setField(StandardField.AUTHOR, "Jorge");
        entry4.setField(StandardField.TOPIC, "Sports");
        entryList.add(entry4);

        entry5 = new BibEntry();
        entry5.setField(StandardField.AUTHOR, "Bernardo");
        entry5.setField(StandardField.TOPIC, "Music");
        entryList.add(entry5);

        entry6 = new BibEntry();
        entry6.setField(StandardField.AUTHOR, "Jorge");
        entry6.setField(StandardField.TOPIC, "Music");
        entryList.add(entry6);

        dataBase = new BibDatabase(entryList);
    }

    @Test
    @DisplayName("Test 1")
    void test1(){
        List<String> topicList = new LinkedList<>();
        topicList.add("Computer Science");
        assertEquals(topicList, dataBase.getTopicsByAuthor("Joao"), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 2")
    void test2(){
        List<String> topicList = new LinkedList<>();
        topicList.add("Computer Science");
        topicList.add("Sports");
        topicList.add("Music");
        assertEquals(topicList, dataBase.getTopicsByAuthor("Bernardo"), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 3")
    void test3(){
        List<String> topicList = new LinkedList<>();
        topicList.add("Sports");
        assertEquals(topicList, dataBase.getTopicsByAuthor("Pedro"), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 4")
    void test4(){
        List<String> topicList = new LinkedList<>();
        topicList.add("Sports");
        topicList.add("Music");
        assertEquals(topicList, dataBase.getTopicsByAuthor("Jorge"), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 5")
    void test5(){
        List<String> topicList = new LinkedList<>();
        assertEquals(topicList, dataBase.getTopicsByAuthor("Jose"), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }
}
