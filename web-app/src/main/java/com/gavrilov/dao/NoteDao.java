package com.gavrilov.dao;

import com.gavrilov.model.Note;

import java.util.List;

public interface NoteDao {
    List<Note> findNoteForUser (String login);

    void saveNote (Note note, String ownerLogin);

    Note findById (Long id);

    Note update (Note note);

    void deleteNote (Long id);
}
