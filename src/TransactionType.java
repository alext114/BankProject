
	public enum TransactionType{
		DEBIT("debit"), DEPOSIT("deposit");
	
	
	private String Str;
	
	TransactionType(String newStr){
		Str=newStr;
	}
	
	public String toString(){
		return Str;
	}
	
	
	}
	