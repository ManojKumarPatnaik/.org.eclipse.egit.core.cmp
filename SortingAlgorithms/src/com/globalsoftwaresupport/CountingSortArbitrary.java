package com.globalsoftwaresupport;

import java.util.Arrays;

public class CountingSortArbitrary {

	private int[] data;
	private int max;
	private int min;
	
	public CountingSortArbitrary(int[] data) {
		this.data = data;
		this.min = Arrays.stream(data).min().getAsInt();
		this.max = Arrays.stream(data).max().getAsInt();
	}
	
	public void sort() {
		
		// we need additional memory
		int[] output = new int[data.length];
		int[] count = new int[max-min+1];
		
		// we have to consider the items in the data in O(N)
		for(int i=0;i<data.length;++i)
			count[data[i]-min]++;
		
		// transform the count array into a cumulative array O(k)
		for(int i=1;i<count.length;++i)
			count[i] += count[i-1];
		
		// cumulative array to get the positions of the items in the original (data)
		// we have to consider the items in a reverse order O(N)
		for(int i=data.length-1;i>=0;--i) {
			count[data[i]-min]--;
			output[count[data[i]-min]] = data[i];
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
