package org.ies.tierno.objects.bank.apps;

import org.ies.tierno.objects.bank.model.Bank;
import org.ies.tierno.objects.bank.readers.BankReader;

import java.util.Scanner;

public class BankMenuApp {
    private final Scanner scanner;
    private final BankReader bankReader;

    public BankMenuApp(Scanner scanner, BankReader bankReader) {
        this.scanner = scanner;
        this.bankReader = bankReader;
    }

    public void run() {
        var bank = bankReader.read();

        int opt;
        do {
            opt = chooseOption();
            if (opt == 1) {
                bank.showInfo();
            } else if (opt == 2) {
                showAccount(bank);
            } else if (opt == 3) {
                showCustomerAccounts(bank);
            } else if (opt == 4) {
                deposit(bank);
            } else if (opt == 5) {
                withdraw(bank);
            } else if (opt == 6) {
                countCusomterAccounts(bank);
            } else if (opt == 7) {
                showAccountCustomer(bank);
            } else if (opt == 8) {
                transfer(bank);
            }

        } while (opt != 9);
    }

    private void transfer(Bank bank) {
        String origin = askIban();
        String destination = askIban();
        double amount = askAmount();

        bank.transfer(origin, destination, amount);
    }

    private void showAccountCustomer(Bank bank) {
        String iban = askIban();
        var account = bank.findAccount(iban);
        if (account != null) {
            account.getCustomer().showInfo();
        } else {
            System.out.println("No existe la cuenta " + iban);
        }
    }

    private void countCusomterAccounts(Bank bank) {
        String nif = askNif();

        int count = bank.countCustomerAccounts(nif);
        System.out.println("El cliente " + nif + " tiene " + count + " cuentas");
    }

    private void withdraw(Bank bank) {
        String iban = askIban();
        double amount = askAmount();

        var account = bank.findAccount(iban);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("No existe la cuenta " + iban);
        }
    }

    private double askAmount() {
        System.out.println("Cantidad:");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        return amount;
    }

    private void deposit(Bank bank) {
        String iban = askIban();

        double amount = askAmount();

        bank.deposit(iban, amount);
    }

    private String askIban() {
        System.out.println("IBAN:");
        String iban = scanner.nextLine();
        return iban;
    }

    private void showCustomerAccounts(Bank bank) {
        String nif = askNif();

        bank.showCustomerAccounts(nif);
    }

    private String askNif() {
        System.out.println("NIF:");
        String nif = scanner.nextLine();
        return nif;
    }

    private void showAccount(Bank bank) {
        String iban = askIban();

        bank.showAccount(iban);
    }

    private int chooseOption() {
        int opt;
        System.out.println("Elige una opción:");
        System.out.println("1. Mostrar cuentas");
        System.out.println("2. Mostrar cuenta");
        System.out.println("3. Mostrar cuentas de cliente");
        System.out.println("4. Ingresar dinero");
        System.out.println("5. Sacar dinero");
        System.out.println("6. Contar cuentas de cliente");
        System.out.println("7. Mostrar cliente de cuenta");
        System.out.println("8. Transferencia");
        System.out.println("9. Salir");
        opt = scanner.nextInt();
        scanner.nextLine();
        return opt;
    }
}
