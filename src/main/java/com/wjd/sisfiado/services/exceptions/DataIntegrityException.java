package com.wjd.sisfiado.services.exceptions;

import org.springframework.boot.CommandLineRunner;

public class DataIntegrityException extends RuntimeException {

    public DataIntegrityException(String msg){
        super(msg);
    }
}
