package com.brendondias.game.logic;

import lombok.Data;

@Data
public class Type {
    private String typeName;
    public Type(String typeName) {
        this.typeName = typeName;
    }
}
