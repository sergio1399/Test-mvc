package ru.sergio.testmvc.exception;

public class WrongFormatException extends RuntimeException {

    public WrongFormatException(String message) {
        super(message);
    }
}
