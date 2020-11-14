package com.example.mynote

import androidx.lifecycle.LiveData

class NoteRepository(val noteDao: NoteDao) {

    val getNotes: LiveData<List<Note>> = noteDao.getAllNords()

    suspend fun deleteALl(){
        noteDao.deleteAll()
    }

    suspend fun insert(note: Note){
        noteDao.insert(note)
    }

    suspend fun delete(note: Note){
        noteDao.delete(note)
    }
}

