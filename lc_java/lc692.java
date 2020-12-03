import java.util.*;
class Solution692 {
    public List<String> topKFrequent(String[] words, int k) {
        //using priority queue to implement max freq heap
        // 
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < words.length; i++){
            if (!map.containsKey(words[i])){
                map.put(words[i], 1);
            }
            else{
                map.put(words[i], map.get(words[i]) + 1);
            }
        }
//        for (int i = 0; i < words.length; i++){
//            if(map.containsKey(words[i]))
//                map.put(words[i], map.get(words[i])+1);
//            else
//                map.put(words[i], 1);
//        }
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                 (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
        );
        
        for(Map.Entry<String, Integer> element: map.entrySet()){
        	System.out.println(element.getKey());
            pq.offer(element);
            if (pq.size() > k){
                pq.poll();
            }
        }
        
        while (!pq.isEmpty()){
            result.add(pq.poll().getKey());
        }
        
        return result;
    }
}

class Demo692{
	public static void main(String[] args) {
		String[] words = new String[] {"i", "love", "leetcode", "i", "love", "coding"};
		int k = 2;
		Solution692 s = new Solution692();
		List<String> r = s.topKFrequent(words, k);
		
	}	
}
