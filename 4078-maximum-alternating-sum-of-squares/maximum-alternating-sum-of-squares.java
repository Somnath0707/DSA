class Solution {
    public long maxAlternatingSum(int[] nums) {

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(Math.abs(num));
        }

        Collections.sort(list);  // ascending

        long ans = 0;
        int i = 0;
        int j = list.size() - 1;

        boolean plusTurn = true;

        while (i <= j) {
            if (plusTurn) {
                ans += (long) list.get(j) * list.get(j);
                j--;
            } else {
                ans -= (long) list.get(i) * list.get(i);
                i++;
            }
            plusTurn = !plusTurn;
        }

        return ans;
    }
}
