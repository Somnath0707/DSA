class SegmentTree{
    int n ;
    int tree[] ; 
    public SegmentTree(int num){
        n = num; 
        tree = new int[4 * n];
    }

    public void update(int i , int left , int right , int pos){
        if(left == right ){
            tree[i]++;
            return ; 
        }

        int mid = left + (right - left) / 2; 

        if(pos<= mid){
            update(2 * i + 1 , left , mid , pos);
        }else{
            update( 2 * i + 2 , mid + 1 , right , pos);
        }

        tree[i] = tree[2 * i + 1 ] + tree[2 * i + 2];
    }

    public int query(int i ,int ql , int qr , int left , int right ){

        // No overlap 
        if(left > qr || right < ql ){
            return 0 ; 
        }

        // Peftect 
        if(ql <= left && right <= qr){
            return tree[i];
        }

        int mid = left + (right - left ) / 2; 
        
        int leftRes = query(2 * i + 1 , ql , qr , left , mid);
        int rightRes = query( 2 * i + 2 , ql , qr , mid+1 , right);

        return leftRes + rightRes;
    }
}

class Solution {
    int MOD = 1000000007;
    public int createSortedArray(int[] nums) {
        

        long count = 0 ; 
        int n = nums.length; 
        int max = 100000;
        SegmentTree st = new SegmentTree(max+1);
        for(int i = 0 ; i < n ; i++){
            // number or elemetn qreatere than curr
            int val = nums[i];
            int greatCount = 0 ; 
            int lessCount = 0 ;

            // element greater so val + 1 till max 
            // if(val < max)
            greatCount = st.query(0 , val + 1 , max , 0 , max);
            // element less so 0 till val - 1
            // if(val > 0 )
            lessCount = st.query(0 , 0 , val -1 , 0 , max );

            count  =  (count + Math.min(greatCount , lessCount)) % MOD;

            st.update(0 , 0 , max , val);
        }

        return (int)count ; 
    }
}