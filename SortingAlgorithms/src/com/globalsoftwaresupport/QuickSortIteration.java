package com.globalsoftwaresupport;

import java.util.Stack;

public class QuickSortIteration {

	private int[] nums;

    public QuickSortIteration(int[] nums) {
        this.nums = nums;
    }
    
    public void sort() {
        
    	Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(nums.length-1);

        while (!stack.isEmpty()) {
            
        	int high = stack.pop();
            int low = stack.pop();
            
            int pivotIndex = partition(low, high);

            // dealing with the right side (not with recursion)
            if(pivotIndex+1<high) {
            	stack.push(pivotIndex + 1);
                stack.push(high);	
            }
            
            // dealing with the left side
            if(pivotIndex-1>low) {
            	stack.push(low);
                stack.push(pivotIndex-1);	
            }        
        }
    }

    private int partition(int low, int high) {

        int pivotIndex = (low + high) / 2; 
        swap(pivotIndex, high);   

        int i = low;

        for (int j = low; j < high; ++j) {
            if (nums[j] <= nums[high]) {
                swap(i, j);
                i++;
            }
        }

        swap(i, high);

        return i;
    }
    
    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void showArray() {
        for (int i = 0; i < nums.length; ++i) {
            System.out.print(nums[i] + "  ");
        }
    } 
}
