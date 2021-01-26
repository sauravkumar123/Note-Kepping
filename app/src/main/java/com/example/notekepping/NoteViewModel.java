package com.example.notekepping;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    private Repository repository;
    private LiveData<List<Note>> allnotes;
    public NoteViewModel(@NonNull Application application) {
        super(application);
        repository=new Repository(application);
        allnotes=repository.getAllnotes();

    }

    public void insert(Note note)
    {
        repository.insert(note);
    }
    public void delete(Note note)
    {

        repository.delete(note);
    }
    public void update(Note note)
    {
        repository.update(note);
    }
    public void deleteAll()
    {
        repository.deletAllNotes();
    }
    public LiveData<List<Note>> getAllnotes()
    {
        return allnotes;
    }
}
