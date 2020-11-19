package com.app.controller;

import com.app.model.Note;
import com.app.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class NotesController {

    private NotesRepository notesRepository;

    @Autowired
    public NotesController(final NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    @PostMapping(value = "/notes")
    public ResponseEntity<Note> createNote(final @RequestBody Note note) throws URISyntaxException {

        System.out.println(String.format("Trying to send this: %s", note.toString()));

        final int randomID = ThreadLocalRandom.current().nextInt(1, 10_000);
        note.setId(randomID);
        final Note noteSaved = notesRepository.save(note);

        System.out.println(noteSaved);

        return ResponseEntity.created(new URI(String.format("/notes/%d", noteSaved.getId()))).body(noteSaved);
    }

    @GetMapping("/notes")
    public ResponseEntity<Collection<Note>> getAllNotes() {
        return ResponseEntity.ok(notesRepository.findAll());
    }

    @GetMapping("/notes/{id}")
    public ResponseEntity<Note> getNote(final @PathVariable Integer id) {
        return notesRepository
                .findById(id)
                .map(note -> ResponseEntity.ok(note))
                .orElse(ResponseEntity.notFound().build())
                ;
    }

}
