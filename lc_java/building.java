import java.util.*;

class Building {
	
	
	public static int[] computeSeenBuilding(int n, int[] buildings) {
		
		// go through the integer array 
		// pushing the building height of current index to stack with following conditions
		// 1. if building[i - 1] < s.peek(), this building can be seen, push to the stack
		// 2. if building[i - 1] > s.peek(), then we keep popping until we find s is empty or building[i - 1] < s.peek()
		// the size of the stack  at each index is the number of building can be seen at that index.
		// O(n)
		Stack<Integer> s = new Stack<>();
		int[] result = new int[n];
		result[0] = 0;
		for(int i = 1; i < n; i++) {
			if(buildings[i - 1] == 0) {
				result[i] = s.size();
				continue;
			}
			if(s.isEmpty()) {
				s.push(buildings[i - 1]);
				result[i] = s.size() ;
				continue;
			}
			if(buildings[i - 1] < s.peek()) {
				s.push(buildings[i - 1]);
			}
			else {
				s.pop();
				while(!s.isEmpty()) {
					if (buildings[i - 1] < s.peek() ) {			
						break;
					}
					s.pop();
				}
				s.push(buildings[i - 1]);
			}	
			result[i] = s.size() ;
		}	
		return result;
	}
	
	public static void main(String[] args) {
		int[] buildings = new int[] {0,3,2,1,4,2,1,0,5,6};
		int[] result = computeSeenBuilding(buildings.length, buildings);
		System.out.println(Arrays.toString(result));
	}
}