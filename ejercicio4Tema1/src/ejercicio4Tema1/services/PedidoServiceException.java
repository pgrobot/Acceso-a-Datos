package ejercicio4Tema1.services;

public class PedidoServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3718068216892793386L;

	public PedidoServiceException() {
		super();
	}

	public PedidoServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PedidoServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public PedidoServiceException(String message) {
		super(message);
	}

	public PedidoServiceException(Throwable cause) {
		super(cause);
	}

}
