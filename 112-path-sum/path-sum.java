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
    // WE use this to store the result consistenly throughout the answer 
    private boolean result ;

    // We will create a recursive function that will find the path sum 
    private void pathSum(TreeNode node , int target , int sum ){

        // Base case condition to return 
        if(node == null){
            return ; 
        }

        // Add the node to total sum 
        sum+=node.val;

        // Check if it is the end of the path 
        // We know the end of the path is when node.left is null same with right 
        if(node.left == null && node.right == null){
            // If we reached end of the path check the sum is == target 

            if(target == sum ){
            // We have found the path yippyyyyyy
                result = true;
            }
            // Else we did not find here check elsewhere :(
            else{
                return ;                 
            }

        }
         // Check the node to left and to the rigth 

            pathSum(node.left, target , sum );
            pathSum(node.right , target,sum);
    }



    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Initilize here 
        result = false; 

        // Recursive Function to get the path sum == to target 
        pathSum( root , targetSum , 0 );

        // return the result 
        return result ; 
        
    }
}