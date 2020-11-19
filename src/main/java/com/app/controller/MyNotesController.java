package com.app.controller;

import com.app.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyNotesController {

    private NotesRepository notesRepository;

    @Autowired
    public MyNotesController(final NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    @GetMapping("/mynotes")
    public String myNotes(final Model model) {
        model.addAttribute("notes", notesRepository.findAll());
        return "notes";
    }

}
