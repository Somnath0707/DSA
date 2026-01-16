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
    // Make a public list to access everwhere 
    List<Integer> list = new ArrayList<>();
    public void inorder(TreeNode node){
        if(node == null) return ;

        // Go to the leftmost element in the tree
        inorder(node.left);
        //Add that element to list 
        list.add(node.val);
        // Check for the right side
        inorder(node.right);

    }

    public int kthSmallest(TreeNode root, int k) {

        // We know inorder traversal gives us a sorted list in bst
        // SO we will do in order traversal 
        // add each element in the list 
        // then just get the k-1 th element as the indexing start from 0 
        inorder(root);

        return list.get(k-1);

        
    }
}