class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int i = 0 ; i < arr1.length ; i++){
            String str = String.valueOf(arr1[i]);
            for(int j = 0 ; j < str.length() ; j++){
                int temp = Integer.parseInt(str.substring(0 , j+1));
                set.add(temp);
            }
        }

        // for(int i = 0 ; i < arr2.length ; i++){
        //     String str = String.valueOf(arr2[i]);
        //     for(int j = 0 ; j < str.length() ; j++){
        //         int temp = Integer.parseInt(str.substring(0 , j+1));
        //         set2.add(temp);
        //     }
        // }
        int max = 0 ; 
        // for(int i = 0 ;  i< arr1.length ; i++){
        //     String str = String.valueOf(arr1[i]);
        //     for(int j = 0 ; j < str.length() ; j++){
        //         String s = str.substring(0 , j+1);
        //         int temp = Integer.parseInt(s);
        //         if(set2.contains(temp)){
        //             max = Math.max(max , s.length());
        //         }
        //     }
        // }


        for(int i = 0 ; i < arr2.length ; i++){
            String str = String.valueOf(arr2[i]);
            for(int j = 0 ; j < str.length() ; j++){
                String s = str.substring(0 , j+1);
                int temp = Integer.parseInt(s);
                if(set.contains(temp)){
                    max = Math.max(max , s.length());
                }
            }
        }

        return max;
    }
}