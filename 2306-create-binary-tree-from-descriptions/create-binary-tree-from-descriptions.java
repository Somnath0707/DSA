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
    public TreeNode createBinaryTree(int[][] descriptions) {
        // we get the node and add new left or right 
        // if the node is already presnt we point it to that 

        Map<Integer, TreeNode > map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        TreeNode root = new TreeNode(); 
        for(int edges[] : descriptions){
            int parent = edges[0];
            int child = edges[1]; 
            int isLeft = edges[2]; 

            map.putIfAbsent(parent , new TreeNode(parent));
            map.putIfAbsent(child , new TreeNode(child));

            TreeNode p = map.get(parent);
            TreeNode c = map.get(child);


            if(isLeft == 1){
                p.left = c; 
            }else {
                p.right = c ; 
            }
            
            set.add(child);

        }
        
        for(int val : map.keySet()){
            if(!set.contains(val)){
                return map.get(val);
            }
        }

        return null;
    }
}