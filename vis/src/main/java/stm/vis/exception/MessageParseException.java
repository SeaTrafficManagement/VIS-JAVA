package stm.vis.exception;

public class MessageParseException extends Exception {
	private static final long serialVersionUID = 1L;

	public MessageParseException(String message, Throwable cause) {
		super(message, cause);
	}

	public MessageParseException(String message) {
		super(message);
	}

}
