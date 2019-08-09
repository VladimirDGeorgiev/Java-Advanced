package bankAccount;


import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class BankAccountTest {

    //setName
    @Test(expected = IllegalArgumentException.class)
    public void setNameShouldThrowExceptionIfLengthIsLessThen3() {
        BankAccount bankAccount = new BankAccount("aa", new BigDecimal(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNameShouldThrowExceptionIfLengthIsMoreThen25() {
        BankAccount bankAccount = new BankAccount("12345678901234567890123456", new BigDecimal(2));
    }

    //setBalance
    @Test(expected = IllegalArgumentException.class)
    public void setBalanceShouldThrowExceptionIfValueIsLessThen0() {
        BankAccount bankAccount = new BankAccount("Testtest", new BigDecimal(-1));
    }


    //Constructor
    @Test
    public void constructorShouldWorkCorrectlyWith3Lenght() {
        BankAccount bankAccount = new BankAccount("123", new BigDecimal(0));
        Assert.assertEquals(new BigDecimal(0), bankAccount.getBalance());
        Assert.assertEquals("123", bankAccount.getName());
    }

    @Test
    public void constructorShouldWorkCorrectlyWith25Lenght() {
        BankAccount bankAccount = new BankAccount("1234567890123456789012345", new BigDecimal(0));
        Assert.assertEquals(new BigDecimal(0), bankAccount.getBalance());
        Assert.assertEquals("1234567890123456789012345", bankAccount.getName());
    }

    //  deposit(BigDecimal amount)

    @Test(expected = UnsupportedOperationException.class)
    public void depositShouldThrowExceptionIfValueIsLessThen1() {
        BankAccount bankAccount = new BankAccount("Testtest", new BigDecimal(0));
        bankAccount.deposit(new BigDecimal(0));
    }

    @Test
    public void depositShouldWorkCorrenct() {
        BankAccount bankAccount = new BankAccount("Testtest", new BigDecimal(0));
        bankAccount.deposit(new BigDecimal(1));
        Assert.assertEquals(new BigDecimal(1), bankAccount.getBalance());
    }

    //withdraw(BigDecimal amount)

    @Test(expected = UnsupportedOperationException.class)
    public void withdrawShouldThrowExceptionIfValueWithdrawIsMoreThenAmaount() {
        BankAccount bankAccount = new BankAccount("Testtest", new BigDecimal(10));
        bankAccount.withdraw(new BigDecimal(11));

    }

    @Test(expected = UnsupportedOperationException.class)
    public void withdrawShouldThrowExceptionIfWithDrawIsLessThen0() {
        BankAccount bankAccount = new BankAccount("Testtest", new BigDecimal(0));
        bankAccount.withdraw(new BigDecimal(-1));
    }

    @Test
    public void withdrawShouldReturnBigDecimal() {
        BankAccount bankAccount = new BankAccount("Testtest", new BigDecimal(10));
        Assert.assertEquals(new BigDecimal(5),bankAccount.withdraw(new BigDecimal(5)));
    }

    @Test
    public void withdrawShouldDecreaceTheAmauntWithThisValue() {
        BankAccount bankAccount = new BankAccount("Testtest", new BigDecimal(10));
        bankAccount.withdraw(new BigDecimal(5));
        Assert.assertEquals(new BigDecimal(5),bankAccount.getBalance());
    }





}