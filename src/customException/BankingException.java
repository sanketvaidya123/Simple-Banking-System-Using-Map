package customException;

@SuppressWarnings("serial")
public class BankingException extends Exception {
	
	private String msg;

	public BankingException(String msg) {
		super();
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
	}
}
