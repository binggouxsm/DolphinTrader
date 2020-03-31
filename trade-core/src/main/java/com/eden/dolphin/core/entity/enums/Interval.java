package com.eden.dolphin.core.entity.enums;

public enum Interval {

    MINUTE("1m"),HOUR("1h"),DAILY("1d"),WEEKLY("1w");

    private String meaning;

    Interval(String meaning){
        this.meaning = meaning;
    }

    public String toString(){
        return meaning;
    }

    public String getMeaning(){
        return meaning;
    }

}
