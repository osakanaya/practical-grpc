package uk.me.uohiro.protobuf.ch7.service;

public class ManagementException extends Exception {
	private static final long serialVersionUID = 1L;

	public ManagementException() {
		super();
	}

	public ManagementException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ManagementException(String message, Throwable cause) {
		super(message, cause);
	}

	public ManagementException(String message) {
		super(message);
	}

	public ManagementException(Throwable cause) {
		super(cause);
	}
}
