{
        RollingHash sh = new RollingHash(a); 
        RollingHash rh = new RollingHash(b); 
        RollingHash real = new RollingHash(s); 

        List<Integer> list = new ArrayList<>(); 
        List<Integer> listB = new ArrayList<>(); 
        int n = s.length(); 
        int lenA = a.length(); 

        for(int i = 0 ; i < n-lenA ; i++){
            if(real.getHash(i ,i+lenA ) == sh.getHash(0 , lenA)){
                list.add(i); 
            }
        }

        int lenB = b.length(); 
        for(int i = 0 ; i < n - lenB ; i++){
            if(real.getHash(i,i+lenB) == rh.getHash(0 , lenB-1)){
                listB.add(i); 
            }
        }

        int left = 0; 
        int right = Math.min(list.size() , listB.size())-1;
        int ans = -1 ; 
        while(left <= right){
            int mid = left + (right-left)/2; 

            int diff = Math.abs(list.get(mid)-listB.get(mid));
            if(diff <= k){
                ans = mid;  
                left = mid+1;