package com.eden.dolphin.core.entity;

import com.eden.dolphin.core.entity.enums.Exchange;
import com.eden.dolphin.core.entity.enums.Interval;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 行情
 */
@Data
@AllArgsConstructor
public class Bar {

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
     * 名称
     */
    private String name;
    /**
     * 频率
     */
    private Interval interval;
    /**
     * 成交量
     */
    private Double volume;
    /**
     * 开盘价
     */
    private Double open;
    /**
     * 最高价
     */
    private Double high;
    /**
     * 最低价
     */
    private Double low;
    /**
     * 收盘价
     */
    private Double close;


    public String getVTSymbol(){
        return symbol + "." + exchange.toString();
    }


}
