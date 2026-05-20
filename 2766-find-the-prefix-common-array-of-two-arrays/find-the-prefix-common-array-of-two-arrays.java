class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Map<Integer,Integer> mapB = new HashMap<>();

        int ans[] = new int[A.length];

        for(int i = 0 ; i < A.length ; i++){
            int currB = B[i];
            mapB.put(currB , mapB.getOrDefault(currB , 0) + 1 );
            int count = 0 ; 
            for(int j = 0 ; j <= i ; j++){
                if(mapB.containsKey(A[j])){
                    System.out.println("Curr " + A[i]);
                    count++;
                    System.out.println(count);
                }
                else{
                    continue;
                }
            }
            ans[i] = count;
        }

    return ans; 
    }
}