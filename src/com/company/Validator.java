package com.company;

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
        if (!Pattern.matches("^[a-z+\\-/*() ]*$", expression)) {
            return false;
        } else if (!expression.matches("^[a-z\\-(]|.*[+*\\-/()]+.*")) {
            return false;
        } else return expression.matches("^[a-z\\-(]|[a-z\\-(]+.*[a-z)]");
    }
}
