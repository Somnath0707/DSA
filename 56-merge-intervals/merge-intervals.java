class Solution {
    public int[][] merge(int[][] nums) {
        Arrays.sort(nums, (a ,b) ->{
            if(a[0] != b[0]) return a[0]-b[0];
            return b[1]-a[1];
        });

        List<int[]> list = new ArrayList<>();

        int prevStart = nums[0][0];
        int prevEnd = nums[0][1];

        for(int i = 1 ; i < nums.length ; i++){
            int currStart = nums[i][0];
            int currEnd = nums[i][1];

            if(currStart <= prevEnd){
                prevEnd = Math.max(currEnd , prevEnd); // to check if the fuull range fit in prev
                prevStart = prevStart;
            }
            else{
                list.add(new int[]{prevStart , prevEnd});
                prevStart = currStart;
                prevEnd = currEnd;
            }
        }

        list.add(new int[]{prevStart , prevEnd});

        return list.toArray(new int[list.size()][]);
    }
}