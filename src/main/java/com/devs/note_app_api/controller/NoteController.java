package com.devs.note_app_api.controller;

import com.devs.note_app_api.entity.Note;
import com.devs.note_app_api.dto.NoteCreateDto;
import com.devs.note_app_api.dto.NoteUpdateDto;
import com.devs.note_app_api.service.NoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note")
@RequiredArgsConstructor
@Tag(name = "Notas", description = "Endpoints para gerenciamento de notas")
public class NoteController {

    private final NoteService noteService;

    @Operation(summary = "Salva uma nota ", description = "Recebe um DTO para salvar os dados de uma nota no banco.")
    @PostMapping ("/salvar")
    public void saveNote(@RequestBody NoteCreateDto noteCreateDto) {
        noteService.saveNote(noteCreateDto);
    }

    @Operation(summary = "Deleta uma nota existente", description = "Recebe um ID  para deletar uma nota no banco.")
    @DeleteMapping("/deletar/{id}")
    public void deleteNote(@PathVariable Long id){
        noteService.deleteNote(id);
    }

    @Operation(summary = "Lista as notas existentes", description = "Lista as notas existentes")
    @GetMapping("/listar")
    public List<Note> listNote() {
        return noteService.listNote();
    }

    @Operation(summary = "Atualiza uma nota existente", description = "Recebe um ID e um DTO para modificar os dados de uma nota no banco.")
    @PutMapping("/atualizar")
    public void updateNote(@RequestBody NoteUpdateDto noteUpdateDto){
        noteService.updateNote(noteUpdateDto);
    }

}
