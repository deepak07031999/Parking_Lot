package org.deepak.dto.account;

import org.deepak.enums.AccountStatus;

public abstract class Account {
    private String userName;
    private String password;
    private Person person;
    private AccountStatus status;
}
