class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // one room could have mutiple keys
        // n is number of rooms
        // m is number of keys
        //if we use DFS, the time complexity is O(N+m) 
        
        if (rooms.size() == 0) return true;
        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[rooms.size()];
        for (int i = 0; i < rooms.size(); i++)
        {
            visited[i] = false;
        }
        visited[0] = true;
        s.push(0);
        
        while(s.size()>0)
        {
            Integer temp = s.pop();
            for(Integer key: rooms.get(temp))
            {
                if (visited[key] == false)
                {
                    s.push(key);
                    visited[key] = true;

                }
            }
        }
        
        for (int i = 0; i < rooms.size(); i++)
        {
            if (visited[i] == false)
            {
                return false;
            }
        }
        
        return true;
    }
}