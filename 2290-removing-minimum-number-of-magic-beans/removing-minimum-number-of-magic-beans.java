class Solution {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans); 
        long sum = 0; 
        for(int b : beans ){
            sum += b;
        }

        long res = Long.MAX_VALUE;
        long len = beans.length; 
        for(int i =0 ; i < beans.length ; i++ , len--){
            res = Math.min(res , sum - beans[i] * len );
        }
        return   res;
    }
}