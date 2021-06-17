import java.util.ArrayList;
import java.util.List;

class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempResult = new ArrayList<Integer>();
        helper(candidates, target, candidates.length - 1, tempResult, result);
        return result;
    }
    
    
    // brute force way
    // loop through all index from combinationSum array
    // starting from the end of list to begining of list
    // for each starting index i, only consider the sub list from 0 to i as possible combination array and try to get the sum equals target, for each number beteween 0 to i
    
    
    //back trackng
    // with help of recursive function,
    // for each index we can either choose to take or not take if currentSum < target
    
    
    public void helper(int[] candidates, int target, int currentIndex, List<Integer> tempResult, List<List<Integer>> result){
        // base case, if we got the target, we add it to the result
        if(target == 0){
            result.add(tempResult); 
            return;
        }
        if(currentIndex < 0) return;
        
        if(target < candidates[currentIndex]) {
            helper(candidates, target, currentIndex - 1, new ArrayList(tempResult), result);
        }else{
           // we can either choose to take or not
            helper(candidates, target, currentIndex - 1, new ArrayList(tempResult), result );
            tempResult.add(candidates[currentIndex]);
            helper(candidates, target - candidates[currentIndex], currentIndex, tempResult, result );

        }
        
    }
}


class Demo39
{
	public static void main(String[] args)
	{	
		
		int [] candidates = new int[] {2,3,6,7};
		Solution39 s = new Solution39();


		List<List<Integer>> r =s.combinationSum(candidates, 7);
		System.out.println(r);
	}
}