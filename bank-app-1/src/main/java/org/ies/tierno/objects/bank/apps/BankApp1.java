package org.ies.tierno.objects.bank.apps;

import org.ies.tierno.objects.bank.model.Bank;
import org.ies.tierno.objects.bank.readers.BankReader;

import java.util.Scanner;

public class BankApp1 {
    private final Scanner scanner;
    private final BankReader bankReader;

    public BankApp1(Scanner scanner, BankReader bankReader) {
        this.scanner = scanner;
        this.bankReader = bankReader;
    }

    public void run() {
        Bank bank = bankReader.read();

        var account1 = bank.findAccount("ES0001");
        if(account1 == null) {
            System.out.println("La cuenta no existe");
        } else {
            account1.deposit(500);
            account1.showInfo();
        }
        var account2 = bank.findAccount("ES0002");
        if(account2 == null) {
            System.out.println("La cuenta no existe");
        } else {
            account2.deposit(30);
            account2.showInfo();
        }

        boolean done = bank.transfer("ES0001", "ES0002", 500);
        if(done) {
            System.out.println("Transferencia realizada correctamente");
        } else {
            System.out.println("No se ha realizado la transferencia");
        }
    }
}
