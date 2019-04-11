package stm.vis.exception;

public class MessageValidationException extends Exception {
	private static final long serialVersionUID = 1L;

	public MessageValidationException(String message, Throwable cause) {
		super(message, cause);
	}

	public MessageValidationException(String message) {
		super(message);
	}

}
