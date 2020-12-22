package com.example.notesop

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class NoteViewModel(application: Application) : AndroidViewModel(application) {

    abstract val repository: NoteRepository
    val allNotes: LiveData<List<Notes>>

    init{
        val dao = NoteDatabase.getDatabase(application).getNoteDao()
        val repository = NoteRepository(dao)
        allNotes = repository.allNotes
    }

    fun deleteNote(note: Notes) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(note)
    }

    fun insertNote(note: Notes) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(note)
    }

}