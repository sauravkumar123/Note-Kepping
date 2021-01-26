package com.example.notekepping;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Notes_Table")
public class Note{

    @PrimaryKey(autoGenerate = true)
    private  int id;

    private String title;
    private String discriptions;
    @ColumnInfo(name = "Priority_Column")
    private int prios;

    public Note(String title, String discriptions, int prios) {
        this.title = title;
        this.discriptions = discriptions;
        this.prios = prios;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDiscriptions() {

        return discriptions;
    }

    public int getPrios() {
        return prios;
    }
}
