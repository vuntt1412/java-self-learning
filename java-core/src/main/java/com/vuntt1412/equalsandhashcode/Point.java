package com.vuntt1412.equalsandhashcode;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    /**
     * hashCode() contract:
     * internal consistency: must return the same value during the execution of an application
     * equals consistency: if two objects are equal according the equals() then calling hashCode() on the two objects must produce the same integer result
     * collisions: but unequal objects may have the same hashCode value (relevant to collision in Hashtable)
     * @return
     */
    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
