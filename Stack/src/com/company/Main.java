package com.company;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(15);
        stack.push(10);
        stack.push(999);

        System.out.println(stack.peek() + " this is the peek value");
        stack.pop();

        stack.show();
    }
}
