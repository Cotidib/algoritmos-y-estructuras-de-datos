package com.example;

public class Par<K,V> {

  private K key = null;
  private V value = null;

  public Par(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public K getKey() { return key; }
  public V getValue() { return value; }
  
}
