package lesson3;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        String s = "This string must be inverted!";
        System.out.println(s);

        s = invertString(s);
        System.out.println(s);
    }

    private static String invertString(String s) {
        MyStack<Character> q = new MyStack<>(s.length());
        for (char c : s.toCharArray()) {
            q.push(c);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            sb.append(q.pop());
        }

        return sb.toString();
    }
}