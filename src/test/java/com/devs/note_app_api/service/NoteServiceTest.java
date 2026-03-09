package com.devs.note_app_api.service;

import com.devs.note_app_api.entity.Note;
import com.devs.note_app_api.NoteRepository;
import com.devs.note_app_api.ObjectsTest;
import com.devs.note_app_api.dto.NoteCreateDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class NoteServiceTest {
    @Mock
    NoteRepository noteRepository;

    @InjectMocks
    NoteService noteService;

    @Test
    public void deveSalvarNota() {
        NoteCreateDto noteCreateDto = ObjectsTest.noteCreateDto();

        Mockito.when(noteRepository.save(Mockito.any())).thenReturn(new Note());

        noteService.saveNote(noteCreateDto);

        Mockito.verify(noteRepository, Mockito.times(1)).save(Mockito.any());

    }

    @Test
    public void deveDeletarNota() {
        Mockito.doNothing().when(noteRepository).deleteById(1L);

        noteService.deleteNote(1L);

        Mockito.verify(noteRepository, Mockito.times(1)).deleteById(1L);
    }

    @Test
    public void deveListarNotas() {
        Mockito.when(noteRepository.findAll()).thenReturn(List.of(ObjectsTest.note()));

        List<Note> notes = noteService.listNote();

        Assertions.assertEquals("testar", notes.get(0).getTitle());

        Assertions.assertEquals("testar3", notes.get(0).getContent());

        Assertions.assertNotNull(notes.get(0).getCreatedAt());
    }

    @Test
    public void deveAtualizarNotas(){
        Mockito.when(noteRepository.findNoteById(1L)).thenReturn(Optional.of(ObjectsTest.note()));

        Mockito.when(noteRepository.save(Mockito.any())).thenReturn(new Note());

        noteService.updateNote(ObjectsTest.noteUpdateDto());

        Mockito.verify(noteRepository, Mockito.times(1)).findNoteById(1L);
        Mockito.verify(noteRepository, Mockito.times(1)).save(Mockito.any());
    }
}
