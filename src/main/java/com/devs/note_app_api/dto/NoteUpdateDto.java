package com.devs.note_app_api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoteUpdateDto extends NoteCreateDto {
    private Long id;
}
