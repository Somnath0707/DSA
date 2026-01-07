class Solution {
    long maxP=0, SUM=0;
    public int maxProduct(TreeNode root) {
        if (root == null) return 0;

        //long maxP=0, SUM=0;
        SUM= totalsum(root);
        totalsum(root);

        return (int)(maxP % 1000000007);
    }

         int totalsum(TreeNode root)
        {
                if(root==null) return 0;

                int lss= totalsum(root.left);
                int rss= totalsum(root.right);
                int subts= root.val+ lss+ rss;

                maxP = Math.max(maxP, subts * (SUM - subts));
                return subts;
        }
        //return (int)(maxP % 1000000007);
    }