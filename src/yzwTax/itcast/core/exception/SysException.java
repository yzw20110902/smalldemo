package yzwTax.itcast.core.exception;

public abstract class SysException extends Exception {

	private String errorMsg;

	public SysException() {
		super();

	}

	public SysException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub\

		errorMsg = message;
	}

	public SysException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
		errorMsg = message;
	}

	public SysException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
