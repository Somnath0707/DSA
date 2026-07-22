class Solution {
    int bs(List<Integer> list, int indx) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) == indx) {
                return mid;
            } else if (list.get(mid) < indx) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public List<Integer> solveQueries(int[] nums, int[] queries) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            int index = queries[i];
            int val = nums[index];

            List<Integer> list = map.get(val);

            int indx = bs(list, index);

            if (indx != 0 && indx != list.size() - 1) {
                int first = list.get(indx) - list.get(indx - 1);
                int ans1 = Math.min(first, n - first);
                int last = list.get(indx + 1) - list.get(indx);
                int ans2 = Math.min(last, n - last);
                ans.add(Math.min(ans1, ans2));
            } else if (indx != 0) {
                int first = list.get(indx) - list.get(indx - 1);
                int ans1 = Math.min(first, n - first);
                int wrap = list.get(indx) - list.get(0);
                wrap = Math.min(wrap, n - wrap);

                ans.add(Math.min(ans1, wrap));
            } else if (indx != list.size() - 1) {
                int last = list.get(indx + 1) - list.get(indx);
                int ans2 = Math.min(last, n - last);
                int wrap = list.get(list.size() - 1) - list.get(indx);
                wrap = Math.min(wrap, n - wrap);

                ans.add(Math.min(ans2, wrap));
            } else {
                ans.add(-1);
            }
        }
        return ans;
    }
}