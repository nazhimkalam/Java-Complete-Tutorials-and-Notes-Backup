package com.company;

public class MyLinkedList {

    public Node head;

    // inserting data at the end
    public void insert(String data) {
        Node node = new Node();
        node.data = data;
        node.next = null;

        if(head == null) {
            head = node;
        }else {
            Node n = head;
            while(n.next != null){
                n = n.next;
            }
            n.next = node;
        }
    }

    // inserting data at the head
    public void insertingAtHead(String data){
        Node node = new Node();
        node.data = data;
        node.next = null;
        node.next = head;
        head = node;
    }

    // inserting data at any location
    public void insertAt(int index, String data){
        Node node = new Node();
        node.data = data;
        node.next = null;

        if(index == 0){
            insertingAtHead(data);
        }else {
            Node n = head;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            node.next = n.next;
            n.next = node;
        }
    }

    // delete an element at
    public void deleteAt(int index){
        if(index==0){
            head = head.next;
        }else{
            Node n = head;
            Node n1 = null;

            for (int i = 0; i < index-1; i++) {
                n = n.next;
            }
            n1 = n.next;
            n.next = n1.next;
        }
    }
    // displaying data
    public void show() {
        Node node = head;
        do{
            System.out.println(node.data);
            node = node.next;
        }while (node.next != null);
        System.out.println(node.data);
    }
}
