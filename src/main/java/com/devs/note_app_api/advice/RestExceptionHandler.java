package com.devs.note_app_api.advice;

import com.devs.note_app_api.dto.ErrorResponse;
import com.devs.note_app_api.dto.TipoErro;
import com.devs.note_app_api.exception.NoteException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(NoteException.class)
    public ResponseEntity<ErrorResponse> handleNoteException(NoteException noteException) {
        return ResponseEntity.internalServerError().body(new ErrorResponse(TipoErro.INTERNO, noteException.getMessage()));
    }
}
