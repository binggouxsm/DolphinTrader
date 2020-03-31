package com.eden.dolphin.core.entity;

import com.eden.dolphin.core.entity.enums.Direction;
import com.eden.dolphin.core.entity.enums.Exchange;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Position {

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
     * 多空方向，期货品种具有多空方向；而股票品种方向为“净”持仓。
     */
    private Direction direction = Direction.LONG;
    /**
     * 历史成交的平均价格(发生多次部分成交，需要计算平均价格)
     */
    private Double price;
    /**
     * 总持仓数量
     */
    private Double volume;
    /**
     * 盈亏
     */
    private Double pnl;

    public String getVTSymbol(){
        return symbol + "." + exchange.toString();
    }

}
