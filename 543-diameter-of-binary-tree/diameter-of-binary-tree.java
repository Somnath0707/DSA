/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int res = 0 ;// Store the result 
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root); //Function to get the diameter using depth first search 
        return res;
    }

    private int dfs(TreeNode node){
        if(node == null) return 0;  // Check until the leaf node 

        int l = dfs(node.left); // Goes to the most left leaf nod 
        int r = dfs(node.right);


        res = Math.max(res, l+r); 

        return 1 + Math.max(l,r);
    }
}