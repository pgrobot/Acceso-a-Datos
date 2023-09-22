package ejercicio1Tema1.services;

public class PeliculaServiceException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4330316602783562391L;

	public PeliculaServiceException() {
		super();
	}

	public PeliculaServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PeliculaServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public PeliculaServiceException(String message) {
		super(message);
	}

	public PeliculaServiceException(Throwable cause) {
		super(cause);
	}

}
