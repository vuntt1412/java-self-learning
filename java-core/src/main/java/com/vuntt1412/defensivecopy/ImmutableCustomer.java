package com.vuntt1412.defensivecopy;

import java.time.LocalDateTime;

/**
 * A Strategy for Defining Immutable Objects<p>
 * 1. Don't provide "setter" methods
 * <p>
 * 2. Make all fields final and private
 * <p>
 * 3. Don't allow subclasses to override methods
 * <p>
 * 4. If the instance fields include references to mutable objects, don't allow those objects to be changed
 */
public final class ImmutableCustomer {
    // Make all fields final and private
    private final String name;
    private final LocalDateTime creationDate; //immutable, thread-safe class
    private final Account account; //mutable

    public ImmutableCustomer(String name, LocalDateTime creationDate, Account account) {
        this.name = name;
        this.creationDate = creationDate;
        // make defensive copy
        this.account = new Account(account.getEmail());
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public Account getAccount() {
        // make defensive copy
        return new Account(account.getEmail());
    }

    /*public void setAccount(Account account) {
        this.account = account;
    }*/
}
