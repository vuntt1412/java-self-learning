/**
 * The default implementation of equals() says that each instance of the class is equal only to itself
 * and this is right thing to do if there is no need for the class to provide a "logical equality" test (e.g. Pattern class)
 * or a superclass has already overridden equals() and it's appropriate for its inherited classes
 * (e.g. most Set implementations inherit their equals implementation from AbstractSet)
 * <p>
 * <p>
 * In this example we'll consider problems when overriding equals(), we must adhere to its general contract:
 * reflexive: an object must equal itself
 * symmetric: x.equals(y) must return the same result as y.equals(x)
 * transitive: if x.equals(y) and y.equals(z) then also x.equals(z)
 * consistent: the value of equals() should change only if a property that is contained in equals() changes (no randomness allowed)
 */
package com.vuntt1412.equalsandhashcode;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("\nPlayer is a superclass uses instanceof-based equals method ");
        Player player1 = new Player("Cristiano");
        FootballPlayer footballPlayer = new FootballPlayer("Cristiano", "MU");

        System.out.println("violate symmetry");
        System.out.println(player1.equals(footballPlayer));
        System.out.println(footballPlayer.equals(player1)); //should be true

        System.out.println("try to fix the equals() but now violate transitivity");
        Player player2 = new Player("Nadal");
        TennisPlayer tennisPlayer1 = new TennisPlayer("Nadal", false);
        TennisPlayer tennisPlayer2 = new TennisPlayer("Nadal", true);
        System.out.println(tennisPlayer1.equals(player2));
        System.out.println(player2.equals(tennisPlayer2));
        System.out.println(tennisPlayer1.equals(tennisPlayer2));
        /**
         * In conclusion, there is no way to extend an instantiable class and add a value component while preserving the equals contract
         */


        System.out.println("\nPoint is a superclass uses getClass-based equals method ");
        List<Point> players = Arrays.asList(new Point(1, 2),
                new Point(3, 4),
                new Point(5, 10));
        Point p1 = new Point(1, 2);
        CounterPoint p2 = new CounterPoint(1, 2);

        System.out.println(players.contains(p1)); //nothing wrong here
        System.out.println(players.contains(p2)); //p2 not act as p1
        // However using a instanceof-based equals method works fine
        /**
         * In conclusion, an instance of a subclass of Point is still a Point, and it still needs to function as one,
         * but it fails to do so if you take getClass-based equals() approach!
         */

        System.out.println("Another example");
        List<Date> dateList = Arrays.asList(new Date(2323223232L));
        Date date = new Date(2323223232L);
        Timestamp timestamp = new Timestamp(2323223232L);
        System.out.println(dateList.contains(date));
        System.out.println(dateList.contains(timestamp));
        // This behavior of the Timestamp class was a mistake and should not be emulated(mixing them)

    }
}
