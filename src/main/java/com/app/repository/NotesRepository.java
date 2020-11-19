package com.app.repository;

import com.app.model.Note;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class NotesRepository {

    private final Map<Integer, Note> db;

    public NotesRepository() {
        this.db = new HashMap<>();
    }

    public Note save(final Note note) {
        final Integer id = note.getId();
        this.db.put(id, note);
        return this.db.getOrDefault(id, note);
    }

    public Optional<Note> findById(final int id) {
        return this.db.containsKey(id) ? Optional.of(this.db.get(id)) : Optional.empty();
    }

    public Collection<Note> findAll() {
        return this.db.values();
    }

}
