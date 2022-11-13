package com.balazsholczer.linear;

public class App {

	public static void main(String[] args) {
		
		HashTable hashTable = new HashTable();
		
		hashTable.put(1, 10);
		System.out.println();

		hashTable.put(1, 100);
		System.out.println();

		hashTable.put(3, 1000);
		System.out.println();
		
		System.out.println(hashTable.get(1));
		
	}
}
