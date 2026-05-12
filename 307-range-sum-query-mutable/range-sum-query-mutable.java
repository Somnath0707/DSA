class SegmentTree{
    int n ; 
    int tree[];
    int arr[];

    public SegmentTree(int nums[]){
        n = nums.length ; 
        tree = new int[4*n];
        arr = nums;
    }

    public void build(int i , int left , int right){
        
        // Base Case
        if(left == right){
            // usual shi
            tree[i] = arr[left];
            return;
        }

        int mid = left + (right - left ) / 2; 

        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2 ; 

        build(leftChild , left , mid);
        build(rightChild , mid + 1 , right);

        tree[i] = tree[leftChild] + tree[rightChild];
    }

    public int range(int i , int ql , int qr , int left , int right){
        // Case 1 : No overLap
        if(right < ql || left > qr){
            return 0 ; 
        }

        // Case 2 : Complete overlap
        if(ql <= left && right <= qr){
            return tree[i];
        }

        // Case 3 : Partial overlap
        int mid = (left + right ) / 2;
        int left_res = range(2*i+1 , ql , qr , left , mid);
        int right_res = range(2*i+2 , ql , qr , mid+1 , right) ;

        return left_res + right_res;

    }

    public void updatePos(int i , int left , int right , int pos , int val){
        if(left == right){
            arr[left] = val;
            tree[i] = val;
            return ; 
        }

        int mid = left + (right - left) / 2; 

        if(pos <= mid){
            updatePos(2*i+ 1 , left , mid , pos , val);
        }else{
            updatePos(2*i + 2 , mid+1 , right , pos , val);
        }


        tree[i] = tree[2*i+1] + tree[2*i+2];
    }
}


class NumArray {
    SegmentTree st ; 
    int n ;
    public NumArray(int[] nums) {
        st = new SegmentTree(nums);
        n = nums.length;
        st.build(0 , 0 , n-1);

    }
    
    public void update(int index, int val) {
        st.updatePos(0 , 0 , n-1 , index , val);
    }
    
    public int sumRange(int left, int right) {
        int ans = st.range(0 , left , right , 0 , n-1);
        return ans;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */