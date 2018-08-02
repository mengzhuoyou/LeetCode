package com.company;

import java.util.Stack;

public class Leetcode_ExpressionExpand {
    public static class Element {
        int num;
        String str;

        Element(int num) {
            this.num = num;
        }
        Element(String str) {
            this.str = str;
        }
    }

    public static String expressionExpand(String s) {
        Stack<Element> stack = new Stack<>();
        int number = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)){
                number = number * 10 + c - '0';
            } else if (c == '[') {
                stack.push(new Element(number));
                number = 0;
            } else if (c == ']') {
                String newStr = popStack(stack);
                // popStack() will pop the string elemnts in the stack before we meet a number
                Element elem = stack.pop();
                for (int i = 0;i < elem.num; i++) {
                    stack.push(new Element(newStr));
                }
            } else {
                stack.push(new Element(String.valueOf(c)));
            }
        }

        return popStack(stack);
    }

    public static String popStack(Stack<Element> stack) {
        Stack<String> buffer = new Stack<>();

        while (!stack.isEmpty() && stack.peek().str != null) {
            buffer.push(stack.pop().str);
        }

        StringBuilder sb = new StringBuilder();
        while (!buffer.isEmpty()) {
            sb.append(buffer.pop());
        }

        return sb.toString();
    }

    public static void main (String[] args) {
        String[] s = new String[] {"3[abc]", "abc3[a]", "4[ac]dy", "3[2[ad]2[cd]m]xyz","12[a2[bc]]"};

        for (String tmp : s)
            System.out.println(expressionExpand(tmp));
    }
}
