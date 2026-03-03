package com.devs.note_app_api.controller;

import com.devs.note_app_api.Note;
import com.devs.note_app_api.dto.NoteCreateDto;
import com.devs.note_app_api.dto.NoteUpdateDto;
import com.devs.note_app_api.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping ("/salvar")
    public void saveNote(@RequestBody NoteCreateDto noteCreateDto) {
        noteService.saveNote(noteCreateDto);
    }

    @DeleteMapping("/deletar/{id}")
    public void deleteNote(@PathVariable Long id){
        noteService.deleteNote(id);
    }

    @GetMapping("/listar")
    public List<Note> listNote() {
        
        return noteService.listNote();
    }

    @PutMapping("/atualizar")
    public void updateNote(@RequestBody NoteUpdateDto noteUpdateDto){
        noteService.updateNote(noteUpdateDto);
    }

}
