package com.example.notesop

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    val allNotes: LiveData<List<Notes>>

    init{
        val dao = NoteDatabase.getDatabase(application).getNoteDao()
        val repository = NoteRepository(dao)
        allNotes = repository.allNotes


    }

}