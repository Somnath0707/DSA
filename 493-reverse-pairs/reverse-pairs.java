class SegmentTree{
    int tree[] ; 
    int n ; 

    public SegmentTree(int num){
        n = num ; 
        tree = new int[num*4];
    }


    public void update(int i , int left , int right , int pos){
        if(left == right){
            tree[i]++;
            return ; 
        }

        int mid = left + (right - left ) / 2 ; 

        if(pos<= mid){
            update(2 * i + 1 , left , mid , pos);
        }
        else {
            update(2 * i + 2 , mid + 1 , right , pos);
        }

        tree[i] = tree[2*i+1] + tree[2 * i + 2];
    }

    public int query(int i , int ql , int qr , int left , int right){
        // no overlap
        if(right < ql || qr < left){
            return 0 ; 
        }

        // perfect over lap 
        if(ql <= left && qr >= right ){
            return tree[i];
        }

        int mid = left + (right - left ) / 2 ;

        int leftRes = query(2 * i + 1 , ql , qr , left , mid);
        int rightRes = query(2 * i + 2 , ql , qr , mid + 1 , right);

        return leftRes + rightRes;
    }
}


class Solution {
    public int reversePairs(int[] nums) {
        List<Long> list = new ArrayList<>();
        int max = 200000;
        SegmentTree st = new SegmentTree(max+1);
        for(long n : nums){
            list.add(n);
            list.add(2L*n);
        }

        Map<Long , Integer> map = new HashMap<>();
        int n = nums.length;
        Collections.sort(list);

        int ind = 0 ; 
        for(int i = 0 ; i < list.size() ; i++){
            long val = list.get(i);
            if(!map.containsKey(val))
            map.put(val , ind++);
        }

        int count = 0 ; 
        for(int i = n-1 ; i >= 0 ; i--){
            long val = nums[i];
            int putVal = map.get(val);

            int tempCount = 0 ; 

            tempCount = st.query(0 , 0 , putVal - 1, 0 , max);
            count += tempCount;
            int doubleVal = map.get(1L*val*2);

            st.update(0 , 0 , max , doubleVal);

        }

    return count; 
    }
}