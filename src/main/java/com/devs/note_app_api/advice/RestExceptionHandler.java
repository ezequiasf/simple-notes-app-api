package com.devs.note_app_api.advice;

import com.devs.note_app_api.dto.ErrorResponse;
import com.devs.note_app_api.dto.ErrorType;
import com.devs.note_app_api.exception.NoteException;
import com.devs.note_app_api.exception.NoteNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(NoteException.class)
    public ResponseEntity<ErrorResponse> handleNoteException(NoteException noteException) {
        return ResponseEntity.internalServerError().body(new ErrorResponse(ErrorType.INTERNAL, noteException.getMessage()));
    }

    @ExceptionHandler(NoteNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoteNotFoundException(NoteNotFoundException noteException) {
        return ResponseEntity.badRequest().body(new ErrorResponse(ErrorType.ITEM_INEXISTENT, noteException.getMessage()));
    }
}
