class Solution {
    public int longestEqualSubarray(List<Integer> list, int k) {
        int left =0 ; 
        int max = 0 ; 
        int n = list.size() ; 
        Map<Integer , Integer> map = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            int val = list.get(i);

            map.put(val , map.getOrDefault(val , 0 ) + 1 ) ; 
            
            max = Math.max(max , map.get(val));

            // System.out.println("right " + i + " left " + left + " " + 1 + " MAX " + max );


            if((i - left + 1) - max > k ){
                // System.out.println("Inside Start");
                // System.out.println("right " + i + " left " + left + " " + 1 + " MAX " + max );
                int leftEle = list.get(left);

                map.put(leftEle, map.get(leftEle) - 1);

                left ++ ; 
                // System.out.println("Inside End Removed : " + leftEle);
            }
        }

        return max; 
    }
}