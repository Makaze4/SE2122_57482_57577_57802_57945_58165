package org.jabref.model.entry;

import java.util.Random;

public class EntryAuthor {

    private String authorName;

    private String authorNationality;

    public EntryAuthor(String authorName, String authorNationality){
        this.authorName = authorName;
        Random r = new Random();
        if(r.nextInt(2) == 0){
            this.authorNationality = "Portugal";
        }
        else{
            this.authorNationality = "Spain";
        }

    }

    public String getAuthorName(){
        return authorName;
    }

    public String getAuthorNationality(){
       return authorNationality;
    }

    public void setNationality(String authorNationality){
        this.authorNationality = authorNationality;
    }
}
