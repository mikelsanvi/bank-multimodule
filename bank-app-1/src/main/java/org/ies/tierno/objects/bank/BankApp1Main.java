package org.ies.tierno.objects.bank;

import org.ies.tierno.objects.bank.apps.BankApp1;
import org.ies.tierno.objects.bank.readers.AccountReader;
import org.ies.tierno.objects.bank.readers.BankReader;
import org.ies.tierno.objects.bank.readers.CustomerReader;

import java.util.Scanner;

public class BankApp1Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);


        
        var customerReaer = new CustomerReader(scanner);
        var accountReader = new AccountReader(scanner, customerReaer);
        var bankReader = new BankReader(scanner, accountReader);
        var bankApp = new BankApp1(scanner, bankReader);

        bankApp.run();
    }
}
