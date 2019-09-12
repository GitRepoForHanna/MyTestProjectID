package utils.exceptions;

public class ScenarioException extends RuntimeException{

    public ScenarioException(String exMessage) {
        super(exMessage + "\nIn Thread: " + Thread.currentThread().getName());
    }

}
