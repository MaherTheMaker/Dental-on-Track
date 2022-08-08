package com.Maker.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class BalanceNotEnough extends RuntimeException {

    private String message;

    public BalanceNotEnough() {}

    public BalanceNotEnough(String msg)
        {
            super(msg);
            this.message = msg;
        }

}
