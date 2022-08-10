package com.vuntt1412.singleton;

/**
 * Add a private static field to the class for storing the singleton instance
 * <p>
 * Declare a public static creation method for getting the singleton instance
 * <p>
 * Implement “lazy initialization” inside the static method. It should create a new object on its first call and put it into the static field. The method should always return that instance on all subsequent calls
 * <p>
 * Make the constructor of the class private. The static method of the class will still be able to call the constructor, but not the other objects
 * <p>
 * Go over the client code and replace all direct calls to the singleton’s constructor with calls to its static creation method
 */
class Singleton {
    private static Singleton instance;
    private String data = "testData";

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }

    private Singleton() {
    }

}

class App {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1 == instance2);
    }
}
