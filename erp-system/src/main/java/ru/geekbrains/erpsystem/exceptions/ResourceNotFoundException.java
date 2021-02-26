package ru.geekbrains.erpsystem.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String serviceMethod, String entity) {
        super(
                "can't " + serviceMethod + " " + entity + " - not found"
        );

    }

}
