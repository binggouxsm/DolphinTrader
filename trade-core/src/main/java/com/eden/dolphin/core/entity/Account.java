package com.eden.dolphin.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {

    private String accountId;

    private Double balance;

    private Double frozen;
}
