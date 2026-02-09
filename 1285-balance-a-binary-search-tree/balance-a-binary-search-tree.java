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
    public void dfs(TreeNode node , List<Integer> sort){
        if(node == null){
            return ; 
        }

        dfs(node.left ,sort);
        sort.add(node.val);
        dfs(node.right , sort);
    }


    public TreeNode build(List<Integer> sort , int l , int r ){
        if(l > r) return  null;

        int mid = (l + r ) /2;

        TreeNode node = new TreeNode (sort.get(mid));
        node.left = build(sort, l , mid-1);
        node.right = build(sort , mid + 1 , r);
        return node;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs (root , list );
        return build(list , 0 , list.size() -1 );
    }
}