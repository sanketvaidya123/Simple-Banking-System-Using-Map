package utils;

import java.util.HashMap;
import com.app.banking.BankAccount;
import static com.app.banking.AccountType.*;
import static java.time.LocalDate.parse;

public class BankAccountUtils {

	public static HashMap<Integer,BankAccount> populateBankCustomer(){
		
		HashMap<Integer,BankAccount> map = new HashMap<>();
		map.put(101, new BankAccount(101, "Raj", SAVING,parse("2020-05-03"), 15000));
		map.put(100, new BankAccount(100, "Ram", CURRENT,parse("2021-05-23"), 25000));
		map.put(105, new BankAccount(105, "Yogesh", SAVING,parse("2020-09-23"), 5000));
		map.put(107, new BankAccount(107, "Rohan", CURRENT,parse("2020-05-03"), 7000));
		map.put(109, new BankAccount(109, "Mahesh", CURRENT,parse("2022-01-23"), 65000));
		map.put(56, new BankAccount(56, "Govind", SAVING,parse("2020-09-03"), 75000));
		map.put(40, new BankAccount(40, "Palak", FD,parse("2020-08-03"), 85000));
		return map;
		
	}
}
