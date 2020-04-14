package com.example.TDS_Store_Back.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProduitIntrouvableException extends RuntimeException {

    public ProduitIntrouvableException(String s) {
        super(s);
    }
}
