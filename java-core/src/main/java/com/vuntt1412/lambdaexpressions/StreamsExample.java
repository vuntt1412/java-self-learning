package com.vuntt1412.lambdaexpressions;

import static java.util.stream.Collectors.*;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * A stream pipeline consists of<p>
 * a source stream (the stream instance will not modify its source)<p>
 * followed by zero or more intermediate operations (return a new stream)<p>
 * and one terminal operation
 * <p>
 * Stream pipelines are evaluated lazily: doesn't start until the terminal operation is invoked,
 * and data elements that aren't required in order to complete the terminal operation are never computed
 */
public class StreamsExample {
    public static void main(String[] args) {

        System.out.println("Stream of primitives");
        IntStream intStream = new Random().ints(4, 0, 10);
        intStream.forEach(System.out::println);

        System.out.println("\nStream of String");
        Stream<String> stringStream = Pattern.compile(", ").splitAsStream("A, B, C, D");
        stringStream.forEach(System.out::println);
        //stringStream.collect(Collectors.toList());// throws exception because stream can't be reused

        List<Student> students = Arrays.asList(// Returns a fixed-size list backed by the specified array
                new Student("Nguyen", 7)
                , new Student("Joe", 4)
                , new Student("Cris", 9)
                , new Student("Lee", 7));

        System.out.println("\nfindFirst() vs findAny()");
        System.out.println(students.stream().findFirst().get());// returns strictly the first element of the stream
        System.out.println(students.parallelStream().findFirst().get());// the same as non-parallel
        System.out.println(students.stream().findAny().get()); // it will most likely return the first element in the stream, but there is NO GUARANTEE for this
        System.out.println(students.parallelStream().findAny().get());// free to select any element in the stream

        System.out.println("\nreduce() method");
        Boolean isAllPassed = students.stream()
                .map(Student::getScore)
                .map(s -> s >= 5)
                .reduce(true, (a, b) -> a && b);
        System.out.println(isAllPassed);

        System.out.println("\nCollectors examples");
        List<Student> unmodifiableStudents = students.stream().collect(toUnmodifiableList());
        // The same as List.of(students.toArray(new Student[]{}))
        // Elements cannot be added, removed, or replaced
        // However, if the contained elements are themselves mutable, this may cause the List's contents to appear to change
        System.out.println(unmodifiableStudents.get(0));
        students.get(0).setName("New name");
        System.out.println(unmodifiableStudents.get(0));

        // define a custom implementation
        students.stream().collect(toCollection(LinkedList::new));

        // groupingBy()
        Map<Integer, Set<Student>> map1 = students.stream()
                .collect(groupingBy(Student::getScore, toSet()));
        // partitioningBy() collects Stream elements into a Map that stores Boolean values as keys and collections as values
        Map<Boolean, List<Student>> map2 = students.stream()
                .collect(partitioningBy(s -> s.getScore() >= 5, toList()));
        // More examples on https://www.baeldung.com/java-groupingby-collector
    }

}
