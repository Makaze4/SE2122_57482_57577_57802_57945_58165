package org.jabref.model.entry;

public class EntryAuthor {

    private String authorName;

    private String authorNationality;

    public EntryAuthor(String authorName, String authorNationality){
        this.authorName = authorName;
        this.authorNationality = authorNationality;
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
