package ru.nightmare.code.tree;

import java.util.Stack;

public class Interpreter {
    public static int findClosingTokenIndex(String input, int openingIndex, char openingToken, char closingToken) {
        Stack<Character> stack = new Stack<>();

        for (int i = openingIndex; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == openingToken) {
                stack.push(currentChar);
            } else if (currentChar == closingToken) {
                if (stack.isEmpty()) {
                    return i;
                }
                stack.pop();
            }
        }

        return -1; // Закрывающий токен не найден
    }
}
