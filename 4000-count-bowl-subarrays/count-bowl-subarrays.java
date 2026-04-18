
class Solution {
    public int bowlSubarrays(int[] nums) {
        int n = nums.length;
        int count = 0;
        // Stack will store indices to help us find boundaries
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            /* If the current element is greater than the stack top, 
               the stack top could be the 'maximum' inside a bowl 
               bounded by the current element (Right Wall) and 
               the element below it in the stack (Left Wall).
            */
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int midIndex = stack.pop();
                
                if (!stack.isEmpty()) {
                    int leftWallIndex = stack.peek();
                    int rightWallIndex = i;
                    
                    // Condition: Length must be at least 3
                    // This is guaranteed if rightWallIndex - leftWallIndex >= 2
                    if (rightWallIndex - leftWallIndex >= 2) {
                        count++;
                    }
                }
            }
            stack.push(i);
        }

        return count;
    }
}