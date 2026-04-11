import java.math.BigInteger;
class Solution {
    public long maxProduct(int[] nums) {
        // count number of the negatives 
        // count the lowest of the -ve and positive 
        // if there is replace it with zero 
        // if number of the -ve are odd replace them with number 
        // -5 -9 -38 2 99
        // replace the first non negative with the number after sortingif the -ve are odd
        // for any remove the first smallest and replace it by the 
        // Arrays.sort(nums);
        // the first highest the second highest from the arrys

        int highest = Integer.MIN_VALUE; 
        int secondHigh = Integer.MIN_VALUE ; 
        int neg = 0 ; 
        for(int n : nums){
                if(Math.abs(n) > highest){
                    secondHigh = highest;
                    highest = Math.abs(n);
                }
                else if(Math.abs(n) <= highest && Math.abs(n) > secondHigh){
                    secondHigh = Math.abs(n);
                }
        }
        long ans = 1 ; 
        if( neg % 2 == 1){
            ans = highest * secondHigh * (100000);
        }
        else{
            ans = 1L * highest * secondHigh * 100000 ;
        }
        return ans ; 
    }
}

//  [-4,-2,-1,-3] -> [-4 , -3 , -2 , -1]
// -5,7,0 -> -5 ,  0 , 7

// [7 -12 5 34 15 0] -> [-12 , 0 , 5 , 7 , 15 , 34]