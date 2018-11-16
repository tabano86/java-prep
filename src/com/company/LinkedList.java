package com.company;

class LinkedList<T> {
    private Node first;
    private Node last;

    LinkedList() {
        first = null;
        last = null;
    }

    void add(T value) {
        if (first == null) {
            first = new Node(value);
            last = first;
        } else {
            last.next = new Node(value);
            last = last.next;
        }
    }

    void reverse() {
        Node next = null;
        Node current = first;
        Node prev = null;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        last = first;
        first = prev;
    }

    void removeAt(Integer position) {
        Node prev = new Node();
        Node current = new Node();
        prev.next = first;
        current = first;
        Integer counter = -1;

        while (current.next != null) {
            if (counter.equals(position)) {
                prev.next = current.next;
                return;
            }
            prev = prev.next;
            current = current.next;
            counter++;
        }
    }


    class Node {
        Node next;
        T value;

        Node () {}

        Node(T value) {
            this.value = value;
        }
    }
}
