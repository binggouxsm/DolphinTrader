package com.eden.dolphin.core.entity.enums;

public enum Direction {
    /**
     * 多，空
     */
    LONG("多"),SHORT("空");

    private String meaning;

    Direction(String meaning){
        this.meaning = meaning;
    }

    public String getMeaning(){
        return meaning;
    }
}
