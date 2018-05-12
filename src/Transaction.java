import java.text.DecimalFormat;
import java.util.*;





public class Transaction {
	
    


	
	
	private Date date;
	private double amount;
	private String description;
	private TransactionType type;

    public Transaction(double newAmount, String newDescription, TransactionType newType){
    
	date = new java.util.Date(System.currentTimeMillis());

    amount=newAmount;
    description=newDescription;
    type=newType;
    
   
    
    
    }
    
    public double getAmount(){
    	return amount;
    }
    
    public String getDescription(){
    return description;
    }
    
    public  TransactionType getType(){
    return type;
    }
    
    
    
    public void setAmount(double amount){
    this.amount= amount;
    }
  
    public void setDescription(String description){
    this.description=description;
    }
    
    public void setType(TransactionType newType){
    type=newType;
    }
    
    
    
    public String toString (){
    	String info;
    	DecimalFormat fmt=new DecimalFormat("$0.00");
    	info= getType()+ " " + fmt.format(getAmount())+", " + getDescription() + " " + date ;
    	
    	return info;
    }
    
  
    
    
    
}