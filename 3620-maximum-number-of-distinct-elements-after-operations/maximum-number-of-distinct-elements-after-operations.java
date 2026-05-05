class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        // we can do -k  k operation on each element in array atmost one 
        // -1 2 , 0 4 , 0 4 , 1 5 , 1 5 , 2 6
        // - 1 , 0 , 1 , 2  , 3 , 4 

        // 3 5 , 3 5 , 3 5 , 3 5
        // 3 , 4 , 5 , 

        // make a 2d array 
        int[][] check = new int[nums.length ][2];

        for(int i = 0 ; i < nums.length ; i++){
            check[i][0] = nums[i] - k;
            check[i][1] = nums[i] + k ; 
        }
        Arrays.sort(check , (a,b)->{
            if(a[0] != b[0]) return a[0] - b[0];
            else return a[1] - b[1]; 
        });

        // -1 2 , 0 4 , 0 4 , 1 5 , 1 5 , 2 6
        int ans =1 ; 
        int min = check[0][0]; 

        for(int i = 1 ; i < check.length ; i++){
            int currS = check[i][0]; 
            int  currE = check[i][1];

            // if curr start = prev just take + 1 and check if in range 
            // if not just take currs
            if(currS <= min){
                int temp = min + 1; 
                if(temp >= currS && temp <= currE){
                    ans++; 
                    min = temp ; 
                }
                else {
                    continue;
                }
            }
            else{
                min = currS;
                ans++;
            }
        }
        return ans; 
    }
}