package com.wangyousong.practice.texttosql.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidQueryException extends ResponseStatusException {

    public InvalidQueryException(String reason) {
        super(HttpStatus.BAD_REQUEST, reason);
    }

}