package com.gavrilov.controller;

import com.gavrilov.common.AuthenticationFacade;
import com.gavrilov.model.Note;
import com.gavrilov.model.User;
import com.gavrilov.service.NoteService;
import com.gavrilov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    private AuthenticationFacade authenticationFacade;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserService userService;

    @Autowired
    private NoteService noteService;

    @RequestMapping(value = {"/", "/noteList"}, method = RequestMethod.GET)
    public String authorization(ModelMap modelMap) {
        List<Note> notes = noteService.findNoteForUser(authenticationFacade.getAuthentication().getName());
        modelMap.addAttribute("notes", notes);
        return "noteList";
    }

    @RequestMapping(value = {"/newnote"}, method = RequestMethod.GET)
    public String newNote(ModelMap model) {
        Note note = new Note();
        model.addAttribute("note", note);
        model.addAttribute("edit", false);
        return "note";
    }

    @RequestMapping(value = {"/newnote"}, method = RequestMethod.POST)
    public String saveNote(@Valid Note note, BindingResult result, ModelMap modelMap) {
        if (result.hasErrors()) {
            return "note";
        }

        noteService.saveNote(note, authenticationFacade.getAuthentication().getName());

        return "redirect:/noteList";
    }

    @RequestMapping(value = {"/edit-note-{id}"}, method = RequestMethod.GET)
    private String editNote(@PathVariable Long id, ModelMap modelMap) {
        Note note = noteService.findById(id);
        modelMap.addAttribute("note", note);
        modelMap.addAttribute("edit", true);
        return "note";
    }

    @RequestMapping(value = {"/edit-note-{id}"}, method = RequestMethod.POST)
    private String updateNote(@Valid Note note, BindingResult result, ModelMap modelMap, @PathVariable Long id,
                              @RequestParam("userId") String userId) {

        if (result.hasErrors()) {
            return "note";
        }
        note.setUser(userService.findById(Long.valueOf(userId)));
        noteService.updateNote(note);

        return "redirect:/noteList";
    }

    @RequestMapping(value = {"/delete-note-{id}"}, method = RequestMethod.GET)
    public String deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return "redirect:/noteList";
    }

    @RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
    public String newUser(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @RequestMapping(value = {"/registration"}, method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result, ModelMap modelMap) {

        if (result.hasErrors()) {
            return "registration";
        }

        if (!userService.checkUniqueLogin(user.getLogin())) {
            // Кодировку на страницах надо поменять, чтобы корректно отображалось сообщение
            //FieldError ssoError = new FieldError("user", "login", messageSource.getMessage("non.unique.login", new String[]{user.getLogin()}, Locale.getDefault()));
            FieldError userError = new FieldError("user", "login", "Такой логин уже существует");
            result.addError(userError);
            return "registration";
        }

        user.setEnabled(1);
        userService.saveUser(user);

        return "redirect:/authorization";
    }
}
