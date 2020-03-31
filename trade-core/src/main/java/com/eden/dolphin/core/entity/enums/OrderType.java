package com.eden.dolphin.core.entity.enums;

public enum OrderType {
    /**
     * 限价，市价
     */
    LIMIT("限价"),MARKET("市价");

    private String meaning;

    OrderType(String meaning){
        this.meaning = meaning;
    }

    public String getMeaning(){
        return meaning;
    }
}
