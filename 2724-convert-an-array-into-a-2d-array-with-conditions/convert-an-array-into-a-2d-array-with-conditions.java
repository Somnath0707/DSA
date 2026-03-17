class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length ; i++){
            list.add(nums[i]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        while(!list.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            for(int i =0 ; i< list.size() ;i++){
                if(!temp.contains(list.get(i))){
                    temp.add(list.get(i));
                    list.remove(i);
                    i--;
                }
            }
            ans.add(new ArrayList<>(temp));
        }
        return ans; 
    }
}