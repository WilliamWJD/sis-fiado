package com.wjd.sisfiado.services.exceptions;

public class ResourceNotFoundExceptionApp extends RuntimeException{
    public ResourceNotFoundExceptionApp(String msg){
        super(msg);
    }
}
