package com.share.market.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResponseDto<T> {

    private final String message;

    private final int code;

    private final T body;
}
