class SegmentTree{
    int tree[] ;
    int n ; 

    SegmentTree(int num){
        n = num; 
        tree = new int[4*n];
    }

    public void update(int i , int left , int  right , int  pos , int val){
        if(left == right){
            if(val != -1 )
            tree[i]++;

            if(val == -1){
                tree[i]--;
            }
            return ; 
        }

        int mid = left + (right - left ) / 2 ; 

        if(pos<= mid){
            update(2 * i + 1 , left , mid, pos, val);
        }
        else{
            update(2 * i + 2 , mid + 1 , right , pos , val);
        }

        tree[i] = tree[2 * i + 1 ] + tree[2 * i + 2 ]; 
    }

    public int query(int i , int ql , int qr , int left , int right){
        // No overlap
        if(left > qr ||  right < ql){
            return 0 ; 
        }

        // perfect overlap
        if(ql <= left && right <= qr){
            return tree[i];
        }

        int mid = left + (right - left ) / 2; 

        int leftRes = query(2 * i + 1 , ql , qr , left , mid);
        int rightRes = query(2 * i + 2 , ql, qr , mid + 1 ,right);

        return leftRes + rightRes;
    }
}

class Solution {
    public long minInversionCount(int[] nums, int k) {
        /// What we do is take the last element in the window check if check if thre is element in range such 
        // n+1 to max if so count++
        // once we check the complete what do we do we move to the next window and remoe the first prev first elemetn int window and update the last element in the window and during this we get the min or prev and curr window count 

        // how do we remove range from the segment tree this is stupid as fuck 
        
        
        // Add the number in first window at least 


        /// Cooridnate compression 
        List<Long> list = new ArrayList<>();
        for(long n : nums){
            list.add(n);
        }

        Collections.sort(list);
        //Map them 
        Map<Long , Integer> map = new HashMap<>();
        int indx = 0 ; 
        for(int i = 0 ; i < list.size() ; i++){
            long val = list.get(i);
            if(!map.containsKey(val))
            map.put(val , indx++);
        }


        // finised the cooridante compresion 


        int max =indx+1;
        SegmentTree st = new SegmentTree(max);
        long count = 0 ; 
        for(int i = 0 ; i < k; i++){
            int val = map.get((long)(nums[i])); 


            count += st.query(0 , val+ 1 , max , 0 , max);

            st.update(0 , 0 , max , val, 1);
        }
        long min = count;
       
        int n = nums.length;
        for(int i = k ; i < n ; i++){
            int left = i - k ; 
            int del = map.get((long)nums[left]);
            // remmove the first element in the window 
            if(del > 0 )
            count -= st.query(0, 0, del-1, 0, max);
            st.update(0 , 0 , max , del , -1);
            
            

            int val = map.get((long)nums[i]);
            if(val < max)
            count +=  st.query(0 , val+ 1 , max , 0 , max);

            st.update(0 , 0 , max , val , 1);

            min = Math.min(min , count);

        }
        if(min == -1 ) return 0 ; 
        return min ;
    }
}