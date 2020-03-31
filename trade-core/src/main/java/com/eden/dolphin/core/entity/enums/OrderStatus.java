package com.eden.dolphin.core.entity.enums;

public enum OrderStatus {
    /**
     * 提交中,未成交,部分成交,全部成交,已撤销,拒单
     */
    SUBMITTING("提交中"),NOTTRADED("未成交"),
    PARTTRADED("部分成交"),ALLTRADED("全部成交"),
    CANCELLED("已撤销"),REJECTED("拒单");

    private String meaning;

    OrderStatus(String meaning){
        this.meaning = meaning;
    }

    public String getMeaning(){
        return meaning;
    }
}
