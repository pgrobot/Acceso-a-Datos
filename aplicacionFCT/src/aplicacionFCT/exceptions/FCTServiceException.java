package aplicacionFCT.exceptions;

public class FCTServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7101294323865030684L;

	public FCTServiceException() {
		super();
	}

	public FCTServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FCTServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public FCTServiceException(String message) {
		super(message);
	}

	public FCTServiceException(Throwable cause) {
		super(cause);
	}

}
