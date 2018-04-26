package atm;

import java.util.Scanner;

public class AtmClientApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		Atm myAccount = new Atm(100.00);

		System.out.println("Enter your pin.");
		String enteredPin = input.nextLine();

		while (!myAccount.allowAccess(enteredPin)) {
			System.out.println("Invalid access. Try again.");
			enteredPin = input.nextLine();
		}

		String optionEntered = "";
		do {
			System.out.println("Welcome to Bank of We Can Code IT!");
			System.out.println("Choose an option.");
			System.out.println("Press 1 to deposit funds.");
			System.out.println("Press 2 to withdraw funds.");
			System.out.println("Press 3 to check balance.");
			System.out.println("Press 4 to exit.");
			optionEntered = input.nextLine();

			if (optionEntered.equals("1")) {
				System.out.println("Enter deposit amount:");
				int depositAmount = input.nextInt();
				myAccount.deposit(depositAmount);
				System.out.println(
						"You have selected to deposit " + " and your balance is now " + myAccount.getBalance());
				input.nextLine();
			} else if (optionEntered.equals("2")) {
				System.out.println("Entered a withdraw amount:");
				int withdrawAmount = input.nextInt();
				myAccount.withdraw(withdrawAmount);
				System.out.println(
						"You have selected to withdraw " + " and your balance is now " + myAccount.getBalance());
				input.nextLine();
			} else if (optionEntered.equals("3")) {
				System.out.println("Your current balance is " + myAccount.getBalance());
			} else {
				System.out.println("Goodbye...");
				System.exit(0);
			}

		} while (!optionEntered.equals("4"));

		input.close();
	}

}