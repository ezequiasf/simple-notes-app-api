package com.devs.note_app_api.service;

import com.devs.note_app_api.Note;
import com.devs.note_app_api.NoteRepository;
import com.devs.note_app_api.dto.NoteCreateDto;
import com.devs.note_app_api.exception.NoteException;
import com.devs.note_app_api.mapper.NoteMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
}
