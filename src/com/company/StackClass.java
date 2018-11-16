package com.company;

public class StackClass {
    private Integer top;
    private Integer maxSize;
    private Integer[] stackArray;

    public StackClass(Integer size) {
        maxSize = size;
        stackArray = new Integer[size];
        top = -1;
    }

    Integer push(Integer value) {
        return stackArray[top++];
    }

    Integer pop(Integer value) {
        return stackArray[top--];
    }

    Boolean isEmpty() {
        return (top == -1);
    }

    void print() {
        for (int i = 0; i < top; i++) {
            System.out.print(stackArray[i] + " ");
        }
    }
}
