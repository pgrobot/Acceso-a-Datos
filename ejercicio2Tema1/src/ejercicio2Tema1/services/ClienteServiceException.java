package ejercicio2Tema1.services;

public class ClienteServiceException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4330316602783562391L;

	public ClienteServiceException() {
		super();
	}

	public ClienteServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ClienteServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ClienteServiceException(String message) {
		super(message);
	}

	public ClienteServiceException(Throwable cause) {
		super(cause);
	}

}
