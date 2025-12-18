package org.ies.tierno.objects.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
    private String iban;
    private double balance;
    private Customer customer;

    public void showInfo() {
        System.out.print("IBAN: " + iban + ". Saldo: " + balance + ". Titular: ");
        customer.showInfo();
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            System.out.println("No hay suficiente saldo");
            return false;
        }
    }
}
