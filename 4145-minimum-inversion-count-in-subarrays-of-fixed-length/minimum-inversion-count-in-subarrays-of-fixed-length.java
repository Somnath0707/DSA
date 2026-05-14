class SegmentTree {
    int tree[]; 
    int n ;

    public SegmentTree(int num ){
        n = num;
        tree = new int[4*n];
    }

    public void update(int i , int left , int right , int val , int pos){
        if(left == right){
            if(val != -1){
                tree[i]++;
                return;
            }
            else{
                tree[i]--;
                return;
            }
        }

        int mid = left + (right - left) / 2 ;
        if(pos<= mid){
            update(2 * i + 1 , left , mid , val , pos);
        }else{
            update(2 * i + 2 , mid + 1 , right , val , pos);
        }

        tree[i] = tree[2* i + 1] + tree[2 * i + 2];
    }

    public int query(int i , int ql , int qr , int left , int right){

        // No over lap 
        if(left > qr || right  < ql){
            return 0 ; 
        }

        // perfect over lap 
        if(ql <= left && right <= qr){
            return tree[i];
        }

        // Parital overlap
        int mid = left + (right - left) / 2; 
        
        int leftRes = query(2 * i + 1 , ql , qr , left , mid);
        int rightRes = query(2 * i + 2 , ql , qr , mid + 1 , right);

        return leftRes + rightRes;
    }
}
class Solution {
    public long minInversionCount(int[] nums, int k) {
        //Cooridnate compression
        List<Long> list = new ArrayList<>();

        for(long n : nums){
            list.add(n);
        }

        Collections.sort(list);

        Map<Long , Integer> map = new HashMap<>();
        int ind = 0 ; 
        for(int i = 0 ; i < list.size() ; i++){
            long val = list.get(i);
            if(!map.containsKey(val))
            map.put(val , ind++);
        }   

        SegmentTree st = new SegmentTree(ind);

        int n = nums.length;
        long count = 0 ; 
        long min = 0 ; 

        for(int i = 0 ; i < k ; i++){
            int val = map.get((long)nums[i]);

            count += st.query(0 , val+1 , ind , 0 , ind);

            st.update(0 , 0 , ind , 1 , val);
        }  

        min = count;


        for(int i = k ; i < n ; i++){
            long left = nums[i - k];
            count -= st.query(0 , 0 , map.get(left)-1 , 0 , ind);

            st.update(0 , 0 , ind , -1 , map.get(left));


            long curr = nums[i];

            count += st.query(0 , map.get(curr)+1 , ind , 0 , ind);

            st.update(0 , 0 , ind , 1 , map.get(curr));
            
            min = Math.min(min , count);

        }

        return min ; 
    }
}