package com.example.notas.repository;

import com.example.notas.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotaRepository extends JpaRepository<Note,Long> {

    void deleteById(Optional<Note> note);
}
