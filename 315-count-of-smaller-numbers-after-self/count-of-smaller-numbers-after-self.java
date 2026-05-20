class SegmentTree{
    int tree[]; 
    int n ; 

    SegmentTree(int num){
        n = num ; 
        tree = new int[4 * n];
    }

    public void update(int i , int left , int right , int pos){
        if(left == right){
            tree[i]++;
            return ;
        }

        int mid = left + (right - left )  / 2; 
        if(pos <= mid){
            update(2 * i + 1 , left , mid  , pos);
        }else{
            update(2 * i + 2 , mid + 1, right , pos);
        }

        tree[i] = tree[2 * i + 2] + tree[2 * i + 1];
        // System.out.println("update : " + tree[i]);
    }

    public int query(int i , int ql , int qr , int left , int right){
        // No over lap 
        if(ql > right || qr < left ){
            return 0; 
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
    public List<Integer> countSmaller(int[] nums) {
        int max = 200000;
        int offset = 10000;
        SegmentTree st = new SegmentTree(max+1);

        List<Integer> list = new ArrayList<>();

        int n = nums.length ;

        for(int i = n-1 ; i >= 0 ; i--){
            int count = 0 ; 
            int curr = nums[i] + offset ;
            // System.out.println(curr);
            count = st.query(0 ,0, curr - 1 , 0 , max  );

            list.add(count);
            st.update(0 , 0 , max , curr);
        }

         Collections.reverse(list);
         return list;
    }
}