package org.jabref.ProjectTests.authorTest;

import org.jabref.model.database.BibDatabase;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.field.StandardField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import javafx.util.Pair;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class getPercentageOfAuthorsByNationalityTest {
    BibDatabase database1;
    BibDatabase database2;
    BibDatabase database3;

    BibEntry entry1;
    BibEntry entry2;
    BibEntry entry3;
    BibEntry entry4;

    @BeforeEach
    void setup() {
        List<BibEntry> entryListTest1 = new LinkedList<>();
        List<BibEntry> entryListTest2 = new LinkedList<>();
        List<BibEntry> entryListTest3 = new LinkedList<>();

        entry1 = new BibEntry();
        entry1.setField(StandardField.AUTHOR, "Joao and Pedro");
        entry1.getAuthors().get(0).setNationality("Portugal");
        entry1.getAuthors().get(1).setNationality("Portugal");
        entryListTest1.add(entry1);

        entry2 = new BibEntry();
        entry2.setField(StandardField.AUTHOR, "Diogo and Francisco and Alexandre");
        entry2.getAuthors().get(0).setNationality("Spain");
        entry2.getAuthors().get(1).setNationality("France");
        entry2.getAuthors().get(2).setNationality("France");
        entryListTest1.add(entry2);

        entry3 = new BibEntry();
        entry3.setField(StandardField.AUTHOR, "Manuel");
        entry3.getAuthors().get(0).setNationality("Portugal");
        entryListTest1.add(entry3);

        database1 = new BibDatabase(entryListTest1);

        entry4 = new BibEntry();
        entry4.setField(StandardField.AUTHOR, "Manuel and Diogo and Joao");
        entry4.getAuthors().get(0).setNationality("Portugal");
        entry4.getAuthors().get(1).setNationality("Spain");
        entry4.getAuthors().get(2).setNationality("Portugal");
        entryListTest1.add(entry4);

        entryListTest2.add(entry1);
        entryListTest2.add(entry2);
        entryListTest2.add(entry3);
        entryListTest2.add(entry4);

        database2 = new BibDatabase(entryListTest2);
        database3 = new BibDatabase(entryListTest3);
    }

    @Test
    @DisplayName("Test 1")
    void test1() {
        List<Pair<String, Integer>> percentages = new LinkedList<>();
        percentages.add(new Pair("Portugal", 50));
        percentages.add(new Pair("France", 33));
        percentages.add(new Pair("Spain", 16));
        assertEquals(percentages, database1.getPercentageOfAuthorsByNationality(), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        List<Pair<String, Integer>> percentages = new LinkedList<>();
        percentages.add(new Pair("Portugal", 50));
        percentages.add(new Pair("France", 33));
        percentages.add(new Pair("Spain", 16));
        assertEquals(percentages, database2.getPercentageOfAuthorsByNationality(), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        List<Pair<String, Integer>> percentages = new LinkedList<>();
        assertEquals(percentages, database3.getPercentageOfAuthorsByNationality(), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }
}
