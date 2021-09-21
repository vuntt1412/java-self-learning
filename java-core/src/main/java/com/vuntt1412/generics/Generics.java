package com.vuntt1412.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Stronger type checks at compile time
 * <p>
 * Elimination of casts
 * <p>
 * Enabling to implement generic algorithms
 */
public class Generics {
    public static void main(String[] args) {
        // Before generics
        List l1 = new ArrayList();
        l1.add("List");
        l1.add(123);// not type-safe
        String s1 = (String) l1.get(0);// have to cast every object we read from

        // With generics
        List<String> l2 = new ArrayList<>();
        l2.add("List");
        String s2 = l2.get(0);
        /*
        * The Java compiler applies type erasure so they are compiled into the same as pre-generics code
        List l2 = new ArrayList();
        l2.add("List");
        String s2 = (String) l2.get(0);
        */

        // With type erasure you get:
        // compile-time safety check
        // backward compatibility with old Java
        // no type information at runtime :(

        // Reification is the opposite of Type Erasure, it is the process of making type information available at runtime
        // e.g. primitives, raw type, non-generic class...
        String[] strArray = {"a", "b"};
        Object[] objArray = strArray;
        System.out.println(objArray.getClass()); // objArray is reified to String[]
        Number number = 1;
        System.out.println(number.getClass()); // number is reified to Integer

        // But l2 is not reified to ArrayList<String>
        System.out.println(l2.getClass());
        // That's why we can't overload methods having same erasure (List<String> and List<Integer>)

        // Item 26: Don't use raw types
        // Raw types can cause heap pollution which happens
        // when a variable of type X doesn't reference X or its subclass, but references Y
        List intList = new ArrayList<Integer>();// raw type warning
        intList.add(3);
        List<String> strList = intList;// no warning
        String x = strList.get(0); // Exception: ClassCastException
    }
}
