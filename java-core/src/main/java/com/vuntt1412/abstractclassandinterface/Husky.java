package com.vuntt1412.abstractclassandinterface;

/**
 * Abstract classes/Interfaces cannot be instantiated.
 * <p>
 * Abstract classes/Interfaces cannot be marked final.
 * <p>
 * <p>
 * Abstract classes may include zero or more abstract methods, and nonabstract methods-must have body part.
 * <p>
 * Interfaces may include zero or more abstract methods.
 */
abstract class Husky {
    // will not compile if the play() method is not marked abstract
    abstract void play(); // assumed to be default
}

interface Poodle {
    void play(); // assumed to be abstract and public

    int var = 1; // assumed to be public, static, and final.

    default void test() {
        // method with a body must be marked default, private, static, or private static
    }
}

class Webby extends Husky {
    void play() {
    }
}

class Georgette implements Poodle {
    // must to be public
    public void play() {
    }
}

// An abstract class allows you to create functionality that subclasses can implement or override.
// An interface only allows you to define functionality, not implement it.
// And whereas a class can extend only one abstract class, it can take advantage of multiple interfaces.

// A general rule of when to use abstract class and interface is
// to find out whether a certain class will form a IS-A hierarchy or CAN-DO-THIS hierarchy.
// If you know that you will be creating classes e.g. Circle, Square than it's better to create an abstract class Shape which can have area() and perimeter() as abstract method,
// rather than defining Shape as interface in Java.
// On the other hand if you are going to create classes which can do thinks like, can fly, you can use interface Flyable instead of abstract class.

// Interface also provide more decoupling than abstract class because interface doesn't contain any implementation detail,
// while abstract class may contain default implementation which may couple them with other class or resource.