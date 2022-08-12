package utils;

import customException.BankingException;

public  class BankingValidationRules {
	
	public static double MIN_AMOUNT;
	static {
		MIN_AMOUNT=5000;
	}
	//static method for validating balance
	public static double validateAmount(double amt) throws BankingException {
		if(amt<MIN_AMOUNT) {
			throw new BankingException("Insufficient Funds");
		}else {
			return amt;
		}
	}
	
	
	
	
}
