package com.cristianreyesad.newsapi.util;

public class IsNumber {

    public boolean isNumber (String s) {
        return (s != null && s.matches("[0-9]+"));
    }
}
