package com.eden.dolphin.core.broker.request;

import com.eden.dolphin.core.entity.enums.Direction;
import com.eden.dolphin.core.entity.enums.Exchange;
import com.eden.dolphin.core.entity.enums.OrderType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderRequest {

    /**
     * 代码
     */
    private String symbol;
    /**
     * 交易所
     */
    private Exchange exchange;

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

}
