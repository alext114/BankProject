import java.util.*;
import java.text.DecimalFormat;



	
public class BankAccount {
    private double currentBalance;
    private String accountNumber;
    private String customerName;
    private String customerAddress;
    private ArrayList<Transaction> transaction;
    private String password;
    private String secretQuestion;
    private String secretAnswer;
    
    
    

    public BankAccount (String newAccountNum, String newCustomerName){
    	
    	currentBalance=0.0;
    	accountNumber=newAccountNum;
    	customerName=newCustomerName;
    	transaction= new ArrayList<Transaction>();
    
    	
    	
    }
    
    public BankAccount (String newAccountNum, String newCustomerName, String custAdd, String newPass, String newQuest, String newAns, double newAmount){
    	currentBalance=newAmount;
    	accountNumber=newAccountNum;
    	customerName=newCustomerName;
    	customerAddress=custAdd;
    	password=newPass;
    	secretQuestion=newQuest;
    	secretAnswer=newAns;
    	
    	transaction= new ArrayList<Transaction>();
    	
    	
    	
    }
    

    public String getAccountNumber(){
    	return accountNumber;
    }
    
    public double getTransactionTotal(){
    	int size=0;
    	size=transaction.size();
    	double total = 0;
    	for (int i=0; i < size; i++){
    		total+= transaction.get(i).getAmount();
    	}
    	return total;
    }
    
    public double getCurrentBalance(){
    	return currentBalance;
    }
    public String getCustomerName(){
    	return customerName;
    }
    public void setCustomerName(String custName ){
    	customerName=custName;
    }
    public String getCustomerAddress(){
    	return customerAddress;
    
    }
    public void setCustomerAddress(String custAdd){
    	customerAddress=custAdd;
    }
    
    public void setPassword(String newPassword){
    	password=newPassword;
    }
    public void setSecretQuestion(String newQuestion){
    	secretQuestion=newQuestion;
    }
    public void setSecretAnswer(String newAnswer){
    	secretAnswer=newAnswer;
    }
    public String getPassword(){
    	return password;
    }
    public String getSecretQuestion(){
    	return secretQuestion;
    }
    
    public String getSecretAnswer(){
    	return secretAnswer;
    }

    

    public void debit(double debitAmount, String description){
    if (currentBalance > debitAmount && debitAmount > 0 ){
    	
    	currentBalance-=debitAmount;
    	transaction.add(new Transaction(-debitAmount, description, TransactionType.DEBIT));
    	}
  
    
    
    	
    	
    }
 
    public void deposit(double depositAmount, String description){
 
    	if (depositAmount > 0 ){
    	
    	currentBalance+=depositAmount;
    	}
    	
    	transaction.add(new Transaction(depositAmount, description, TransactionType.DEPOSIT));
    
    } 
    
    
    public void printSummary(){
    	String listTrans = "";
    	if (transaction.size() <= 0){
    		System.out.println("This account has no transactions");	
    	}
    
    	else{
    		
    		for(int i=0; i < transaction.size(); i++){
    		listTrans+= transaction.get(i).toString() + "\n";
    	}
    	
    	
    	DecimalFormat fmt = new DecimalFormat("$0.00");
    	System.out.println("Name: " + getCustomerName()+ "\nCurrent Balance: "+ fmt.format(currentBalance)+ "\n"+listTrans);

    	}
    	
    
    }
   
    
    
    public void reconcile(){
    	if ((currentBalance-getTransactionTotal() == getTransactionTotal()+currentBalance))
    	{
    	 System.out.println("The balance of "+getCustomerName()+ " agrees with the transaction total");
    	}
    	else
    	{
    	System.out.println("The balance of "+ getCustomerName() +"does not agree with the transaction total");
    	}
    			
    	}
    }
    


