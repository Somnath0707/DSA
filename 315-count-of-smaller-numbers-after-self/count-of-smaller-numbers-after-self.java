class SegmentTree{
    int tree[]; 
    int arr[] ; 
    
    public SegmentTree(int num){
        int n = num;
        tree = new int[4*n];
    }

    public int query(int i , int ql , int qr , int left , int right ){
        // No overlap 
        if(right < ql || left > qr){
            return 0 ; /// default
        }

        // perfect overlap
        if(ql <= left && qr >= right){
            return tree[i];
        }

        // partial over lap 
        int mid = left + (right - left) / 2; 
        int leftRes = query(2 * i + 1 , ql , qr , left , mid );
        int rightRes = query(2 * i + 2 , ql , qr , mid + 1 , right);

        return leftRes + rightRes;
    }

    public void update (int i , int left , int right , int pos ){
        if(left == right){
            // arr[left] = val; 
            tree[i]++;
            return ; 
        }
        int mid = left + (right - left ) / 2 ; 

        if(pos <= mid ){
            update(2* i + 1 , left , mid , pos );
        }
        else {
            update(2 * i + 2 , mid + 1 , right , pos );
        }

        tree[i] = tree[2 * i + 1 ] + tree[2 * i + 2];
    }
}
class Solution {
    int OFFSET = 10000;
    public List<Integer> countSmaller(int[] nums) {
        int max = 20000;

        SegmentTree st = new SegmentTree(max+1);
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i = n-1 ; i >= 0 ; i--){
            int num = nums[i] + OFFSET;
            int count = 0 ; 
            if(num > 0)
                count = st.query(0 , 0 , num-1 , 0 , max);

            st.update(0 , 0, max , num);
            list.add(count);
        }

        Collections.reverse(list);
        return list;
    }
}