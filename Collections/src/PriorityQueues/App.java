package PriorityQueues;

import java.util.PriorityQueue;
import java.util.Queue;

public class App {

    public static void main(String[] args) {

        // primitive types
//        Queue<String> pQueue = new PriorityQueue<>();
//
//        pQueue.add("F");
//        pQueue.add("C");
//        pQueue.add("Z");
//        pQueue.add("A");
//
//        System.out.println(pQueue.remove());
//        System.out.println(pQueue.remove());
//        System.out.println(pQueue.remove());
//        System.out.println(pQueue.remove());

        // custom objects
        Queue<Person> queue = new PriorityQueue<>();
        queue.add(new Person("Balazs", 55));
        queue.add(new Person("Adam", -1));
        queue.add(new Person("Joe", 123));
        queue.add(new Person("Agi", 37));
        
        // O(logN)

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

    }
}
