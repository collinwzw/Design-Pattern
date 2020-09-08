class Solution34 {
//    public int[] searchRange(int[] nums, int target) {
//        // partition
//        // choose a pivot, go through the array, put all element that are smaller than this pivot value in the left side, bigger to the right side
//        
//        // we need two pointers left and right
//        
//        // both pointers starting from the index 0
//        // left: move when the current value it pointing at is smaller then pivot value. if the value is equal or bigger, then waiting
//        
//        // right: move when the current value it pointing at is smaller then pivot value. if the value is equal or bigger, then waiting
//        
////        int count = 0;
////        for (int i = 0; i< nums.length; i++)
////        {
////            if (nums[i] == target)
////            {
////                swap(nums, i, nums.length - 1);
////                count++;
////            }
////        }
////        
////        
////        int left = 0;
////        for(int i=0; i < nums.length; i++)
////        {
//// 
////            
////            if (nums[i] < target)
////            {
////                swap(nums, left, i);
////                left ++;
////            }
////            
////            
////        }
////        int[] result = {left, left+count -1};
////        return result;
////    }
////    
////    public void swap(int[] array, int i, int j)
////    {
////        int temp = array[i];
////        array[i] = array[j];
////        array[j] = temp;
//    	
//    	//Binary search we can easily find one of the index
//    	// how do we can the end index?
//    	
//    	
//    }
    
    public int[] searchRange(int[] nums, int target) {
        // partition
        // choose a pivot, go through the array, put all element that are smaller than this pivot value in the left side, bigger to the right side
        
        // we need two pointers left and right
        
        // both pointers starting from the index 0
        // left: move when the current value it pointing at is smaller then pivot value. if the value is equal or bigger, then waiting
        
        // right: move when the current value it pointing at is smaller then pivot value. if the value is equal or bigger, then waiting
     
        int[] result = {-1,-1};
        
        int leftIndex = findIndex(nums, target, true);
        
        if (leftIndex == nums.length || nums[leftIndex] != target)
        {
            return result;
        }
        
        result[0] = leftIndex;
        result[1] = findIndex(nums, target, false)-1;
        return result;
    }
    
    public int findIndex(int[] nums, int target, boolean left)
    {   
        int lo = 0;
        int hi = nums.length;
        
    	while (lo <hi)
        {
            int mid = (lo + hi)/2;
            if ((nums[mid]> target) || (left && target == nums[mid]))
            {
                hi = mid;
            }
            else
            {
                lo = mid + 1;
            }
        }
        return lo;
    }
}

class Demo34
{
	public static void main(String[] args)
	{
		int[] nums = {5,7,7,8,8,10};
		Solution34 s = new Solution34();
		int[] r = s.searchRange(nums, 8);
		for (int element: r)
		{
			System.out.print(element + " ,");
		}
	}
}