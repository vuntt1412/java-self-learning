package com.vuntt1412.lambdaexpressions;

import java.io.IOException;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.IntConsumer;

public class HandlingExceptionsExample {

    private static void dividedByKey(int[] array, int key, BiFunction<Integer, Integer, Integer> function) {
        for (int i : array) {
            System.out.println(function.apply(i, key));
        }
    }

    private static BiFunction<Integer, Integer, Integer> wrapperBiFunction(BiFunction<Integer, Integer, Integer> function) {
        return (v, k) -> {
            try {
                System.out.println("Using wrapper lambda");
                return function.apply(v, k);// return a new lambda which does the same as lambda passed in
            } catch (ArithmeticException e) {
                System.out.println("Exception in wrapper lambda");
                return -1;
            }
        };
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        int key = 0;

        // using a traditional try-catch inside lambda
        dividedByKey(array, key, (v, k) -> {
            try {
                return (v % k == 0) ? v : null;
            } catch (ArithmeticException e) {
                return -1;
            }
        });

        // using wrapper lambda that will be responsible for handling the exception
        dividedByKey(array, key, wrapperBiFunction((v, k) -> (v % k == 0) ? v : null));

        System.out.println("\nLet's see what happens in two methods below");

        System.out.println("Normal case, just handle a checked Exception by try-catch statements");
        try {
            methodThrowingCheckedException(array);
        } catch (IOException e) {
            System.out.println("Caught the checked exception!");
        }

        System.out.println("Handling a checked exception throwing inside lambda");
        methodHavingCheckedExceptionInsideLambda(array);

    }

    private static void methodThrowingCheckedException(int[] array) throws IOException {
        for (int i : array) {
            throw new IOException();
        }
    }

    /**
     * We are not allowed to throw checked exceptions here because the accept(int value) method in the IntConsumer interface doesn't declare any exceptions in its throws clause<p>
     * The idea is creating a new functional interface to be able to throw checked exceptions as we want then using it as target type for the lambda
     */
    private static void methodHavingCheckedExceptionInsideLambda(int[] array) {
        Arrays.stream(array).forEach(wrapperIntConsumer(i -> {
            throw new IOException();// will get an error: Unhandled exception: java.io.IOException if this checked exception is not handled (using wrapperIntConsumer)
        }));
    }

    private static IntConsumer wrapperIntConsumer(IntConsumerWithCheckedException function) {
        return (i) -> {
            try {
                function.accept(i);
            } catch (IOException e) {
                System.out.println("Caught the checked exception!");
            }
        };
    }

}

interface IntConsumerWithCheckedException {
    void accept(int value) throws IOException;
}