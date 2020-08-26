class Solution98 {
    public boolean isValidBST(TreeNode root) {
        // we have to travese the tree
        // for a left subtree, we should pass the node.val as max value
        // for a right subtree, we should pass the node.val as min value
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        return helper(root,Long.MAX_VALUE, Long.MIN_VALUE);

    }
    
    public boolean helper(TreeNode node, long max, long min)
    {
        if (node == null) return true;
        if (node.val > min && node.val < max)
        {
            
            return helper(node.left, node.val, min) &&helper(node.right, max, node.val );
        }
        return false;
    }
}