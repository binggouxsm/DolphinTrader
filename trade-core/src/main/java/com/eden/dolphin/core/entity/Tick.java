package com.eden.dolphin.core.entity;

import com.eden.dolphin.core.entity.enums.Exchange;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 深度行情
 */
@Data
@AllArgsConstructor
public class Tick {
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

    /**
     * 买入价
     */
    private Double[] bids;
    /**
     * 买入量
     */
    private Double[] bidVolumes;

    /**
     * 卖出价
     */
    private Double[] asks;
    /**
     * 卖出量
     */
    private Double[] askVolumes;

    public String getVTSymbol(){
        return symbol + "." + exchange.toString();
    }

}
