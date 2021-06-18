class Solution1338 {
    public int minSetSize(int[] arr) {
        
        // assumption:
        // #1 size of arr is even
        // #2 arr does not gurantee all the same integer will appear continuously 
        // #3 not sorted
        
        // brute force way
        // firstly count occurrences of all integers inside of array
        // store the occurance count with integer in heap
        // starting remove the element of largest occurance untill size is smaller than arr.length/2 
        //time complexity: O(nlogn)
        
        // Is there better solution
        // is it possible to do O(n)?
        // greedy? not gurantee 
        // bucket sort? no because 1 <= arr[i] <= 10^5
        // unless assumption #2 is wrong, otherwise no better solution
        
        // firstly count occurrences of all integers inside of array
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(countMap.containsKey(arr[i])){
                countMap.put(arr[i], countMap.get(arr[i]) + 1);
            }
            else{
                countMap.put(arr[i], 1);
            }
        }
        
        // store the occurance count with integer in heap
        PriorityQueue<int[]> heap = new PriorityQueue<>((x,y)-> y[1] - x[1]);
        for(Integer key:countMap.keySet()){
            heap.offer(new int[]{key, countMap.get(key)});
        }
        
        int count = arr.length;
        List<Integer> result = new ArrayList<>();

        // starting remove the element of largest occurance untill size is smaller than arr.length/2 
        while (count > arr.length/2){
            int[] currentElement = heap.poll();

            result.add(currentElement[0]);
            count = count - currentElement[1];
        }
        
        return result.size();
    }
}