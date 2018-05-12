import java.util.*;

public class Atm {

	private ArrayList<Bank> Banks;

	public Atm() {

		Banks = new ArrayList<Bank>();

	}

	public Bank selectBank(String name) {
		int rightBank = 0;
		for (int i = 0; i < 2; i++) {
			if (Banks.get(i).getBankName() == name) {
				rightBank = i;
			}
		}
		return Banks.get(rightBank);

	}

	public BankAccount selectAccount(Bank bank) {
		Bank selectBank = bank;

		Scanner scan = new Scanner(System.in);
		String userEntryName = "";
		String userEntryPass = "";

		System.out.println("Please enter the name of the account holder: ");
		userEntryName = scan.nextLine();

		System.out.println("Please enter the password to the account");
		userEntryPass = scan.nextLine();

		if (selectBank.getAccount(userEntryName).getPassword().equals(userEntryPass)) {
			System.out.println("Access Granted\n");
			menu(selectBank.getBankName(), selectBank.getAccount(userEntryName));
			
			return selectBank.getAccount(userEntryName, userEntryPass);
		} 
		else {
			System.out
					.println("Do you want to answer the secret question to retrieve the password?(Y/N)");
			String choice=scan.nextLine();
			if (choice.equals( "y")) {
				System.out.println(selectBank.getAccount(userEntryName)
						.getSecretQuestion());
				scan.nextLine();

				if (scan.nextLine().equals(selectBank.getAccount(userEntryName)
						.getSecretAnswer())) {
					System.out.println("Access Granted\n");
					
					menu(selectBank.getBankName(),
							selectBank.getAccount(userEntryName));

					return selectBank.getAccount(userEntryName, userEntryPass);
				}

				else {
					System.out
							.println("INCORRECT PASSWORD.\nPROGRAM TERMINATING.");
					System.exit(0);

				}
			} 
			else {
				System.out.println("ATM CLOSING. HAVE A NICE DAY");
				System.exit(0);
			}

		}
		
		return null;

	}

	public void menu(String myBank, BankAccount account) {
		Scanner scan = new Scanner(System.in);
		System.out.println(myBank + " Menu (Type the number)" + "\n1. Deposit"
				+ "\n2. Withdraw" + "\n3. Tranfer" + "\n4. Reconcile"
				+ "\n5. Print Summary" + "\n6. Exit"
				+ "\n7. Go to Another Account of the Same or Different Bank");
		String choice=scan.nextLine();
		switch (choice) {
		case ("1"):
			System.out.println("How much do you want to deposit?");
			double depositAmount = scan.nextDouble();

			account.deposit(depositAmount, "ATM Deposit");
			System.out.println("Transaction Complete.\nWhen you EXIT the ATM you will recieve a summary of your transactions\n");
			menu(myBank, account);
			break;

		case ("2"):
			System.out.println("How much do you want to withdraw?");
			double debitAmount = scan.nextDouble();
			
			account.debit(debitAmount, "ATM Withdrawl");
			System.out.println("Transaction Complete. \nWhen you EXIT the ATM you will recieve a summary of your transactions\n");
			menu(myBank, account);
			break;
		case ("3"):
			System.out
					.println("How much do you want to transfer? (can only transfer to accounts of same bank)");
			double transferAmount = scan.nextDouble();


			System.out.println("To what account?");
			String accountName=scan.next();
			
			
			
			String account2 = selectBank(myBank).getAccount(accountName)
					.getCustomerName();
			selectBank(myBank).transfer(account.getCustomerName(), account2,
					transferAmount);
			System.out.println("Transaction Complete.\nWhen you EXIT the ATM you will recieve a summary of your transactions\n");
			menu(myBank, account);
			break;

		case ("4"):
			account.reconcile();
			System.out.println("Process Complete.");
			menu(myBank, account);
			break;
		case ("5"):
			account.printSummary();
			System.out.println("Process Complete.");
			menu(myBank, account);
			break;
		case ("6"):
			account.printSummary();
			System.out.println("Have a nice day!");
			System.exit(0);
			break;
		case ("7"):
			mainMenu();
			break;
		default:
			System.out.println("Invalid Request");
			menu(myBank, account);

		}
		
	}

	public void mainMenu() {
		Scanner scan = new Scanner(System.in);

		System.out.println("WELCOME TO MY ATM"
				+ "\nPlease Pick a Bank (Enter a number)" + "\n1. First Bank"
				+ "\n2. Second Bank");
		String choice = scan.nextLine();
		switch (choice) {
		case ("1"):
			selectAccount(selectBank("First Bank"));
			break;
		case ("2"):
			selectAccount(selectBank("Second Bank"));
			break;
		default:
			System.out.println("Invalid Choice\n\n");
			mainMenu();
		}
		

	}

	public static void main(String[] args) {
		Atm ATM = new Atm();
		
		ATM.Banks.add(new Bank("First Bank"));

		ATM.Banks.add(new Bank("Second Bank"));

		ATM.selectBank("First Bank").createAccount("0123456789",
				"Jackie Robinson", "123 MiddleOfNoWhere", "jrjr",
				"What Sport do I Play?", "baseball", 1000);
		ATM.selectBank("First Bank").createAccount("9876543210",
				"Barack Obama", "White House", "potus",
				"What Position of Power Am I?", "president", 10000);
		ATM.selectBank("First Bank").createAccount("0147852369",
				"Marshal Mathers", "I Own Detroit", "mm",
				"What is My Stage Name", "eminem", 2000);

		ATM.selectBank("Second Bank").createAccount("0123456789",
				"Chuck Norris", "Kick Ass Texas", "beard",
				"What am I known for?", "beard", 500);
		ATM.selectBank("Second Bank").createAccount("9876543210", "Bruce Lee",
				"My Grave", "martial arts", "What do i do?", "martial arts",
				200);
		ATM.selectBank("Second Bank").createAccount("0147852369", "Ned Stark",
				"Winterfell", "winter", "What is Coming?", "winter", 5000);

		
		

		ATM.mainMenu();

	}
}
