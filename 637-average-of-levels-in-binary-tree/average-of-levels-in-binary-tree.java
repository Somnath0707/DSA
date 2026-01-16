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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> output = new ArrayList<>();

        if(root == null) return output ;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        

        while(!q.isEmpty()){
            double size = q.size();
            double sum = 0 ; 

            for(int i = 0 ; i < size ; i ++){
                TreeNode node = q.poll();

                sum+=node.val;

                if(node.left != null) {
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }

            }
            output.add(sum/size);
        }
        return output;
    }
}