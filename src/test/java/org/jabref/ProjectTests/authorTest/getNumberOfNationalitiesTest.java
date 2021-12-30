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

public class getNumberOfNationalitiesTest {
    BibDatabase database1;
    BibDatabase database2;
    BibDatabase database3;

    BibEntry entry1;
    BibEntry entry2;
    BibEntry entry3;
    BibEntry entry4;
    BibEntry entry5;

    @BeforeEach
    void setup() {
        List<BibEntry> entryList1 = new LinkedList<>();
        List<BibEntry> entryList2 = new LinkedList<>();
        List<BibEntry> entryList3 = new LinkedList<>();

        entry1 = new BibEntry();
        entry1.setField(StandardField.AUTHOR, "Author1");
        entry1.getAuthors().get(0).setNationality("Portugal");
        entryList1.add(entry1);

        entry2 = new BibEntry();
        entry2.setField(StandardField.AUTHOR, "Author2");
        entry2.getAuthors().get(0).setNationality("Espanha");
        entryList1.add(entry2);

        entry3 = new BibEntry();
        entry3.setField(StandardField.AUTHOR, "Author1 and Author2");
        entry3.getAuthors().get(0).setNationality("Portugal");
        entry3.getAuthors().get(1).setNationality("Espanha");
        entryList2.add(entry3);

        entry4 = new BibEntry();
        entry4.setField(StandardField.AUTHOR, "Author2 and Author3");
        entry4.getAuthors().get(0).setNationality("Espanha");
        entry4.getAuthors().get(1).setNationality("Franca");
        entryList2.add(entry4);

        entry5 = new BibEntry();
        entry5.setField(StandardField.AUTHOR, "Author1 and Author2 and Author3");
        entry5.getAuthors().get(0).setNationality("Portugal");
        entry5.getAuthors().get(1).setNationality("Espanha");
        entry5.getAuthors().get(2).setNationality("Franca");
        entryList3.add(entry5);

        database1 = new BibDatabase(entryList1);
        database2 = new BibDatabase(entryList2);
        database3 = new BibDatabase(entryList3);
    }

    @Test
    @DisplayName("Test 1")
    void test1() {
        List<String> list = new LinkedList<>();
        assertEquals(list, database1.getNumberOfNationalities("Author1"), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        List<String> list = new LinkedList<>();
        list.add("Portugal");
        list.add("Franca");
        assertEquals(list, database2.getNumberOfNationalities("Author2"), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        List<String> list = new LinkedList<>();
        list.add("Portugal");
        list.add("Franca");
        assertEquals(list, database3.getNumberOfNationalities("Author2"), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }
}
