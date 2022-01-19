package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        List<String> s = new ArrayList<>();

        s.add("john-Max");
        s.add("a+");
        s.add("a++%b");
        s.add("*a");
        s.add("ab");

        s.add("a + b - c");
        s.add("a+b");
        s.add("a+b/c");
        s.add("(a+b)*c");
        s.add("-a");
        s.add("a");

        for (String exp : s) {
            Validator validator = new Validator(exp);
            System.out.println(validator.getExpression() + ": " + validator.isValid());
        }
    }
}
