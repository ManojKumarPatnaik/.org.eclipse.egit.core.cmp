package com.globalsoftwaresupport;

public class MergeSort {

	private int[] nums;
	// merge sort is not an in-place algorithm
	private int[] tempArray;
	
	public MergeSort(int[] nums) {
		this.nums = nums;
		this.tempArray = new int[nums.length];
	}
	
	public void sort() {
		mergeSort(0, nums.length-1);
	}
	
	// DIVIDE AND CONQUER APPROACH
	private void mergeSort(int low, int high) {
		
		// base-case
		if(low >= high)
			return;
		
		// middle item
		int middleIndex = (low+high)/2;
		
		// we keep splitting the problem into smaller and smaller sub-problems
		// until a given array contains just 1 item
		mergeSort(low, middleIndex);
		mergeSort(middleIndex+1, high);
		
		// we have to combine the sub-solutions
		merge(low, middleIndex, high);
	}

	private void merge(int low, int middle, int high) {
		
		// copy the items into the temporary array
		for(int i=low;i<=high;++i)
			tempArray[i] = nums[i];
		
		int i = low;
		int j = middle + 1;
		int k = low;
		
		// we consider the temp array and copy the items into the nums
		while(i<=middle && j<=high) {
			if(tempArray[i] < tempArray[j]) {
				nums[k] = tempArray[i];
				++i;
			} else {
				nums[k] = tempArray[j];
				++j;
			}
			
			++k;
		}
		
		// we have to copy the items from the left sub-array (if there are any)
		while(i<=middle) {
			nums[k] = tempArray[i];
			++k;
			++i;
		}
		
		// we have to copy the items from the right sub-array (if there are any)
		while(j<=high) {
			nums[k] = tempArray[j];
			++k;
			++j;
		}
	}

	public void showArray() {
		for(int i=0;i<nums.length;++i)
			System.out.print(nums[i]+" ");
	}
	
	private void swap(int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
