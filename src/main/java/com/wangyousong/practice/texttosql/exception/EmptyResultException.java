package com.wangyousong.practice.texttosql.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EmptyResultException extends ResponseStatusException {

    public EmptyResultException(String reason) {
        super(HttpStatus.NOT_FOUND, reason);
    }

}