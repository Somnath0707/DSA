class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        boolean isOdd = true;
        int len = 0;
        if (intLength % 2 == 0) {
            len = (intLength / 2);
            isOdd = false;
        } else {
            len = intLength / 2 + 1;
        }
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < queries.length; i++) {
            max = Math.max(max, queries[i]);
            set.add(queries[i]);
        }
        StringBuilder str = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        str.append("1");
        str2.append("9");
        if (isOdd) {
            for (int i = 0; i < len - 1; i++) {
                str.append("0");
                str2.append("9");
            }
            // System.out.println(str.toString());
            // System.out.println(str2.toString());
        } else {
            for (int i = 0; i < len - 1; i++) {
                str.append("0");
                str2.append("9");
            }
            // System.out.println(str.toString());
            // System.out.println(str2.toString());
        }
        System.out.println(len);
        long start = Long.parseLong(str.toString());
        long end = Long.parseLong(str2.toString());

        Map<Integer, Long> map = new HashMap<>();

        for (int q : set) {
            long first = start + q - 1;
            if (first > end)
                continue;
            String s = String.valueOf(first);
            String rev;
            if (isOdd)
                rev = new StringBuilder(s.substring(0, len - 1)).reverse().toString();
            else
                rev = new StringBuilder(s).reverse().toString();

            map.put(q, Long.parseLong(s + rev));
        }

    long ans[] = new long[queries.length];

    for(int i = 0 ; i < queries.length ; i++){
    ans[i] = map.getOrDefault(queries[i], -1L);
    }

    return ans;
    }
}