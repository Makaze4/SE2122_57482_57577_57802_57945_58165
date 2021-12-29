package org.jabref.model.entry;

import java.util.Random;

public class EntryAuthor {

    private String authorName;

    private String authorNationality;

    public EntryAuthor(String authorName, String authorNationality){
        this.authorName = authorName;
        this.authorNationality = authorNationality;
    }

    public EntryAuthor(String authorName){
        System.out.println(authorName + " criado");
        this.authorName = authorName;
        this.authorNationality = "";
    }

    public String getAuthorName(){
        System.out.println(authorName + " - " + authorNationality);
        return authorName;
    }

    public String getAuthorNationality(){
        System.out.println(authorName + " - " + authorNationality);
       return authorNationality;
    }

    public void setNationality(String authorNationality){
        System.out.println("------updated------");
        this.authorNationality = authorNationality;
    }
}
