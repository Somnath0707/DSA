class Solution {
    public int lisNonDecreasing(ArrayList<Integer> nums) {
        ArrayList<Integer> tail = new ArrayList<>();

        for (int x : nums) {

            int l = 0;
            int r = tail.size();

            while (l < r) {
                int mid = l + (r - l) / 2;

                if (tail.get(mid) <= x)
                    l = mid + 1;
                else
                    r = mid;
            }

            if (l == tail.size())
                tail.add(x);
            else
                tail.set(l, x);
        }

        return tail.size();
    }
    public int kIncreasing(int[] arr, int k) {
        int n = arr.length ;
        int ans = 0 ;  
        for(int i = 0 ; i < k ; i++){
            ArrayList<Integer> temp = new ArrayList<>();

            for (int j = i; j < arr.length; j += k)
            temp.add(arr[j]);

            int lis = lisNonDecreasing(temp);

            int total = (int)Math.ceil((double)(n - i )/ k) ; 

            ans += total - lis; 
        }

        return ans; 
    }
}