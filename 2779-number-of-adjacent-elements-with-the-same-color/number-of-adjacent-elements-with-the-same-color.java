class Solution {
    public int[] colorTheArray(int n, int[][] nums) {
        int len = nums.length;
        int ans[] = new int[len];
        int temp[] = new int[n]; // Store colors
        int count = 0; 
        // map stores: Index -> Number of neighbors it is currently paired with
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < len; i++){
            int ind = nums[i][0];
            int newColor = nums[i][1];

            // 1. UNDO logic: If index was already colored, remove its current pair contributions
            if (temp[ind] != 0 && temp[ind] != newColor) {
                // Check Left
                if (ind > 0 && temp[ind-1] == temp[ind]) {
                    count--;
                    // Update map for both neighbors involved in the broken pair
                    map.put(ind, map.get(ind) - 1);
                    map.put(ind-1, map.get(ind-1) - 1);
                }
                // Check Right
                if (ind < n - 1 && temp[ind+1] == temp[ind]) {
                    count--;
                    map.put(ind, map.get(ind) - 1);
                    map.put(ind+1, map.get(ind+1) - 1);
                }
            }

            // 2. APPLY the new color (only if it's actually a change or first time)
            if (temp[ind] != newColor) {
                temp[ind] = newColor;

                // 3. REDO logic: Check if the new color creates new pairs
                // Check Left
                if (ind > 0 && temp[ind-1] == temp[ind]) {
                    count++;
                    map.put(ind, map.getOrDefault(ind, 0) + 1);
                    map.put(ind-1, map.getOrDefault(ind-1, 0) + 1);
                }
                // Check Right
                if (ind < n - 1 && temp[ind+1] == temp[ind]) {
                    count++;
                    map.put(ind, map.getOrDefault(ind, 0) + 1);
                    map.put(ind+1, map.getOrDefault(ind+1, 0) + 1);
                }
            }

            ans[i] = count;
        }
       
        return ans;
    }
}