class SegmentTree{
    int tree[];
    int n ; 

    public SegmentTree(int num){
        n = num;
        tree = new int[4 * n];
    }

    public int query(int i , int ql , int qr , int left , int right){
        //no over lap 
        if(ql > right || qr < left){
            return 0 ; 
        }

        // perfect over lpa
        if(ql <= left && qr >= right ){
            return tree[i];
        }

        int mid = left + (right - left ) / 2; 

        int leftRes = query(2 * i + 1 , ql , qr , left , mid);
        int rightRes = query(2 * i + 2 , ql , qr , mid + 1 , right );

        return leftRes + rightRes;
    }
    public void update ( int i , int left , int right , int pos){
        if(left == right){
            tree[i]++;
            return;// increament the count of the value we have withnessed 
        }

        int mid = left + (right - left) / 2; 
        if(pos <= mid){
            update(2 * i + 1 , left , mid , pos);
        }else{
            update(2 * i + 2 , mid + 1 , right , pos);
        }

        tree[i] = tree[2 * i + 1 ] + tree[2 * i + 2 ];
    }
}

class Solution {
    
    public int reversePairs(int[] nums) {

        Map<Long , Integer> map = new HashMap<>();
        List<Long> list = new ArrayList<>();
        for(long n : nums){
            list.add(n);
            list.add(1L * 2*n);
        }

        int n = nums.length;
        int ind = 0 ; 
        Collections.sort(list);
        for(int i = 0 ; i < list.size() ;i++){
            if(!map.containsKey(list.get(i)))
            map.put(list.get(i) , ind++);
        }
        int max = 2000000;
        int count = 0 ; 
        SegmentTree st = new SegmentTree(max+1);
        for(int i = n -1 ; i>= 0 ; i--){
            int val = map.get((long)nums[i]);

            
            int tempCount = 0 ; 

            tempCount = st.query(0 , 0 ,val - 1, 0 , max );

            if(tempCount > 0){
                count += tempCount;
            }
            int nextVal = map.get(1L *nums[i]*2);
            st.update(0 , 0 , max , nextVal);

        }

        return count; 
    }
    //2
}