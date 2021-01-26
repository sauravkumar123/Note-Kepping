package com.example.notekepping;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface NoteDao {

    @Insert
    void insert(Note note);

    @Delete
    void delete(Note note);

    @Update
    void update(Note note);


    @Query("DELETE FROM notes_table ")
    void delall();

    @Query("SELECT * FROM NOTES_TABLE ORDER BY Priority_Column DESC")
    LiveData<List<Note>> getallnotes();


}
