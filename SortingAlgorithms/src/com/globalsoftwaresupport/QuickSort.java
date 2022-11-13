package com.globalsoftwaresupport;

public class QuickSort {

	private int[] nums;
	
	public QuickSort(int[] nums) {
		this.nums = nums;
	}
	
	public void sort() {
		sort(0, nums.length-1);
	}
	
	private void sort(int low, int high) {
		
		// base-case
		if(high<low) return;
		
		// pivot item is in its sorted position
		int pivot = partition(low, high);
		// method recursively (left and right)
		sort(low, pivot-1);
		sort(pivot+1, high);		
	}

	// return the index of the pivot
	private int partition(int low, int high) {
		
		// this is the index of the pivot
		int middleItem = (low+high)/2;
		
		// swap the pivot with the last item
		swap(middleItem, high);
		
		int i = low;
		
		for(int j=low;j<high;++j)  {
			if(nums[j]<=nums[high]) {
				swap(i,j);
				++i;
			}
		}
			
		// swap back the pivot (middle item)
		swap(i, high);
		
		return i;
	}
	
	private void swap(int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public void showArray() {
		for(int i=0;i<nums.length;++i)
			System.out.print(nums[i]+" ");
	}
}
