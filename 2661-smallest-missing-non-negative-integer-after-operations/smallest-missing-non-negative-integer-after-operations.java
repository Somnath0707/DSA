class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        // 1 6 7 8 13 and neg =-10  we want first is 0 can we make 0 from 5 yeah so we need -5 or multiple of 5 but in neg 
        //  then for 1 we need value that are lower than curr just by one for 2 we need vaue that is 

        //  ohh we can add or substract 
        //   for 0 we want any mulitple of 5 
        // for 1 we want any multiple of curr -1 or +1 
        // so we can take mod 
        // 1 0 2 3 1 3 
        // 0 1 2 3 

        // 1 3 0 
        // if value if geater in nums then ew 
        // if nums[i] i s pos and lower than we cant do any thing keep it as it is 
        // if curr is greater than we can do is mod 
        // if the abs value if greter than we can mod too 
        // nums = [1,-10,7,13,6,8], value = 7
        // 1 3 0 6 6 1 so the max is 0 and 1 which give me 01 

        // [1,-10,7,13,6,8], value = 5
        // 1 0 2 3 1 3 ans = 0 1 2 3 which is t

        // but ther could be a case where the value is like 8 we have taken till and we already used the 8 for diff but now we need it and there is diff that we could have used in that case 

        // so we can do it try to take the minimum which gives use this value 


        // if mulitple gives use same value we can take which has the lower 

        // suppose we used 8 to make 3 now we have got 0 1 2 3 4 5 6 7 now 8 we have already taken what to do we can use map to keep track where have we used 8 to make 3 is there any other one who is not taken can be used to make 3 

        // [3,0,3,2,4,2,1,1,0,4]
        // 5

        // 3 0 3 2 4 2 1 1 0 4 
        // 0 0 1 1 2 2 3 3 4 4 

        // 0 -3 if cur is less curr is neg than and if it is less than value we can use to sub it or if val + curr gives we canuse that too 

        // for pos it is nums[i] % val 
        // for neg it is ? 
        // like we cna do is -4 and 5 

        Map<Integer,Integer> map =new HashMap<>(); 
        int n = nums.length ; 
        for(int i = 0 ; i < n ; i++){
            int val = nums[i]; 
            if( val >= 0 ){
                int temp = val % value;
                map.put(temp , map.getOrDefault(temp , 0 ) + 1);
            }
            else {
                int temp = ((val % value) + value) % value;
                map.put(temp , map.getOrDefault(temp , 0 ) + 1);
            }
        }
        int ans = 0 ; 
        for(int i = 0 ; i < n ; i++){
            int check = i ; 
            // System.out.println(i + " value " + value); 
            if(i >= value ){
                // System.out.println(i + "value" + value); 
                check = i % value; 
                // System.out.println(check); 
            }
            // System.out.println(check); 
            if(!map.containsKey(check))break; 
            map.put(check, map.get(check)-1);
            if(map.get(check) == 0) map.remove(check); 
            ans++; 
        }
        return ans; 
    }
}

// 1 0 2 3 1 2 
// 0 1 1 2 2 3 

// 0 1 2 3 4 5 
// 6-5 so do we have 1 yeah so i++