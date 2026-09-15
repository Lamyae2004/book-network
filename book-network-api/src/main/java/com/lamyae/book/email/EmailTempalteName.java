package com.lamyae.book.email;

import lombok.Getter;

@Getter
public enum EmailTempalteName {
    ACTIVATE_ACCOUNT("activate_account");
    private final String name;

    EmailTempalteName(String name) {
        this.name = name;
    }
}
