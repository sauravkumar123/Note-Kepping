package com.example.notekepping;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Repository {

    private NoteDao noteDao;
    private LiveData<List<Note>> allnotes;


    public Repository(Application application)
    {
        NoteDatabase noteDatabase=NoteDatabase.getInstance(application);
        noteDao=noteDatabase.noteDao();
        allnotes=noteDao.getallnotes();

    }

    public void insert(Note note)
    {
            new InsertNoteAsynctask(noteDao).execute(note);
    }

    public void update(Note note)
    {
        new updateAsync(noteDao).execute(note);

    }

    public void delete(Note note)

    {
        new DeleteNoteAsynctask(noteDao).execute(note);
    }

    public void deletAllNotes()
    {
        new deletAllasync(noteDao).execute();

    }
    public LiveData<List<Note>> getAllnotes()
    {
        return allnotes;
    }

    private static class InsertNoteAsynctask extends AsyncTask<Note,Void,Void>
    {
        private NoteDao noteDao;

        public InsertNoteAsynctask(NoteDao noteDao) {
            this.noteDao=noteDao;

        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insert(notes[0]);
            return null;
        }
    }
    private static class updateAsync extends AsyncTask<Note,Void,Void>
    {

        private NoteDao noteDao;

        public updateAsync(NoteDao noteDao) {
            this.noteDao=noteDao;

        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.update(notes[0]);
            return null;
        }
    }
    private static class DeleteNoteAsynctask extends AsyncTask<Note,Void,Void>
    {
        private NoteDao noteDao;

        public DeleteNoteAsynctask(NoteDao noteDao) {
            this.noteDao=noteDao;

        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.delete(notes[0]);
            return null;
        }
    }

    private static class deletAllasync extends AsyncTask<Void ,Void,Void>
    {
        private NoteDao noteDao;


        public deletAllasync(NoteDao noteDao) {
            this.noteDao=noteDao;

        }

        @Override
        protected Void doInBackground(Void... notes) {
            noteDao.delall();
            return null;
        }
    }



}
