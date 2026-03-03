package com.devs.note_app_api.service;

import com.devs.note_app_api.Note;
import com.devs.note_app_api.NoteRepository;
import com.devs.note_app_api.dto.NoteCreateDto;
import com.devs.note_app_api.dto.NoteUpdateDto;
import com.devs.note_app_api.exception.NoteException;
import com.devs.note_app_api.exception.NoteNotFoundException;
import com.devs.note_app_api.mapper.NoteMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    public void saveNote(NoteCreateDto noteCreateDto) {
        try {
            Note noteToSave = NoteMapper.mapNoteToEntityCreate(noteCreateDto);
            noteRepository.save(noteToSave);
        } catch (Exception e) {
            log.error("Erro ao tentar salvar nota - {}", e.getMessage());
            throw new NoteException("Erro ao tentar salvar nota de título -" + noteCreateDto.getTitle());
        }
    }

    public Note updateNote(NoteUpdateDto noteUpdate) {
        try {
            Optional<Note> optNote = noteRepository.findNoteById(noteUpdate.getId());
            if (optNote.isPresent()) {
                Note existentNote = optNote.get();
                existentNote.setTitle(noteUpdate.getTitle());
                existentNote.setContent(noteUpdate.getContent());
                existentNote.setLastModified(LocalDateTime.now());
                return noteRepository.save(existentNote);
            }
        } catch (Exception e) {
            log.error("Erro ao tentar atualizar nota - {}", e.getMessage());
            throw new NoteException("Erro ao tentar atualizar nota -" + noteUpdate.getId());
        }
        throw new NoteNotFoundException("Nota não encontrada para atualização");
    }

    public void deleteNote(Long id) {
        try {
            noteRepository.deleteById(id);
        } catch (Exception e) {
            throw new NoteException("Erro ao tentar deletar nota de id -" + id);
        }
    }

    public List<Note> listNote() {
        try {
            return noteRepository.findAll();
        } catch (Exception e) {
            throw new NoteException("Erro ao tentar listar notas ");
        }

    }
}
