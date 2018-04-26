package atm;

public class Atm {

	private double balance;
	private String requiredPin = "1234";

	public double getBalance() {
		return balance;
	}

	public Atm() {
		// could have done:
		// balance = 500.00;
		// calling the other constructor:
		this(500.00);
	}

	public Atm(double amount) {
		balance = amount;
	}

	public boolean allowAccess(String enteredPin) {
		return requiredPin.equals(enteredPin);
	}

	public void withdraw(int amountToWithdraw) {
		if (balance >= amountToWithdraw) {
			balance -= amountToWithdraw;
		} else {
			balance -= balance;
		}
	}

	public void deposit(int amountToDeposit) {
		if (amountToDeposit > 0) {
			balance += amountToDeposit;
		} else {
			balance += 0;
		}

	}

}