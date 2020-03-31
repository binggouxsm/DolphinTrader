package com.eden.dolphin.core.entity;

import com.eden.dolphin.core.entity.enums.Direction;
import com.eden.dolphin.core.entity.enums.Exchange;
import com.eden.dolphin.core.entity.enums.OrderStatus;
import com.eden.dolphin.core.entity.enums.OrderType;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 委托信息
 */
@Data
@AllArgsConstructor
public class Order {
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
     * 交易类型
     */
    private OrderType type;
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
    /**
     * 已成交
     */
    private Double traded;

    /**
     * 状态
     */
    private OrderStatus status;

    public String getVTSymbol(){
        return symbol + "." + exchange.toString();
    }


}
