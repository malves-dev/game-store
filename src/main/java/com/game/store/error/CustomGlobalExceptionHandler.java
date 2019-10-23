package com.game.store.error;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    // Error handle for @Valid
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {

        // Get all errors
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

        // List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x
        // -> x.getDefaultMessage())
        // .collect(Collectors.toList());

        // Map<String, Object> body = new LinkedHashMap<>();

        // body.put("timestamp", dateFormat.format(new Date()));
        // body.put("status", status.value());
        // body.put("error", status.getReasonPhrase());
        // body.put("errors", errors);
        // body.put("path", "url");
        // body.put("version", "1.0");

        ErrorDetails body = new ErrorDetails(dateFormat.format(new Date()), status.value(), status.getReasonPhrase(),
                errors, "path", "1.0");

        return new ResponseEntity<>(body, headers, status);
    }

}
