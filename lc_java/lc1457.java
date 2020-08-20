class Solution1457 {
    private int ans;
    public int pseudoPalindromicPaths (TreeNode root) {
        ans=0;
        inorder(root,new int[10]);
        return ans;
    }
    
    private void inorder(TreeNode root,int[] freq ){
        
        if(root.left==null && root.right==null) {
            freq[root.val]++;
            if(isEven(freq)) ans++;
            freq[root.val]--;
            return;
        }
        
        freq[root.val]++;
        if(root.left!=null) inorder(root.left, freq);
        if(root.right!=null) inorder(root.right, freq);        
        freq[root.val]--;
        
    }
    
    private boolean isEven(int[] path){
        int cnte=0;
        int cnto=0;
        for(int i=0;i<=9;i++){
            if(path[i]%2!=0) cnto++;
            else cnte++;
        }
        if(cnto>1) return false;
        return true;
    }
}