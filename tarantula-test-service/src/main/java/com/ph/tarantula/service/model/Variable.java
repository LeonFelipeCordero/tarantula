package com.ph.tarantula.service.model;

public class Variable {
    private String variable;
    private String next = "test";
    private int integer = 0;
    private String next2 = "3";

    public Variable(String variable) {
        this.variable = variable;
    }

    public String getVariable() {
        return variable;
    }

    public String getNext() {
        return next;
    }

    public int getInteger() {
        return integer;
    }

    public String getNext2() {
        return next2;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    public void setNext2(String next2) {
        this.next2 = next2;
    }
}

