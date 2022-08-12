package tester;

import static java.time.LocalDate.parse;
import java.util.Collection;
//import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.time.*;

import com.app.banking.BankAccount;

import customException.BankingException;
import utils.BankingValidationRules;

import static com.app.banking.AccountType.*;
import static utils.BankAccountUtils.populateBankCustomer;
public class BankingSystemTester {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
		boolean flag=false;
		HashMap<Integer, BankAccount> map = populateBankCustomer();
		while(!flag){
		System.out.println("1.Create Account\n2.Display details of all accts\n3.Get Account Summary\n4.Funds Transfer\n5.Close account\n6.Find by account Type\n7.Find by date\n10 Exit");
		System.out.println("Enter your choice:");
		int ch = sc.nextInt();
		try {
		switch(ch) {
		case 1:
			System.out.println("Enter account number");
			int ac = sc.nextInt();
			if(map.containsKey(ac)) {
				throw new BankingException("Account already exists");
			}
			System.out.println("Enter Customer name, Account type, creation date(yyyy-MM-dd), balance");
			map.put(ac, new BankAccount(ac, sc.next(), valueOf(sc.next().toUpperCase()), LocalDate.parse(sc.next()), BankingValidationRules.validateAmount(sc.nextDouble())));
			System.out.println("Account Created Successfully");
			break;
		case 2:
			if(map.isEmpty()) {
				throw new BankingException("No data available");
			}else {
				System.out.println("All Bank Account");
				
				Set<Map.Entry<Integer, BankAccount>> mapSet = map.entrySet();
				for(Map.Entry<Integer, BankAccount> it : mapSet) {
					System.out.println(it);
				}
			}
			break;
		case 3:
			System.out.println("Enter Account Number");
			int no=sc.nextInt();
			BankAccount acct = map.get(no);
			if(acct==null) {
				throw new BankingException("Invalid source a count");
			}
			System.out.println("Account summary: "+acct);
			break;
		case 4:
			System.out.println("Enter Source account no, destination account no, Transfer amount::");
			acct = map.get(sc.nextInt());
			if(acct==null) {
				throw new BankingException("Invalid source account number");
			}
			BankAccount dest = map.get(sc.nextInt());
			if(dest==null) {
				throw new BankingException("Invalid destination account number");
			}
			acct.fundTransfer(dest, sc.nextDouble());
			break;
		case 5:
			System.out.println("Enter Account Number:");
			int n=sc.nextInt();
			map.remove(n);
			break;
		case 6:
			System.out.println("Enter Account Type");
			String type = sc.next();
			Collection<BankAccount> acc = map.values();
			for(BankAccount b : acc) {
				if(b.getType().equals(valueOf(type.toUpperCase()))) {
					System.out.println(b.getCustName());
				}
			}
			
			break;
		case 7:
			System.out.println("Enter start and end date (yyyy-MM-dd)");
			LocalDate start = parse(sc.next());
			LocalDate end = parse(sc.next());
			for(BankAccount b : map.values()) {
				if(b.getCreationDate().isAfter(start)&&b.getCreationDate().isBefore(end)) {
					System.out.println(b.getBalance());
				}
			}
			
			break;
		case 10:
			System.out.println("Exiting.....");
			flag=true;
			break;
		}
			}catch(Exception e) {
				e.printStackTrace();
		}
		}
		}
	}

}
