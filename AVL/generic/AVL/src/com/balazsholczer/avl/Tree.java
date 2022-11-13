package com.balazsholczer.avl;

public interface Tree<T> {
	public void insert(T data);
	public void traverse();
	public void delete(T data);
}
