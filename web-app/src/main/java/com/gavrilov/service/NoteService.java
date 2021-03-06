package com.gavrilov.service;

import com.gavrilov.model.Note;

import java.util.List;

public interface NoteService {
    List<Note> findNoteForUser(String login);

    void saveNote (Note note, String ownerLogin);

    Note findById (Long id);

    Note updateNote (Note note);

    void deleteNote (Long id);
}
