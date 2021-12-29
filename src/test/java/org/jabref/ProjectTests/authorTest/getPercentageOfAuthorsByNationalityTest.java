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
    BibDatabase database;

    BibEntry entry1;
    BibEntry entry2;
    BibEntry entry3;

    @BeforeEach
    void setup() {
        List<BibEntry> entryListTest1 = new LinkedList<>();

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

        database = new BibDatabase(entryListTest1);
    }

    @Test
    @DisplayName("Test 1")
    void test1() {
        List<Pair<String, Integer>> percentages = new LinkedList<>();
        percentages.add(new Pair("Portugal", 50));
        percentages.add(new Pair("France", 33));
        percentages.add(new Pair("Spain", 16));
        assertEquals(percentages, database.getPercentageOfAuthorsByNationality(), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }
}
