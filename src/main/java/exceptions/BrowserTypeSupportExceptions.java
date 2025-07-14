package exceptions;

public class BrowserTypeSupportExceptions extends RuntimeException {

    public BrowserTypeSupportExceptions(String browserName) {
        super(String.format("Browser %s not supported", browserName));

    }
}
