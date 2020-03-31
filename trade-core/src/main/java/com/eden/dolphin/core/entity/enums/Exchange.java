package com.eden.dolphin.core.entity.enums;

public enum Exchange {

    HUOBI("火币");

    private String meaning;

    Exchange(String meaning){
        this.meaning = meaning;
    }

    public String getMeaning(){
        return meaning;
    }

}
