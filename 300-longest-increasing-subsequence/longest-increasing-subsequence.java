class Solution {

    public int lengthOfLIS(int[] nums) {

        List<Integer> tails = new ArrayList<>();

        for(int num : nums){

            int l = 0, r = tails.size();

            while(l < r){

                int mid = (l+r)/2;

                if(tails.get(mid) < num)
                    l = mid + 1;
                else
                    r = mid;
            }

            if(l == tails.size())
                tails.add(num);
            else
                tails.set(l, num);
        }

        return tails.size();
    }
}