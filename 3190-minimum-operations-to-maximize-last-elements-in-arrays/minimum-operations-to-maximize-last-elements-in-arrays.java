class Solution {
    public int f(int [] n1 , int[] n2){
        int len = n1.length;
        int last1 = n1[len-1];
        int last2 = n2[len-1];
        int count = 0 ; 

        for(int i = len-2 ; i >= 0 ; i--){
            int first = n1[i];
            int second = n2[i];

            if(first <= last1 && second <= last2){
                continue;
            }

            else if(second <= last1 && first <= last2 ){
                count ++;
                continue;
            }

            else return -1 ; 
        }
        return count;
    }
    public int minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int noSwap = f(nums1 , nums2 );


        int temp = nums1[n-1];
        nums1[n-1] = nums2[n-1];
        nums2[n-1] = temp;

        int swap = f(nums1 , nums2);
        if(swap != -1){
            swap = swap+1;
        }


        if(noSwap == -1 ) return swap;
        if(swap == -1 ) return noSwap;

        return Math.min(noSwap , swap);

    }
}