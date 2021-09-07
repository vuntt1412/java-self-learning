package com.vuntt1412.mapinterface;

import java.util.*;

/**
 * <b>Hashing</b>: an algorithm to map object data to an integer value.
 * The hashing function is applied to the key object to calculate the index of the bucket in order to store and retrieve any key-value pair.<p>
 * The idea of calculating the index = keyValue.hashCode() mod lengthOfArray, which make sure that the index is in range of Array
 * <p>
 * <b>Capacity</b>: number of buckets in the HashMap - the default initial capacity is 16
 * <p>
 * <b>Threshold</b>: is the product of current capacity and load factor<p>
 * Load factor is the measure that decides when to increase the capacity (default is 0.75)
 * <p>
 * E.g. The threshold will be 16 * 0.75 = 12 (by default)
 * that means it will increase the capacity from 16 to 32(is doubled) after the 12th entry(key-value pair) is added
 * and it's time to rehash (recalculate the hashcode already stored in )
 * <p>
 * <b>Collisions</b>: when more than one key ends up in the same bucket and this may be caused by a bad hashCode() implementation.<p>
 * Prior to java 8, HashMap handles collision by using LinkedList by adding at the head of the LinkedList
 * that leads to increase time complexity to O(n),
 * to avoid this Java 8 supports a balanced tree instead to store collied entries so it improves from O(n) to O(log n)
 * and TREEIFY_THRESHOLD = 8 (by default) means if there are more than 8 elements in the same bucket, Map will use a tree to hold them
 */
public class HashMapExamples {


    /**
     * If the hashCode() is well-written, the entries will be distributed across all the buckets and we will avoid collision<p>
     * => HashMap stores and retrieves entries in constant time O(1), now we realize that with
     * lower load factor -> more free buckets -> lower chances of collision<p>
     * => help to achieve better time complexity but increase the space complexity of O(n) and the rehashing cost for each existing entry (obviously a very expensive process)
     * <p>
     * Besides, the higher space complexity of O(n) is good for a large number of entries coupled with little to no iteration
     * and lower one is good for few entries with a lot of iteration
     */
    public static void main(String[] args) {
        Map<String, Person> personMap = new HashMap<>();
        Person p1 = new Person("Nguyen", null);
        Person p2 = new Person("Tran", null);
        Person p3 = new Person("Tuan", null);
        Person p4 = new Person("Vu", null);

        // returns the previous value associated with the key, otherwise, it returns null
        personMap.put(p1.getName(), p1);
        personMap.put(p2.getName(), p2);
        personMap.put(p3.getName(), p3);
        personMap.put(p4.getName(), null);
        personMap.put(null, null); // accept a null key and null values
        // a null key is automatically assigned a final hash value of 0, which means it becomes the first element of the underlying array

        System.out.println("HashMap doesn't maintain the insertion order:");
        for (Map.Entry<String, Person> entry : personMap.entrySet()) { // a collection view of the entries
            System.out.println(entry.getKey());
        }
        System.out.println("LinkedHashMap may be an option If you want it!\n");

        // a collection view of the values
        Set<String> keys = personMap.keySet();
        // a collection view of the keys
        Collection<Person> values = personMap.values();
        System.out.println(
                "The iterators for the collection view are fail-fast so if any structural modification is made on the map," +
                        " after the iterator has been created, a concurrent modification exception will be thrown");
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            //personMap.remove("Vu"); // will throw ConcurrentModificationException
            System.out.println(it.next());
        }

        // The complexity to check if a key exists is O(1), while the complexity to check for an element is O(n)
        personMap.containsKey("Nguyen");
        personMap.containsValue(new Person("Nguyen", null));

    }

}
