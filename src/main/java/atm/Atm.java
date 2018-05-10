package atm;

import java.math.BigDecimal;

public class Atm {

	private BigDecimal balance;
	private String requiredPin = "1234";

	public BigDecimal getBalance() {
		return balance;
	}

	public Atm() {
		this(new BigDecimal("500.00"));
	}

	public Atm(BigDecimal balance) {
		this.balance = balance;
	}

	public boolean allowAccess(String enteredPin) {
		return requiredPin.equals(enteredPin);
	}

	public void withdraw(BigDecimal amountToWithdraw) {
		if (balance.compareTo(amountToWithdraw) < 0) {
			balance = new BigDecimal("0.00");
		} else {
			balance = balance.subtract(amountToWithdraw);
		}
	}

	public void deposit(BigDecimal amountToDeposit) {
		balance = balance.add(amountToDeposit);
	}

}