package com.vuntt1412.compiletimeconstants;

public class ConstantExpressions {
    public static final String CONSTANT = "hello";

    public static void main(String[] args) {
        /*
         * String literal
         * */
        String s = "helloWorld";
        String s1 = "hello" + "World";

        /*
         * Constant Expressions are
         * expressions that contain constant variables and certain operations
         * https://docs.oracle.com/javase/specs/jls/se7/html/jls-15.html#jls-15.28
         * */
        String s2 = CONSTANT + "World";

        String s3 = "hello";
        String s4 = s3 + "World"; // not a constant expression

        /* Compile-time constant variable must be
         * a primitive or String variable,
         * declared final,
         * initialized within its declaration and
         * initialized with a constant expression */
        final String s5 = "hello";
        String s6 = s5 + "World";

        // a long string literal can be broken up into short pieces and written as a expression using the string concatenation operator (+)
        System.out.println(s == s1);

        // compile-time constant expressions of type String are always "interned" so as to share unique instances
        System.out.println(s == s2);
        System.out.println(s == s4);
        System.out.println(s == s6);
    }
}
