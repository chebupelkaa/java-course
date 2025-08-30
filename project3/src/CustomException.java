import java.io.IOException;

public class CustomException extends IOException {
    public CustomException(final String message,final Throwable cause) {
        super(message, cause);
    }
}