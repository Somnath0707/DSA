class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            // add
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            if (i >= k - 1) {

                int count = 0;
                int beauty = 0;

                // find x-th smallest
                for (int key : map.keySet()) {
                    count += map.get(key);

                    if (count >= x) {
                        if (key < 0) beauty = key;
                        break;
                    }
                }

                ans.add(beauty);

                // remove outgoing
                int out = nums[i - k + 1];
                map.put(out, map.get(out) - 1);
                if (map.get(out) == 0) map.remove(out);
            }
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }
}