package stm.vis.exception;

public class VISException extends Exception {
	private static final long serialVersionUID = 1L;

	public VISException(String message, Throwable cause) {
		super(message, cause);
	}

	public VISException(String message) {
		super(message);
	}

}
