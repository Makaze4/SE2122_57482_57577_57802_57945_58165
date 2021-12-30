package org.jabref.ProjectTests.authorTest;

import org.antlr.v4.runtime.misc.Triple;
import org.jabref.model.database.BibDatabase;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.EntryAuthor;
import org.jabref.model.entry.field.StandardField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class getRelationsTest {

    BibDatabase dataBase;
    BibDatabase dataBase2;
    BibDatabase dataBase3;
    BibDatabase database4;

    BibEntry entry1;
    BibEntry entry2;
    BibEntry entry3;
    BibEntry entry4;
    BibEntry entry5;

    @BeforeEach
    void setUp(){
        List<BibEntry> entryList = new LinkedList<>();

        entry1 = new BibEntry();
        entry1.setField(StandardField.AUTHOR, "Joao");
        for(EntryAuthor a: entry1.getAuthors()){
            if(a.getAuthorName().equals("Joao")){
                a.setNationality("Portugal");
            }
        }
        entryList.add(entry1);


        entry2 = new BibEntry();
        entry2.setField(StandardField.AUTHOR, "Joao and Pedro");
        for(EntryAuthor a: entry2.getAuthors()){
            if(a.getAuthorName().equals("Joao")){
                a.setNationality("Portugal");
            }
            else if(a.getAuthorName().equals("Pedro")){
                a.setNationality("Portugal");
            }
        }
        entryList.add(entry2);


        entry3 = new BibEntry();
        entry3.setField(StandardField.AUTHOR, "Joao and Tim");
        for(EntryAuthor a: entry3.getAuthors()){
            if(a.getAuthorName().equals("Joao")){
                a.setNationality("Portugal");
            }
            else if(a.getAuthorName().equals("Tim")){
                a.setNationality("Spain");
            }
        }
        entryList.add(entry3);

        entry4 = new BibEntry();
        entry4.setField(StandardField.AUTHOR, "Miguel and Tim");
        for(EntryAuthor a: entry4.getAuthors()){
            if(a.getAuthorName().equals("Miguel")){
                a.setNationality("France");
            }
            else if(a.getAuthorName().equals("Tim")){
                a.setNationality("Spain");
            }
        }
        entryList.add(entry4);

        entry5 = new BibEntry();
        entry5.setField(StandardField.AUTHOR, "Miguel and Pedro");
        for(EntryAuthor a: entry5.getAuthors()){
            if(a.getAuthorName().equals("Miguel")){
                a.setNationality("France");
            }
            else if(a.getAuthorName().equals("Pedro")){
                a.setNationality("Portugal");
            }
        }
        entryList.add(entry5);



        dataBase = new BibDatabase(entryList);


        List<BibEntry> entryList2 = new LinkedList<>();
        entryList2.add(entry1);
        entryList2.add(entry2);

        dataBase2 = new BibDatabase(entryList2);


        List<BibEntry> entryList3 = new LinkedList<>();

        entryList3.add(entry2);
        entryList3.add(entry3);
        entryList3.add(entry4);

        dataBase3 = new BibDatabase(entryList3);


        List<BibEntry> entryList4 = new LinkedList<>();
        database4 = new BibDatabase(entryList4);

    }

    @Test
    @DisplayName("Test 1")
    void test1(){
        Map<Integer, Triple<String, String, List<Integer>>> sol = new HashMap<>();

        List<Integer> listA = new LinkedList<>();
        listA.add(2);
        listA.add(3);
        sol.put(1, new Triple<>("Portugal", "Joao", listA));

        List<Integer> listB = new LinkedList<>();
        listB.add(1);
        listB.add(4);
        sol.put(2, new Triple<>("Portugal", "Pedro", listB));

        List<Integer> listC = new LinkedList<>();
        listC.add(1);
        listC.add(4);
        sol.put(3, new Triple<>("Spain", "Tim", listC));

        List<Integer> listD = new LinkedList<>();
        listD.add(3);
        listD.add(2);
        sol.put(4, new Triple<>("France", "Miguel", listD));

        assertEquals(sol, dataBase.getRelations(), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 2")
    void test2(){
        Map<Integer, Triple<String, String, List<Integer>>> sol = new HashMap<>();

        List<Integer> listA = new LinkedList<>();
        listA.add(2);
        sol.put(1, new Triple<>("Portugal", "Joao", listA));

        List<Integer> listB = new LinkedList<>();
        listB.add(1);
        sol.put(2, new Triple<>("Portugal", "Pedro", listB));


        assertEquals(sol, dataBase2.getRelations(), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 3")
    void test3(){
        Map<Integer, Triple<String, String, List<Integer>>> sol = new HashMap<>();

        List<Integer> listA = new LinkedList<>();
        listA.add(2);
        listA.add(3);
        sol.put(1, new Triple<>("Portugal", "Joao", listA));

        List<Integer> listB = new LinkedList<>();
        listB.add(1);
        sol.put(2, new Triple<>("Portugal", "Pedro", listB));

        List<Integer> listC = new LinkedList<>();
        listC.add(1);
        listC.add(4);
        sol.put(3, new Triple<>("Spain", "Tim", listC));

        List<Integer> listD = new LinkedList<>();
        listD.add(3);
        sol.put(4, new Triple<>("France", "Miguel", listD));

        assertEquals(sol, dataBase3.getRelations(), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }

    @Test
    @DisplayName("Test 4")
    void test4(){
        Map<Integer, Triple<String, String, List<Integer>>> sol = new HashMap<>();

        assertEquals(sol, database4.getRelations(), "-----TEST FAILED----------TEST FAILED----------TEST FAILED-----");
    }


}
