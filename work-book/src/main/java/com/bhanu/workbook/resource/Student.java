package com.bhanu.workbook.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;

    @JsonProperty("isAmended")
    private boolean amended;

    @JsonProperty("isExpress")
    private boolean express;

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public boolean isAmended() {
//        return amended;
//    }
//
//    public void setAmended(boolean amended) {
//        this.amended = amended;
//    }
//
//    public boolean isExpress() {
//        return express;
//    }
//
//    public void setExpress(boolean express) {
//        this.express = express;
//    }

    //worked
    //private Boolean isAmended;
    //private Boolean isExpress;
}
