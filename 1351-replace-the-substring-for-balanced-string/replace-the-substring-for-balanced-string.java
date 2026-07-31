class Solution {

    public boolean check(Map<Character, Integer> map) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                return false;
            }
        }
        return true;
    }

    public int balancedString(String s) {

        int n = s.length();
        int cap = n / 4;

        Map<Character, Integer> excess = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > cap) {
                excess.put(entry.getKey(), entry.getValue() - cap);
            }
        }

        if (excess.isEmpty()) {
            return 0;
        }

        int i = 0;
        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            char ch = s.charAt(j);

            if (excess.containsKey(ch)) {
                excess.put(ch, excess.get(ch) - 1);

                if (check(excess)) {
                    while (check(excess)){
                         ans = Math.min(ans, j - i + 1);
                        char temp = s.charAt(i);

                        if (excess.containsKey(temp)) {
                            excess.put(temp, excess.get(temp) + 1);
                            i++;
                            // break;
                        } else {
                            i++;
                        }
                    }
                }
            }
        }

        return ans;
    }
}