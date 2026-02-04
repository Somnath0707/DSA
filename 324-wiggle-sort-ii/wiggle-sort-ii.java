class Solution {
    public void wiggleSort(int[] nums) {
        // Sort the array 

        // make the copy of the same array 

        // keep one pointer on the mid and the next pointer on the last and replace the elements in the og array with them 
        // if the i is odd take the low element which is from the mid if i is even take the one which from the rigth most 

        // Sort the arrays 
        Arrays.sort(nums);

        // Create a copy of the sorted array 
        int copy[] = Arrays.copyOf(nums , nums.length);

        // Take the length for further simplification
        int n = nums.length;
        // The mid to get the mid for the low elements from the left side of the copied array
        int mid = (n + 1) / 2;

        // this conatins low elements than right 
        int indx1 = mid -1;
        // This has all the high elements till mid 
        int indx2 = n-1;

        // For loop to traverse over the nums array to replace them 
        for(int i = 0 ; i < n ; i ++){

            // If the position is even we place the low side element 
            if(i % 2 == 0){
                nums[i] = copy[indx1--];
            }
            // If the position is odd we place the high side elements 
            if(i % 2 !=0){
                nums[i] = copy[indx2--];
            }
        }

    }
}