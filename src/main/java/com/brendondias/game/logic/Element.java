package com.brendondias.game.logic;

import lombok.Data;

@Data
public class Element {
    private String elementName;

    public Element(String elementName){
        this.elementName = elementName;
    }



}
