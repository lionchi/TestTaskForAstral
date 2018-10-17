package com.gavrilov.dao;

import com.gavrilov.model.Note;
import com.gavrilov.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("noteDao")
public class NoteDaoImpl extends AbstractDao<Note> implements NoteDao {
    @Override
    public List<Note> findNoteForUser(String login) {
        return entityManager.createQuery("select n from Note as n where n.user.login = :login", Note.class)
                .setParameter("login", login)
                .getResultList();
    }

    @Override
    public void saveNote(Note note, String ownerLogin) {
        User owner = entityManager.createQuery("select u from User as u where u.login = :ownerLogin", User.class)
                .setParameter("ownerLogin", ownerLogin)
                .getSingleResult();
        note.setUser(owner);
        create(note);
    }

    @Override
    public void deleteNote(Long id) {
        deleteById(id);
    }
}
