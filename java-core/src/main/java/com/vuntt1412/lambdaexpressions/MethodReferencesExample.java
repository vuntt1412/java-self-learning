package com.vuntt1412.lambdaexpressions;

import java.util.Arrays;
import java.util.List;

/**
 * These structures can be replaced by method references<p>
 * () -> method()<p>
 * v -> method(v)<p>
 * (a, b) -> method(a, b)<p>
 * Where method references are shorter and clearer, use them; where they aren't, stick with lambdas!
 */
public class MethodReferencesExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> System.out.println("Calling by a lambda expression!"));
        t1.run();

        // Static method references type
        // Integer::parseInt str
        // Integer.parseInt(str)
        Thread t2 = new Thread(MethodReferencesExample::printMessage);
        t2.run();


        // Bound method references type, which are similar in nature to static references: the function object takes the same arguments as the referenced method
        // Instant.now()::isAfter
        // Instant then = Instant.now();
        // t -> then.isAfter(t)
        StudentComparator studentComparator = new StudentComparator();
        List<Student> students = Arrays.asList(
                new Student("Nguyen", 6)
                , new Student("Joe", 4)
                , new Student("Cris", 9)
                , new Student("Lee", 7));
        students.sort(studentComparator::compare);// equivalent to (s1, s2) -> studentComparator.compare(s1, s2)
        students.stream().map(s -> s.getScore()).forEach(System.out::println);


        // Unbound method references type. E.g. (arg0, rest) -> arg0.instanceMethod(rest) with arg0 is of type ClassName
        // String::toLowerCase
        // str -> str.toLowerCase()
        students.stream().map(Student::getScore).sorted(Integer::compareTo);// (a, b) -> a.compareTo(b)


        // Array constructor method references type
        // int[]::new
        // len -> new int[len]

        // Class constructor method references type
        // TreeMap<K,V>::new
        // () -> new TreeMap<K,V>
        int[] ints = {1, 2, 3};
        Arrays.stream(ints).boxed().toArray(Integer[]::new);

    }

    public static void printMessage() {
        System.out.println("Calling by a method reference!");
    }
}
