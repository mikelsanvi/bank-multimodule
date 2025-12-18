package org.ies.tierno.objects.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Bank {
    private String name;
    private Account[] accounts;

    public void showInfo() {
        System.out.println("Banco " + name);
        for (int i = 0; i < accounts.length; i++) {
            System.out.print("Cuenta " + (i + 1) + ": ");
            accounts[i].showInfo();
        }
    }

    public void showAccount(String iban) {
        for (var account : accounts) {
            if (account.getIban().equals(iban)) {
                account.showInfo();
            }
        }
    }

    public Account findAccount(String iban) {
        for (var account : accounts) {
            if (account.getIban().equals(iban)) {
                return account;
            }
        }
        return null;
    }

    public void showCustomerAccounts(String nif) {
        for (var account : accounts) {
            Customer customer = account.getCustomer();
            if (customer.getNif().equals(nif)) {
                account.showInfo();
            }
        }
    }

    public void deposit(String iban, double amount) {
        var account = findAccount(iban);
        if (account == null) {
            System.out.println("No se encuentra la cuenta " + iban);
        } else {
            account.deposit(amount);
        }
    }

    public int countCustomerAccounts(String nif) {
        int count = 0;
        for (var account : accounts) {
            if (account.getCustomer().getNif().equals(nif)) {
                count++;
            }
        }
        return count;
    }

    public Customer findAccountCustomer(String iban) {
        var account = findAccount(iban);
        if (account == null) {
            return null;
        } else {
            return account.getCustomer();
        }
    }

    public boolean transfer(String ibanOrigin, String ibanDestination, double amount) {
        var origin = findAccount(ibanOrigin);
        var destination = findAccount(ibanDestination);
        if (origin != null && destination != null) {
            if (origin.getBalance() >= amount) {
                origin.withdraw(amount);
                destination.deposit(amount);
                return true;
            }
        } else {
            System.out.println("No exista la cuenta de origen o destino");
        }
        return false;
    }

}
