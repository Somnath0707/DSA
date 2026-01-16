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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        // Ezy just do the bfs i.e. level order traversal and reverse the result lmao 
        
        // Make a list of list to store the output 
        List<List<Integer>> output = new ArrayList<>();

        if(root == null) return output ;

        //Make a Queue
        Queue<TreeNode> q = new LinkedList<>();

        // Add the root to the queue
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();

            List<Integer> list = new ArrayList<>();

            for(int i = 0 ; i < size ; i ++){
                TreeNode node = q.poll();

                list.add(node.val);

                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            output.add(list);
        }

        Collections.reverse(output);

        return output;
        
    }
}