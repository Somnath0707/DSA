class Solution {
    public int maxLevelSum(TreeNode root) {

        // Queue is used for BFS (level-order traversal)
        Queue<TreeNode> q = new LinkedList<>();

        // Start by adding the root node (level 1)
        q.add(root);

        // level keeps track of current level number
        int level = 1;

        // maxLevel stores the level with maximum sum so far
        int maxLevel = 1;

        // maxSum stores the maximum level sum found
        int maxSum = Integer.MIN_VALUE;

        // BFS traversal: process the tree level by level
        while (!q.isEmpty()) {

            // Number of nodes at the current level
            int size = q.size();

            // Sum of values at the current level
            int currSum = 0;

            // Process all nodes of the current level
            for (int i = 0; i < size; i++) {

                // Take one node from the queue
                TreeNode node = q.poll();

                // Add its value to the current level sum
                currSum += node.val;

                // Add left child to queue if it exists
                if (node.left != null) {
                    q.add(node.left);
                }

                // Add right child to queue if it exists
                if (node.right != null) {
                    q.add(node.right);
                }
            }

            // If current level sum is greater than maxSum,
            // update maxSum and record this level
            if (currSum > maxSum) {
                maxSum = currSum;
                maxLevel = level;
            }

            // Move to the next level
            level++;
        }

        // Return the level which has the maximum sum
        return maxLevel;
    }
}
