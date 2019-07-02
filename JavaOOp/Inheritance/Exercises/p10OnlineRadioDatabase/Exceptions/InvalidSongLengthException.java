package JavaOOp.L04Inheritance.Exercises.p10OnlineRadioDatabase.Exceptions;

public class InvalidSongLengthException extends RuntimeException {
    public InvalidSongLengthException(String s) {
        super(s);
    }
}
