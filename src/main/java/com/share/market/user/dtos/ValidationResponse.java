package com.share.market.user.dtos;

import lombok.Getter;

@Getter
public class ValidationResponse {

    private String message;

    public ValidationResponse(String message) {
        this.message = message;
    }



}
