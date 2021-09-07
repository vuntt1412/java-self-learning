package com.vuntt1412.lambdaexpressions;

public class BasicLambdaExpression {
    /**
     * This method belongs to a class, the problem is how to use it without using class/object? Just a piece of logic! A pure function!<p>
     * We can't do it with OOP but we can use a 'behavior' as arguments at least. Let's consider a method below:<p>
     * A fixed logic that always printing "Hello world!"
     */
    public void greet() {
        System.out.println("Hello world!");
    }

    /**
     * This one can get the params then implement the different logic<p>
     * hmm..seems good, but not enough! What about passing a behavior and then the method only performs it
     */
    public void greet(String param) {
        // do something
    }

    /**
     * In OOP programing, we can pass an instance which has a particular of the behavior we want<p>
     * ..better than the previous one, but the params are obviously associated with class and object
     * so we have to create a implementation of the interface which has a particular implementation of the logic
     */
    public void greet(Greeting greeting) {
        greeting.doSomething();
    }

    /**
     * assume that a function could be assigned to a variable, it looks like<p>
     * var = public void doSomething() {System.out.println("Hello world!");}<p>
     * remove what we don't need for a pure function then it should be<p>
     * var = () -> System.out.println("Hello world!");<p>
     * the question is What's type of var? That's created by the Interface! (e.g. TypeLambda)
     */
    public void greet(TypeLambda var) {
        var.foo();
    }

    public static void main(String[] args) {
        Hello hello = new Hello();
        hello.doSomething();// using interface implementation

        TypeLambda var = () -> System.out.println("Hello world!");
        var.foo();// using lambda expression
        /**
         * Notice that these ways are totally different, using lambda expression is just a function
         */
    }
}

/**
 * having one method which has exactly the same signature as the lambda var
 */
interface TypeLambda {
    void foo();
}

