package com.globalsoftwaresupport;

public class App {

	public static void main(String[] args) {
		
		int[] nums = {1, 2, 3};
		
		QuickSortIteration sort = new QuickSortIteration(nums);
		sort.sort();
		sort.showArray();
	}
}
