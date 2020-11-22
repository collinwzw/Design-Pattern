import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;



class Solution373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // both array are sorted
        // we know the smallest value are in the begining of two arrays
        // nums1[0] + nums2[0] must be the smallest
        // we can define a minheap with size k
        // 
    	PriorityQueue<List<Integer>> pq =new PriorityQueue<>(k,(x, y) -> Integer.compare(x.get(0) + x.get(1), y.get(0) + y.get(1)));
    	
    	for (int i =0; i < nums1.length && i < k; i ++)
    	{

    			List<Integer> temp = new ArrayList<>();
    			temp.add(nums1[i]);
    			temp.add(nums2[0]);
    			temp.add(0);
    			pq.add(temp);

    	}
    	
    	List<List<Integer>> result = new ArrayList<>();
    	while(k-- > 0 && pq.size() > 0)
    	{
    		List<Integer> cur = pq.poll();
    		List<Integer> ret = new ArrayList<>();
    		ret.add(cur.get(0));
    		ret.add(cur.get(1));

    		result.add(ret);
    		if (cur.get(2) == nums2.length - 1) continue;
    		List<Integer> next = new ArrayList<>();
    		next.add(cur.get(0));
    		next.add(cur.get(1) + 1);
    		next.add(cur.get(2) + 1);
    		pq.offer(next);
    	}
    	return result;
    }
}



class Demo373
{
	public static void main(String[] args)
	{	
		int[] nums1 = {1,7,11};
		int[] nums2 = {2,4,6};
		Solution373 s = new Solution373();
		List<List<Integer>> r = s.kSmallestPairs(nums1,nums2,2);
		
		System.out.println();
		System.out.println("answer");
		for (List<Integer> element: r)
		{
			System.out.print(element + " ,");
		}
	}
	
	
}