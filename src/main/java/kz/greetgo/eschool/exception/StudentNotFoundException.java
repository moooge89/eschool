package kz.greetgo.eschool.exception;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
