class SegmentTree{
    int[] tree ;
    int n ; 

    public SegmentTree(int num){
        int n = num;
        tree = new int[num*4];
    }

    public void update(int i , int left , int right , int pos){
        if(left == right ){
            tree[i]++;
            return;
        }

        int mid = left + (right - left) / 2 ; 

        if(pos <= mid){
            update(2* i + 1 , left , mid , pos);
        }else{
            update(2* i + 2 , mid + 1 , right , pos);
        }

        tree[i] = tree[2* i + 1 ] + tree[2 * i + 2];
    }

    public int query(int i , int ql , int qr , int left , int right){
        // No overlap
        if(right < ql || qr < left ){
            return 0; 
        }

        // Perfect overt lap 
        if(ql <= left && qr >= right) {
            return tree[i];
        }
        // perfect
        int mid = left + (right - left ) / 2 ;

        int leftRes = query(2 * i + 1 , ql , qr , left , mid);

        int rightRes = query(2 * i + 2 , ql , qr , mid + 1 , right );

        return leftRes + rightRes;
    }
}
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int OFFSET = 10000;
        // OFFSET and MAX cause the value could be negative me can handle that by the offset
        int max = 20000;
        SegmentTree st = new SegmentTree(max+1);
        List<Integer> list = new ArrayList<>();
        for(int i = nums.length-1 ; i >= 0;  i--){
            // to make the negative as positive 
            int val = nums[i] + OFFSET;
            int count = 0 ; 
            // We search for the the value that is less than current value i.e 0 to curr-1
            count = st.query(0 , 0 , val-1 , 0 , max );

            list.add(count);

            // we dont update at i we update the number i.e if the curr value is 5 we update the 5++ so the freq of 5 becomes 1
            st.update(0 , 0 , max , val);
        }
        Collections.reverse(list);
        return list;
    }
}