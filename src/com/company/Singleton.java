package com.company;

public class Singleton<T> {
    private static Singleton single_instance = null;
    Singleton() {}
    T value;
    static Singleton getInstance() {
        if (single_instance == null) {
            single_instance = new Singleton();
        }
        return single_instance;
    }
}
