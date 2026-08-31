class Solution {
    public int minMovesToMakePalindrome(String s) {
        // what can we do first see how many of these we can make like how many palindrome are there cost for making each palidrom from og string 

        // aabb -> abba -> baab 
        // how much to make abba and how much to make baab 

        // letelt-> lettel-> tellet->ett

        // nah too many conbiantion to keep track of 
        int left = 0;
        StringBuilder str = new StringBuilder(s);
        int right = str.length() - 1;
        int ans = 0;
        while (left < right) {
            int ind = right;
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
                continue;
            }
            while (ind > left && str.charAt(ind) != str.charAt(left)) {
                ind--;
            }
            if (ind == left) {
                char temp = str.charAt(left);
                str.setCharAt(left, str.charAt(left + 1));
                str.setCharAt(left + 1, temp);
                ans++;
            } else {
                char temp = str.charAt(ind);
                for (int i = ind; i < right; i++) {
                    str.setCharAt(i, str.charAt(i + 1));
                }
                str.setCharAt(right, temp);

                ans += right - ind;
                left++;
                right--;
            }
        }

        return ans;
    }
}