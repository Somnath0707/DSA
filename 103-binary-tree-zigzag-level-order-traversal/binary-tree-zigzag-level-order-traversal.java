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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();

        if(root == null) return output;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        //THis should be always outside 
        boolean leftToRight = true;

        while(!q.isEmpty()){
            int size = q.size();

            
            List<Integer> list = new ArrayList<>();

            for(int i =0 ; i < size ; i++){
                TreeNode node = q.poll();

                if(leftToRight){
                    list.add(node.val);
                }else{
                    list.add(0,node.val);
                }

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            output.add(list);
            leftToRight = !leftToRight;
        }
        return output ; 
    }
}