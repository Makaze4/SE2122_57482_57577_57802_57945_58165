package org.jabref.ProjectTests.journalTest;

import org.jabref.model.database.BibDatabase;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.field.StandardField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class getTopicRankingTest {

    BibDatabase dataBase1;
    BibDatabase dataBase2;
    BibDatabase dataBase3;
    BibDatabase dataBase4;

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
    void setup() {
        List<BibEntry> entryList1 = new LinkedList<>();
        List<BibEntry> entryList2 = new LinkedList<>();
        List<BibEntry> entryList3 = new LinkedList<>();

        entry1 = new BibEntry();
        entry1.setField(StandardField.TOPIC, "Computer Science");
        entryList1.add(entry1);
        entryList2.add(entry1);

        entry2 = new BibEntry();
        entry2.setField(StandardField.TOPIC, "Music");
        entryList1.add(entry2);
        entryList2.add(entry2);

        entry3 = new BibEntry();
        entry3.setField(StandardField.TOPIC, "Sports");
        entryList1.add(entry3);
        entryList2.add(entry3);

        entry4 = new BibEntry();
        entry4.setField(StandardField.TOPIC, "Music");
        entryList1.add(entry4);
        entryList2.add(entry4);

        entry5 = new BibEntry();
        entry5.setField(StandardField.TOPIC, "Sports");
        entryList1.add(entry5);

        entry6 = new BibEntry();
        entry6.setField(StandardField.TOPIC, "Sports");
        entryList1.add(entry6);

        entry7 = new BibEntry();
        entry7.setField(StandardField.TOPIC, "Arts");
        entryList1.add(entry7);
        entryList2.add(entry7);

        entry8 = new BibEntry();
        entry8.setField(StandardField.TOPIC, "Music");
        entryList1.add(entry8);
        entryList2.add(entry8);

        entry9 = new BibEntry();
        entry9.setField(StandardField.TOPIC, "Sports");
        entryList1.add(entry9);

        entry10 = new BibEntry();
        entry10.setField(StandardField.TOPIC, "Arts");
        entryList1.add(entry10);
        entryList3.add(entry10);

        dataBase1 = new BibDatabase(entryList1);
        dataBase2 = new BibDatabase(entryList2);
        dataBase3 = new BibDatabase(entryList3);
        dataBase4 = new BibDatabase(new LinkedList<>());
    }

    @Test
    @DisplayName("Test 1")
    void test1() {
        List<String> list = new LinkedList<>();
        list.add("Sports");
        list.add("Music");
        list.add("Arts");
        list.add("Computer Science");
        assertEquals(list, dataBase1.getTopicRanking(), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        List<String> list = new LinkedList<>();
        list.add("Music");
        list.add("Computer Science");
        list.add("Sports");
        list.add("Arts");
        assertEquals(list, dataBase2.getTopicRanking(), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        List<String> list = new LinkedList<>();
        list.add("Arts");
        assertEquals(list, dataBase3.getTopicRanking(), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 4")
    void test4() {
        List<String> list = new LinkedList<>();
        assertEquals(list, dataBase4.getTopicRanking(), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }
}
