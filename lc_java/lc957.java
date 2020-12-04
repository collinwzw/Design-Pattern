import java.util.*;

class Solution957 {
    public int[] prisonAfterNDays(int[] cells, int N) {
        //use hashtable compute all possiblities untill we find the same pattern
        
        Map<String, int[]> map = new HashMap<>();
        
        int[] currentCell = cells;
        
        int count = 0;
        while (count < N){
            String key = Arrays.toString(currentCell);
            //System.out.println(currentCell);
            if(map.containsKey(key)){
                currentCell = map.get(key);
                break;
            }
            else{
                
                map.put(key, helper(currentCell));
                currentCell = map.get(key);
                //System.out.println(map.size());
            }
            count++;
        }
        
        count = (N - count)% map.size(); 

        for(int i = 0; i< count; i ++) {
        	String key = Arrays.toString(currentCell);
        	currentCell = map.get(key);
        }
        
        return currentCell;

    }
    
    private int[] helper(int[] cells){
        
        int[] resultCells = new int[cells.length];
        resultCells[0] = 0;
        resultCells[cells.length - 1] = 0;
        for(int i = 1; i < cells.length - 1; i++){
            if (cells[i - 1] == cells[i+1]){
                resultCells[i] = 1;
            }
            else{
                resultCells[i] = 0;
            }
        }
        
        return resultCells;
    }
}


class Demo957{
	public static void main(String[] args) {
		Solution957 s = new Solution957();
		int[] cells = new int[] {0,1,0,1,1,0,0,1};
		int days = 1000;
		int[] r = s.prisonAfterNDays(cells, days);
		System.out.println(Arrays.toString(r));
	}
}