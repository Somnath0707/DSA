class Solution {
    public void wiggleSort(int[] nums) {
        // Sort the array 

        // make the copy of the same array 

        // keep one pointer on the mid and the next pointer on the last and replace the elements in the og array with them 
        // if the i is odd take the low element which is from the mid if i is even take the one which from the rigth most 

        Arrays.sort(nums);
        int copy[] = Arrays.copyOf(nums , nums.length);


        int n = nums.length;

        int mid = (n + 1) / 2;

        int indx1 = mid -1;
        int indx2 = n-1;
        for(int i = 0 ; i < n ; i ++){
            if(i % 2 == 0){
                nums[i] = copy[indx1--];
            }
            if(i % 2 !=0){
                nums[i] = copy[indx2--];
            }
        }

    }
}