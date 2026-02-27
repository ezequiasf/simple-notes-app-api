package com.devs.note_app_api.mapper;

import com.devs.note_app_api.Note;
import com.devs.note_app_api.dto.NoteCreateDto;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;

@UtilityClass
public class NoteMapper {

    public Note mapNoteToEntityCreate(NoteCreateDto noteCreateDto) {
        Note newNote = new Note();
        newNote.setTitle(noteCreateDto.getTitle());
        newNote.setContent(noteCreateDto.getContent());
        newNote.setCreatedAt(LocalDateTime.now());
        newNote.setLastModified(LocalDateTime.now());

        return newNote;
    }
}
