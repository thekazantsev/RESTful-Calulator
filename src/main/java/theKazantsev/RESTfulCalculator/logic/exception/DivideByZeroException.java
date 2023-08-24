package theKazantsev.RESTfulCalculator.logic.exception;

public class DivideByZeroException extends RuntimeException {
    public DivideByZeroException(String message) {
        super(message);
    }
}
