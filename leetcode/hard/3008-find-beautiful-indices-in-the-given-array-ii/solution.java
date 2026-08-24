h(); 
        int j = lenA-1;

        for(int i = 0 ; i < n-lenA ; i++){
            if(real.getHash(i , j) == sh.getHash(0 , lenA-1)){
                list.add(i); 
            }
            j++;  
        }

        int lenB = b.length(); 
        j = lenB-1; 
        for(int i = 0 ; i < n - lenB ; i++){
            if(real.getHash(i,j) == rh.getHash(0 , lenB-1)){
                listB.add(i); 
            }
            j++; 
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
            }
            else{
                right =  mid-1; 
            }
        }
        if(ans == -1) return new ArrayList<>();

        List<Integer> res = new ArrayList<>(); 
        for(int i = 0 ; i <= ans ; i