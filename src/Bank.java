
import java.util.*;


public class Bank {
private ArrayList<BankAccount> bankAccounts;
private String BankName;


public Bank(String newBankName){
	
	 bankAccounts=new ArrayList<BankAccount>();
	 
	 BankName=newBankName;
	 
}
public void createAccount(String newAccountNum, String newCustomerName, String custAdd, String newPass, String newQuest, String newAns, double newAmount){
	 bankAccounts.add(new BankAccount(newAccountNum, newCustomerName, custAdd, newPass, newQuest, newAns, newAmount ) );
}

public String getBankName(){
	return BankName;
}

public void setBankName(String newBankName){
	BankName=newBankName;
}

public void printInfo(){
	for (int i=0; i < bankAccounts.size(); i++){
		

	System.out.println(bankAccounts.get(i).getCustomerName() + " "+ bankAccounts.get(i).getAccountNumber());
	}
}



public BankAccount getAccount(String accountName, String password){
	
	int rightAccount=0;
	for (int i=0; i < bankAccounts.size(); i++){
		if (bankAccounts.get(i).getCustomerName().toLowerCase()== accountName.toLowerCase()&&
				bankAccounts.get(i).getCustomerName().toLowerCase()==password.toLowerCase()){
			
			 rightAccount= i;
		
		}
	}
	return bankAccounts.get(rightAccount);
	
}

public BankAccount getAccount(String accountName){
	int rightAccount=0;
	for (int i=0; i < bankAccounts.size(); i++){
		if (bankAccounts.get(i).getCustomerName().equals(accountName)){
			
			 rightAccount= i;
		
		}
	}
	return bankAccounts.get(rightAccount);
	
	
}

public void transfer(String account1, String account2, double amount ){ 
	if (bankAccounts.size() >= 2 && getAccount(account1).getCurrentBalance() >= amount){
	getAccount(account1).debit(amount, "Transfer");
	getAccount(account2).deposit(amount, "Transfer");
	}
	else{
		System.out.println("Insuffcient Funds.");
	}
}




}