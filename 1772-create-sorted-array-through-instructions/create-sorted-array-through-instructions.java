class SegmentTree{
    int n ; 
    int tree[];

    public SegmentTree(int num){
        n = num ; 
        tree = new int[4 * n ];
    }

    public void update(int i , int left , int right , int pos){
        if(left == right ) {
            tree[i]++;
            return ;
        }

        int mid = left + (right - left ) / 2 ; 
        
        if(pos <= mid){
            update(2* i + 1 , left , mid , pos);
        }else{
            update( 2 * i + 2 , mid + 1 , right , pos);
        }

        tree[i] = tree[ 2 * i + 1] + tree[2 * i + 2];
    }

    public int query(int i , int ql , int qr , int left , int right){
        

        // No overlap
        if(right < ql || qr < left){
            return 0 ; 
        }

        if(ql <= left && qr >= right){
            return tree[i];
        }

        int mid = left + (right - left)  / 2; 

        int leftRes = query(2 * i + 1 , ql , qr , left , mid);
        int rightRes = query(2*i + 2 , ql , qr , mid+1 , right);

        return leftRes + rightRes;
    }
}

class Solution {
    int MOD = 1000000007;
    public int createSortedArray(int[] nums) {
        int max = 100000;
        SegmentTree st = new SegmentTree(max+1);
        long count = 0 ; 

        for(int i = 0 ; i < nums.length ; i++){
            int val = nums[i];
            int lowCount = st.query(0 , 0 , val - 1 , 0 , max);
            int highCount = st.query(0 , val+1 , max , 0 , max);

            count = (count + Math.min(lowCount , highCount)) % MOD;

            st.update(0 , 0 , max , val);
        }

        return (int)count;
    }
}