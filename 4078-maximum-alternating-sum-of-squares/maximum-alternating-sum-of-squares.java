class Solution {
    public long maxAlternatingSum(int[] nums) {

        List<Integer> list = new ArrayList<>();
        for(int num : nums){
            list.add(Math.abs(num));
        }

        Collections.sort(list);

        int i = 0; 
        int j = list.size() - 1;
        long ans = 0; 
        while(i <= j){
            ans+= list.get(j)*list.get(j);
           if(i != j) ans -= list.get(i)*list.get(i);

            i++;
            j--;
        }
        return ans ; 
        
    }//[1,-1,2,-2,3,-3] ->[-3,-2,-1 ,1,2 ,3]->[1,1,2,2,3,3]
}