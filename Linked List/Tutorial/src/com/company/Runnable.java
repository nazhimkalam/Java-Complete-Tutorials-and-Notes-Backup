package com.company;

public class Runnable {

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.insert("14");
        linkedList.insert("Nazhim");
        linkedList.insert("95");
        linkedList.insertAt(3,"544");
        linkedList.insertingAtHead("hello");
        linkedList.deleteAt(2);
        linkedList.deleteAt(1);
        linkedList.show();
    }
}
