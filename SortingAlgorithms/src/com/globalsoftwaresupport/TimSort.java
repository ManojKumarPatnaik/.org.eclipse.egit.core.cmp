package com.globalsoftwaresupport;

public class TimSort {

	private int[] nums;
    private int[] tempArray;

    public TimSort(int[] nums) {
        this.nums = nums;
        this.tempArray = new int[nums.length];
    }
    
    public void sort() {
    	mergeSort(0, nums.length-1);
    }
    
    private void mergeSort(int low, int high) {

        if (high - low <= 32) {
            insertionSort(low, high);
            return;
        }

        int middle = (low + high) / 2;

        mergeSort(low, middle);
        mergeSort(middle + 1, high);
        merge(low, middle, high);
    }

    private void insertionSort(int low, int high) {
		
		for(int i=low+1;i<=high;++i) {
			
			int j = i;
			
			while(j>low && nums[j-1]>nums[j]) {
				swap(j-1, j);
				j--;
			}
		}
	}

	private void swap(int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

    private void merge(int low, int middle, int high) {

        for (int i = low; i <= high; i++)
            tempArray[i] = nums[i];

        int i = low;
        int j = middle + 1;
        int k = low;
        
        while ((i <= middle) && (j <= high)) {
            if (tempArray[i] <= tempArray[j]) {
                nums[k] = tempArray[i];
                i++;
            } else {
                nums[k] = tempArray[j];
                j++;
            }
            
            k++;
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
        for (int i = 0; i < nums.length; ++i) {
            System.out.print(nums[i] + " ");
        }
    }
}
