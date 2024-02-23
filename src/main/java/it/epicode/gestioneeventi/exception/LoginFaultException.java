package it.epicode.gestioneeventi.exception;

public class LoginFaultException extends RuntimeException{
    private String message;
    public LoginFaultException(String message){
        super(message);
    }
}
