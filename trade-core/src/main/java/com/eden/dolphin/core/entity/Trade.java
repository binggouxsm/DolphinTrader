package com.eden.dolphin.core.entity;

import com.eden.dolphin.core.entity.enums.Direction;
import com.eden.dolphin.core.entity.enums.Exchange;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 成交信息
 */
@Data
@AllArgsConstructor
public class Trade {
    /**
     * 交易id
     */
    private String tradeId;

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

    /**
     * 时间
     */
    private Long datetime;

    /**
     * 多空方向
     */
    private Direction direction;
    /**
     * 价格
     */
    private Double price;
    /**
     * 数量
     */
    private Double volume;

    public String getVTSymbol(){
        return symbol + "." + exchange.toString();
    }

}
