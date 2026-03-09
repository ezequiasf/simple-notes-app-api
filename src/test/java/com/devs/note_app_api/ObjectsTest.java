package com.devs.note_app_api;

import com.devs.note_app_api.dto.NoteCreateDto;
import com.devs.note_app_api.dto.NoteUpdateDto;
import com.devs.note_app_api.entity.Note;

import java.time.LocalDateTime;

public class ObjectsTest {


    public static NoteCreateDto noteCreateDto(){
        NoteCreateDto noteCreateDto = new NoteCreateDto();
        noteCreateDto.setTitle("teste");
        noteCreateDto.setContent("teste2");
        return noteCreateDto;
    }
    public static Note note(){
        Note note = new Note();
        note.setTitle("testar");
        note.setContent("testar3");
        note.setCreatedAt(LocalDateTime.now());
        note.setLastModified(LocalDateTime.now());
        return note;

    }

    public static NoteUpdateDto noteUpdateDto(){
        NoteUpdateDto noteUpdateDto = new NoteUpdateDto();
        noteUpdateDto.setId(1L);
        noteUpdateDto.setTitle("testando");
        noteUpdateDto.setContent("testando4");
        return noteUpdateDto;
    }
}
