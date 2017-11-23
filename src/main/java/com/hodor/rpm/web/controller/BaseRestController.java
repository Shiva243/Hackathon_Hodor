package com.hodor.rpm.web.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 *
 */
public class BaseRestController<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseRestController.class);

    HttpHeaders getDefaultResponseHeader() {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }

    @ExceptionHandler({SQLException.class})
    public ResponseEntity<?> databaseError(Exception exception) {
        LOGGER.error("Database error", exception);
        return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({JsonParseException.class, JsonMappingException.class, IOException.class, JsonProcessingException.class})
    public ResponseEntity<?> dataParsingError(Exception exception) {
        LOGGER.error("Json Processing Error", exception);
        return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
