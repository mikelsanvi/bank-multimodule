package org.ies.tierno.objects.bank;

import org.ies.tierno.objects.bank.apps.BankMenuApp;
import org.ies.tierno.objects.bank.readers.AccountReader;
import org.ies.tierno.objects.bank.readers.BankReader;
import org.ies.tierno.objects.bank.readers.CustomerReader;

import java.util.Scanner;

public class BankMenuAppMain {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var customerReaer = new CustomerReader(scanner);
        var accountReader = new AccountReader(scanner, customerReaer);
        var bankReader = new BankReader(scanner, accountReader);
        var bankApp = new BankMenuApp(scanner, bankReader);

        bankApp.run();
    }
}
