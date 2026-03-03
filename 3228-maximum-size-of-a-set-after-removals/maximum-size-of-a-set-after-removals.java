class Solution {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        int n = nums1.length;

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();

        for (int x : nums1){
            set1.add(x);
            set3.add(x);
        }
        for (int x : nums2) {
            set2.add(x);
            set3.add(x);
        }

        int keep1 = Math.min(set1.size(), n/2);
        int keep2 = Math.min(set2.size(), n/2);

        int ans = Math.min(keep1 + keep2 , set3.size());

        return ans ; 
    }
}