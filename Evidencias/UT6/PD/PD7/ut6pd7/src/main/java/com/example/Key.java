package com.example;

public class Key {
    String key;

    public Key(String key){
        this.key = key;
    }

    public String getKey(){
        return this.key;
    }

    public void setKey(String key){
        this.key = key;
    }

    public boolean equals(String key){
        return this.key.equals(key);
    }

    public int hashCode(){
        return key.hashCode();
    }
}
