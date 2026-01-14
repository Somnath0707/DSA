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
    // A integer count to keep track of good nodes :)
    // We declare here as we can use this n anywhere 
    int count = 0 ; 
    int max = Integer.MIN_VALUE;

    public void countGood(TreeNode node){
        // As usual base condition 
        if(node == null){
            return ;
        }

        //Keep the previous max before checking with current 
        int oldMax = max;

        // check between previous max and curr val if 
        max = Math.max(max,node.val);


        // We know if the max gets updated then the value is greater i.e. if max == node.value
        if(node.val==max){
            count++;
        }

        countGood(node.left);
        countGood(node.right);

        // restore the parent’s max
        max= oldMax;


    }
    public int goodNodes(TreeNode root) {
        countGood(root);
        return count;
    }
}