package com.vuntt1412.equalsandhashcode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * This class is just to keep track of how many instances have been created
 * In Liskov substitution principle, the objects of CounterFootballPlayer should behave in the same way as the objects of superclass(Player)
 */
public class CounterPoint extends Point {
    private static final AtomicInteger counter = new AtomicInteger();

    public CounterPoint(int x, int y) {
        super(x, y);
        counter.incrementAndGet();
    }
}
