package org.ies.tierno.objects.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    private String nif;
    private String name;
    private String surname;

    public void showInfo() {
        System.out.println(surname + ", " + name + " (" + nif + ")");
    }
}
