package servicio;

public class ActorServiceException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2475540366638500295L;

	public ActorServiceException() {
		super();
	}

	public ActorServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ActorServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ActorServiceException(String message) {
		super(message);
	}

	public ActorServiceException(Throwable cause) {
		super(cause);
		
	}

}
