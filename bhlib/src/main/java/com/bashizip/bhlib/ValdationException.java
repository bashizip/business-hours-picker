package com.bashizip.bhlib;

public class ValdationException extends Exception {

    public ValdationException(String message) {
        super(message);
    }

    public ValdationException(String message,String day){
        this(message.concat("\tfor day: "+day));
    }
}
