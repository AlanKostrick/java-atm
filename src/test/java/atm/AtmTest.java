package atm;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class AtmTest {

	@Test
	public void shouldHaveDefaultBalance() {
		// arrange
		Atm underTest = new Atm();
		// act
		BigDecimal balance = underTest.getBalance();
		// assert
		Assert.assertEquals(new BigDecimal("500.00"), balance);
	}

	@Test
	public void shouldWithdraw50() {
		Atm underTest = new Atm();
		underTest.withdraw(new BigDecimal("50.00"));
		BigDecimal balance = underTest.getBalance();
		Assert.assertEquals(new BigDecimal("450.00"), balance);
	}

	@Test
	public void shouldHaveStartingBalance() {
		Atm underTest = new Atm(new BigDecimal("2700.00"));
		BigDecimal balance = underTest.getBalance();
		Assert.assertEquals(new BigDecimal("2700.00"), balance);
	}

	@Test
	public void shouldAllowAccessByPin() {
		Atm underTest = new Atm();
		boolean check = underTest.allowAccess("1234");
		Assert.assertTrue(check);
	}

	@Test
	public void shouldDenyAccessByPin() {
		Atm underTest = new Atm();
		boolean check = underTest.allowAccess("4567");
		Assert.assertFalse(check);

	}

	@Test
	public void shouldLimitWithdrawToBalance() {
		Atm underTest = new Atm(new BigDecimal("50.00"));
		underTest.withdraw(new BigDecimal("100.00"));
		BigDecimal balance = underTest.getBalance();
		Assert.assertEquals(new BigDecimal("0.00"), balance);
	}

	@Test
	public void shouldDeposit50() {
		Atm underTest = new Atm(new BigDecimal("50.00"));
		underTest.deposit(new BigDecimal("50.00"));
		BigDecimal balance = underTest.getBalance();
		Assert.assertEquals(new BigDecimal("100.00"), balance);
	}

}