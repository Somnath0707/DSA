class Solution {
    public int minSwaps(int[] nums) {
        // a swap is defined as taking two distinct pos in an array and swapping the values in them

        // array is circular 

        // given binary arr return the min number of swaps req to group all 1s presne the array togher at any location 

        // nums = 0 1 0 1 1 0 0 
        // 1 <= nums.length <= 10^5

        // find the gropus of the 1s and fill the middle distance between them 

        // 0 0 1 0 1 1 0 0 0 1 1
        //2

    // so the gap between first and last componet and and there gap or 0s -1 

    int n = nums.length; 
    int arr[] = new int[n*2]; 
    int countOnes = 0 ; 
    for(int i = 0 ; i < n ; i ++){
        if(nums[i] == 1) countOnes ++; 
        arr[i] = nums[i]; 
        // System.out.print(arr[i] + " ");
    }
    int ind = n;
    for(int i = 0 ; i < n ; i++){
        arr[ind] = nums[i] ; 
        ind++;
        // System.out.print(arr[ind] + " ");
    }
    
    int m = arr.length; 
    int countZero = 0 ; 
    for(int j = 0 ; j < countOnes ; j++){
        // System.out.println("Count of first window : " + countZero + " the j is : " + j );
        if(arr[j] == 0 ) countZero++; 
    }
    int minZero = countZero ; 
    int j = countOnes-1;
    for(int i = 1 ; i < m - countOnes ; i++){
        if(arr[i-1] == 0 ) {
            countZero-- ; 
            // System.out.println(i + " index i ");
            // System.out.println(" the zero at the i is gone so : " + countZero);
        }
        j++; 
        int size = j - i + 1 ; 
        // System.out.println("Window Size Is : " + size + " but the size of the our window should be " + countOnes + "i : " + i + " j : " +  j );

        
        if(arr[j] == 0 ) {
            // System.out.println(j + " jth index ");
            countZero++; 
            // System.out.println("We got the new 0 so the zero increased : " + countZero);
        }
        minZero = Math.min(minZero ,countZero);

         
    }
    return minZero ; 
    }
}