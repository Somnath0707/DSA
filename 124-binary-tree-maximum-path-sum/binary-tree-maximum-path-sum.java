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
    int maxPath = Integer.MIN_VALUE;

    private int maxPath(TreeNode node){
        if(node == null) return 0 ; 

        int left = Math.max(0,maxPath(node.left));
        int right = Math.max(0,maxPath(node.right) );
        
        int throughPath = node.val + left + right ;

        maxPath = Math.max(maxPath,throughPath);

        return node.val + Math.max(left , right ) ;

        
    }
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return maxPath;
        
    }
}