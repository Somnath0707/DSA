class Solution {
    public int countPairs(int[] nums) {
        int n = nums.length; 
        int count = 0; 

        Map<Integer , Integer> map = new HashMap<>();

        // find max length of digits
        int maxLen = 0;
        for(int num : nums){
            maxLen = Math.max(maxLen, String.valueOf(num).length());
        }

        for(int num : nums){
            Set<Integer> set = new HashSet<>();

            // pad with leading zeros
            String s = String.format("%0" + maxLen + "d", num);
            char[] arr = s.toCharArray();
            int len = arr.length;

            // include original number
            set.add(num);

            // generate all swaps
            for(int i = 0 ; i < len ; i++){
                for(int j = i + 1 ; j < len ; j++){
                    swap(arr, i , j);

                    int val = Integer.parseInt(new String(arr));
                    set.add(val);

                    swap(arr, i , j); // revert
                }
            }

            // count matches
            for(int val : set){
                count += map.getOrDefault(val, 0);
            }

            // store original number only
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return count;
    }

    public void swap(char arr[] , int i , int j ){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}