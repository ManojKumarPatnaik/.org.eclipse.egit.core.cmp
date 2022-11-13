package Maps;

import java.util.Map;
import java.util.TreeMap;

/**
 * There are 3 classes that implements the Map interface --> they have approximately the same functionality except 
 * 		for some little differences
 *
 * 1.) HashMap: this is usually "the map", so we are able to store key-value pairs, and able to find the value 
 * 		according to the key in O(1) if the hash function is perfect/good
 *
 * 			PROBLEM: makes no guarantee about the order of iteration 
 * 				There is no ordering --> the iteration order can change when new items are added !!!
 *
 * 2.) TreeMap: it supports ordering --> natural ordering, so numerical ordering for numbers alphabetical 
 * 		ordering for strings and characters compareTo() method or Comparator is important 
 * 			~ to be able to decide the order !!!
 *
 * 3.) LinkedHashMap: it contains a doubly linked list connecting all the entries in the map 
 * 			It can provide the so-called insertion-order: so unlike HashMap it can provide the order 
 * 				in which keys were inserted into a map ~ insertion order is not affected if a key is
 * 					re-inserted into the map
 *
 * 				IMPORTANT: they consume more memory than HashMap !!!
 */

public class App {

    public static void main(String[] args) {

        Map<String, Integer> map = new TreeMap<>();
        map.put("Adam", 34);
        map.put("Joe", 12);
        map.put("Noel", 76);
        map.put("Michael", 23);

        System.out.println(map);

    }
}
