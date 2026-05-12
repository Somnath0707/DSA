class Solution {
    public boolean isAns(int n , int[][] nums){
        for(int i = 0 ; i < nums.length; i++){
            int min = nums[i][1];
            int act = nums[i][0];
            int diff = nums[i][2];

            if(n >= min){
                n -= act;
                continue;
            }
            if(n < min){
                return false;
            }
        }
        return true; 
    }
    public int minimumEffort(int[][] tasks) {
        int n = tasks.length;
        int temp[][] = new int[n][3];
        for(int i = 0 ; i < n ; i++){
            temp[i][0] = tasks[i][0];
            temp[i][1] = tasks[i][1];
            int diff = tasks[i][1] - tasks[i][0];
            temp[i][2] = diff;
        }

        Arrays.sort(temp , (a,b) ->{
            if(a[2] != b[2]) return b[2] - a[2];
            else if(a[1] != b[1]) return b[1] - a[1];
            else return b[0] - a[0];
        });

        int left = 1 ; 
        int right = 1000000000;
        int ans = 0  ;

        while(left <= right){
            int mid = left + (right - left) / 2; 

            if(isAns(mid , temp)){
                ans = mid ; 
                right = mid - 1 ; 
            }else {
                left = mid + 1 ;
            }
        }
        return ans; 
    }
}