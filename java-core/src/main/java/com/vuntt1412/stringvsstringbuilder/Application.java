package com.vuntt1412.stringvsstringbuilder;

/**
 * OCP Oracle Certified Professional Java SE 11 Programmer I Study Guide: Exam 1Z0-815
 * <p>
 * Chapter 5
 */
public class Application {
    public static void main(String[] args) {

        // A Strategy for Defining Immutable Objects
        // https://docs.oracle.com/javase/tutorial/essential/concurrency/imstrat.html

        // String is immutable
        String a = "abc";
        String b = a.toUpperCase();
        b = b.replace("B", "2").replace('C', '3');
        System.out.println("a=" + a);
        System.out.println("b=" + b);

        // The intern() method returns the value from the string pool if it is there.
        // Otherwise, it adds the value to the string pool.

        // StringBuilder is not immutable
        StringBuilder c = new StringBuilder("abc");
        StringBuilder d = c.append("de");
        d = d.append("f").append("g");
        System.out.println("c=" + c);
        System.out.println("d=" + d);

        // https://www.baeldung.com/java-compile-time-constants#class-constants
        // The string pool contains literal values ,and class constants, and compile-time constants that appear in your program.
        // For example, "name" is a literal and therefore goes into the string pool.
        // myObject.toString() is a string but not a literal, so it does not go into the string pool.

        String singleString = "hello world";
        String oneLine = "hello " + "world";
        System.out.println(singleString == oneLine);

        String first = "rat" + 1;
        String second = "r" + "a" + "t" + "1";
        String third = "r" + "a" + "t" + new String("1"); // is computed at runtime
        System.out.println(first == second);
        System.out.println(first == second.intern());
        System.out.println(first == third);
        System.out.println(first == third.intern());

    }
}
