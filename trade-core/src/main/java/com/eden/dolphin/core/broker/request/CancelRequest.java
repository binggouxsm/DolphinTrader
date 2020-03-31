package com.eden.dolphin.core.broker.request;

import com.eden.dolphin.core.entity.enums.Exchange;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CancelRequest {
    /**
     * 委托id
     */
    private String orderId;

    /**
     * 代码
     */
    private String symbol;

    /**
     * 交易所
     */
    private Exchange exchange;
}
