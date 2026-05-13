class SegmentTree{
    int tree[]; 
    int arr[] ; 
    
    public SegmentTree(int[] nums){
        int n = nums.length;
        arr = nums;
        tree = new int[4*n];
    }

    public void build(int i , int left , int right ){
        if(left == right){
            tree[i] = arr[left];
            return ; 
        }
        
        int mid = left + (right - left ) / 2; 
        int leftChild = 2*i+1;
        int rightChild = 2 * i + 2; 

        build(leftChild , left , mid );
        build(rightChild , mid+1 , right);

        tree[i] = tree[leftChild] + tree[rightChild];
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

    public void update (int i , int left , int right , int pos , int val){
        if(left == right){
            arr[left] = val; 
            tree[i] = val;
            return ; 
        }
        int mid = left + (right - left ) / 2 ; 

        if(pos <= mid ){
            update(2* i + 1 , left , mid , pos , val);
        }
        else {
            update(2 * i + 2 , mid + 1 , right , pos , val);
        }

        tree[i] = tree[2 * i + 1 ] + tree[2 * i + 2];
    }
}



class NumArray {
    SegmentTree st; 
    int n ; 
    public NumArray(int[] nums) {
        st = new SegmentTree(nums);
        n = nums.length;
        st.build(0 , 0 , n-1);
    }
    
    public void update(int index, int val) {
        st.update(0 , 0 , n-1 , index , val);
    }
    
    public int sumRange(int left, int right) {
        int ans = st.query(0 , left , right , 0 , n-1);
        return ans;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */