class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);

        // try making the smallest the largest 
        int n = nums.length ; 
        int temp[] = new int[n];
        int arr[] = new int[n]; 
        for(int i = 0; i < n ; i++){
            arr[i] = nums[i]; 
            temp[i] =nums[i]; 
        }
        
        arr[0] = nums[n-1]; 
        arr[1] = nums[n-1];
        Arrays.sort(arr);

        temp[n-1] = nums[1]; 
        temp[0] = nums[n-2]; 

        Arrays.sort(temp);

        int second = temp[n-1] - temp[0]; 

        int small = arr[n-1] - arr[0]; 


        nums[n-1]= nums[0]; 
        nums[n-2] = nums[0]; 
        Arrays.sort(nums);
        int large = nums[n-1] - nums[0];

       
        

        int real  =  Math.min(small , large);
        return Math.min(real , second);
    }
}

//[1,2,100,200,300] 
//[58,42,8,75,28] ->[8 , 28 , 42 , 58 , 75]