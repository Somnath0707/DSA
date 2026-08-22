class Solution {
    Map<Character, int[]> map;
    Map<String, Integer> dp;

    public int f(int i, char one, char two, String s) {
        if (i == s.length())
            return 0;
        String key = i + "#" + one + "#" + two;

        if (dp.containsKey(key))
            return dp.get(key);

        char curr = s.charAt(i);
        int currX = map.get(curr)[0];
        int currY = map.get(curr)[1];

        int ans = Integer.MAX_VALUE;

        int firstX = map.get(one)[0];
        int firstY = map.get(one)[1];

        int secondX = map.get(two)[0];
        int secondY = map.get(two)[1];

        int firstDiff = Math.abs(firstX - currX) + Math.abs(firstY - currY);
        int secondDiff = Math.abs(secondX - currX) + Math.abs(secondY - currY);

        ans = Math.min(firstDiff + f(i + 1, curr, two, s), secondDiff + f(i + 1, one, curr, s));
        dp.put(key, ans);
        return ans;

    }

    public int minimumDistance(String s) {
        // try zero to for each combination and then take the minimum distance between both for the each 
        char temp = 'A';
        dp = new HashMap<>();
        map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                map.put(temp++, new int[] { i, j });
            }
        }
        int ans = Integer.MAX_VALUE;
        for (char i = 'A'; i <= 'Z'; i++) {
            for (char j = 'A'; j <= 'Z'; j++) {
                if (i == j)
                    continue;
                ans = Math.min(ans, f(0, i, j,s));
            }
        }

        return ans;
    }
}