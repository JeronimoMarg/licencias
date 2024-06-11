package com.metodos.licencias.util;

public class Item {
    
    //nombre de la clase
    private String atributo1;
    //id de la clase
    private String atributo2;

    public Item(String atributo1, String atributo2) {
        this.atributo1 = atributo1;
        this.atributo2 = atributo2;
    }

    public String getAtributo1() {
        return atributo1;
    }

    public String getAtributo2() {
        return atributo2;
    }

    @Override
    public String toString() {
        return atributo1;
    }
}