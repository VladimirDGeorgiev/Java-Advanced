package JavaOOp.L04Inheritance.Exercises.p10OnlineRadioDatabase.Exceptions;

public class InvalidSongNameException extends RuntimeException {
    public InvalidSongNameException(String s) {
        super(s);
    }
}
