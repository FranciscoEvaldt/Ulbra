package com.example.notas.controller;

import com.example.notas.model.Note;
import com.example.notas.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class NotaController {

    @Autowired
    NotaRepository notaRepository;

//recuperar todas as notas
    @GetMapping("/notes")
    public List<Note> getAllNotes(){
        return notaRepository.findAll();
    }

    @GetMapping("/notes/{id}")
    public Optional<Note> getById(@PathVariable(value = "id") Long id){
        return notaRepository.findById(id);
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id")Long id){
        Optional<Note> note = notaRepository.findById(id);
        notaRepository.deleteById(note);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/notes/{id}")
    public Note updateNote(@PathVariable(value = "id")Long id,
                          @Valid @RequestBody Note noteDetails){
        Optional<Note> note = notaRepository.findById(id);
        note.get().setTitle(noteDetails.getTitle());
        note.get().setContent(noteDetails.getContent());
        Note noteResponse = notaRepository.save(note.get());
        return noteResponse;
    }

    @PostMapping("/notes")
    public Note createNote(@Valid @RequestBody Note Nota){
        return notaRepository.save(Nota);
    }
}
