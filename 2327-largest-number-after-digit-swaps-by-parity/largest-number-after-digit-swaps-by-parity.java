class Solution {
    public int largestInteger(int num) {

        String s = String.valueOf(num);

        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        // separate digits based on parity (NOT index)
        for (int i = 0; i < s.length(); i++) {
            int d = s.charAt(i) - '0';

            if (d % 2 == 0) even.add(d);
            else odd.add(d);
        }

        // sort both groups descending
        Collections.sort(even, Collections.reverseOrder());
        Collections.sort(odd, Collections.reverseOrder());

        int ei = 0, oi = 0;
        int ans = 0;

        // rebuild following original parity pattern
        for (int i = 0; i < s.length(); i++) {
            int d = s.charAt(i) - '0';

            if (d % 2 == 0) {
                ans = ans * 10 + even.get(ei++);
            } else {
                ans = ans * 10 + odd.get(oi++);
            }
        }

        return ans;
    }
}

