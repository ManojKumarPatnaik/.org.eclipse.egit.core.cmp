package com.globalsoftwaresupport;

public class CountingSort {

	private static final int ITEMS = 10;
	private int[] data;
	
	public CountingSort(int[] data) {
		this.data = data;
	}
	
	public void sort() {
		
		// we need additional memory
		int[] output = new int[data.length];
		int[] count = new int[ITEMS];
		
		// we have to consider the items in the data in O(N)
		for(int i=0;i<data.length;++i)
			count[data[i]]++;
		
		// transform the count array into a cumulative array O(k)
		for(int i=1;i<count.length;++i)
			count[i] += count[i-1];
		
		// cumulative array to get the positions of the items in the original (data)
		// we have to consider the items in a reverse order O(N)
		for(int i=data.length-1;i>=0;--i) {
			count[data[i]]--;
			output[count[data[i]]] = data[i];
		}
		
		// sorted order in the output array O(N)
		for(int i=0;i<data.length;++i)
			data[i] = output[i];
	}

	public void showArray() {
		for(int num : data)
			System.out.print(" "+num);
	}
}
