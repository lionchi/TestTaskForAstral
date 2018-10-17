package com.gavrilov.service;

import com.gavrilov.dao.NoteDao;
import com.gavrilov.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("noteService")
@Transactional
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteDao noteDao;

    @Override
    public List<Note> findNoteForUser(String login) {
        return noteDao.findNoteForUser(login);
    }

    @Override
    public void saveNote(Note note, String ownerLogin) {
        noteDao.saveNote(note, ownerLogin);
    }

    @Override
    public Note findById(Long id) {
        return noteDao.findById(id);
    }

    @Override
    public Note updateNote(Note note) {
        return noteDao.update(note);
    }

    @Override
    public void deleteNote(Long id) {
        noteDao.deleteNote(id);
    }
}
