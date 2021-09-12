package com.vuntt1412.defensivecopy;

import java.time.LocalDateTime;

public class Application {
    public static void main(String... args) {
        // assume that we have to use the mutable object(Account) in Customer
        Account account = new Account("joe@gmail.com");
        ImmutableCustomer immutableCustomer = createCustomer(account);

        // try to attack on the mutable object
        account.setEmail("noName@gmail.com");
        immutableCustomer.getAccount().setEmail("noName@gmail.com");
        System.out.println("Protected by making defensive copy: " + immutableCustomer.getAccount().getEmail());

    }

    private static ImmutableCustomer createCustomer(Account account) {
        ImmutableCustomer cus = new ImmutableCustomer("Joe", LocalDateTime.now(), account);
        return cus;
    }

}
