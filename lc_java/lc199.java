class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        // traverse the tree level by level
        // get the most right node val in each level and put it into the list
        // we can use BFS and always traver left side first
        // time complexity will be O(n) where n is number of node in the tree
        
        List<Integer> result = new ArrayList<>();

        int level = 1;
        
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<TreeNode, Integer> (root, level));
        
        while(q.size() >0)
        {
            Pair<TreeNode, Integer> temp = q.poll();
            if (temp.getKey() == null) continue;
            
            if (result.size() < temp.getValue())
            {
                result.add(  temp.getKey().val);
            }
            
        q.add(new Pair<TreeNode, Integer> (temp.getKey().right, temp.getValue() + 1));
        q.add(new Pair<TreeNode, Integer> (temp.getKey().left, temp.getValue() + 1));

        }
        
        return result;
        
    }
}