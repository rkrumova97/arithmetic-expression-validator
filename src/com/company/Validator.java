package com.company;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Pattern;

public class Validator {
    private String expression;

    public Validator(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public boolean isValid() {
        if (expression.contains("(")) {
            boolean parenthesis = checkParenthesis();
            if (!parenthesis) return false;
        }

        return Pattern.matches("^[a-z+\\-/*() ]*$", expression)
                && expression.matches("^[a-z\\-(]|.*[+*\\-/()]+.*")
                && expression.matches("^[a-z\\-(]|[a-z\\-(]+.*[a-z)]");
    }

    public boolean checkParenthesis() {
        Deque<Character> checker = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char x = expression.charAt(i);

            if (x == '(') {
                checker.push(x);
                continue;
            }

            if (x == ')' && checker.isEmpty()) return false;
            if (x == ')') checker.pop();
        }
        return checker.isEmpty();
    }
}
