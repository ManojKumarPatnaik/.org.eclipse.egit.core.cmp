package com.globalsoftwaresupport;

import java.util.Arrays;

public class RadixSort {

	// this is the size of the count array (cumulative array)
	private static final int ITEMS = 10;
	private int[] data;
	
	public RadixSort(int[] data) {
		this.data = data;
	}
	
	public void sort() {
		
		// we have to make as many iterations as the number of digits
		// in the largest item of the dataset
		
		int place = 1;
		
		for(int i=0;i<getmaxDigit();++i) {
			countingSort(place);
			place *= 10;
		}
	}
	
	public void countingSort(int place) {
		
		// we need additional memory
		int[] output = new int[data.length];
		int[] count = new int[ITEMS];
		
		// we have to consider the items in the data in O(N)
		for(int i=0;i<data.length;++i)
			count[(data[i]/place) % ITEMS]++;
		
		// transform the count array into a cumulative array O(k)
		for(int i=1;i<count.length;++i)
			count[i] += count[i-1];
		
		// cumulative array to get the positions of the items in the original (data)
		// we have to consider the items in a reverse order O(N)
		for(int i=data.length-1;i>=0;--i) {
			count[(data[i]/place) % ITEMS]--;
			output[count[(data[i]/place) % ITEMS]] = data[i];
		}
		
		// sorted order in the output array O(N)
		for(int i=0;i<data.length;++i)
			data[i] = output[i];
	}
	
	private int getmaxDigit() {
		// find the max item in the dataset
		int maxItem = Arrays.stream(data).max().getAsInt();
		// have to calculate the number of digits
		return String.valueOf(maxItem).length();
	}

	public void showArray() {
		for(int num : data)
			System.out.print(" "+num);
	}
}
