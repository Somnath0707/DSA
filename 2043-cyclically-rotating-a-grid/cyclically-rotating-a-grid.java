class Solution {
    public int[][] rotateGrid(int[][] nums, int k) {
        // Make a same matrix go start with the k in the grid and 0 at the new matrix
        // then move forward until n or once we reach n move down to m the move left to 0 then move up to 0 then move till the we reach the starting point once done t the start point and the n -2 and m -2 
        // Make a list but all the element in the list of that layer and rottae the list by k 
        int n = nums.length;
        int m = nums[0].length;
        int ans[][] = new int[n][m];

        int top = 0 ; 
        int bottom = n - 1;
        int left = 0 ; 
        int right = m -1 ; 

        while(top < bottom && left < right){
            List<Integer> list = new ArrayList<>();

            //left to right 
            for(int i = left ; i <= right ;i++){
                list.add(nums[top][i]);
            }

            // top to bottom 
            for(int i = top+1 ; i <= bottom ; i++ ){
                list.add(nums[i][right]);
            }

            // right to left 
            for(int i = right-1 ; i >= left ; i--){
                list.add(nums[bottom][i]);
            }

            // bootm to top 
            for(int i = bottom - 1 ; i > top ; i--){
                list.add(nums[i][left]);
            }

            int size = list.size();
            for(int i = 0 ; i < size ; i++){
                System.out.print(list.get(i) + " ");
            }

            int rotate = k % size ; 

            List<Integer> rotated = new ArrayList<>();

            for(int i =0 ;i < size ; i++){
                rotated.add(list.get((i + rotate ) % size) );
            }

            System.out.println();
            for(int i = 0 ; i < size ; i++){
                System.out.print(rotated.get(i) + " ");
            }
            
            //put in place now 

            // left to right 
            int ind = 0 ; 
            for(int i = left ; i <= right ; i++){
                ans[left][i] = rotated.get(ind++);
            }

            // top to down
            for(int i = top + 1 ; i <= bottom ; i++){
                ans[i][right] = rotated.get(ind++);
            }

            // right to left ; 
            for(int i = right-1 ; i >= left ; i--){
                ans[bottom][i] = rotated.get(ind++);
            }

            // down up 
            for(int i = bottom -1 ; i > top ; i--){
                ans[i][left] = rotated.get(ind++);
            }


            top++;
            bottom --; 
            left ++; 
            right--;


        }
        return ans;
    }
}