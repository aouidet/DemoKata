package com.kata.demoKata;

import Utils.DateFormatter;
import entity.Account;
import entity.Amount;
import entity.Statement;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class DemoKataApplication {

	public static void main(String[] args) {
		Account account = new Account(new Statement());
		account.depositAmountFromAccount(Amount.getAmount(new BigDecimal(1000)), DateFormatter.date("24/08/2020"));
		account.depositAmountFromAccount(Amount.getAmount(new BigDecimal(1000)), DateFormatter.date("25/08/2020"));

		account.withdrawalAmountFromAccount(Amount.getAmount(new BigDecimal(2000)), DateFormatter.date("26/08/2020"));
		account.withdrawalAmountFromAccount(Amount.getAmount(new BigDecimal(50)), DateFormatter.date("28/08/2020"));

		account.displayStatement(System.out);
	}
}
