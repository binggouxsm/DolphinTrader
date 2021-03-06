package com.eden.dolphin.core.broker.request;

import com.eden.dolphin.core.entity.enums.Exchange;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubscribeRequest {

    /**
     * 代码
     */
    private String symbol;
    /**
     * 交易所
     */
    private Exchange exchange;


}
