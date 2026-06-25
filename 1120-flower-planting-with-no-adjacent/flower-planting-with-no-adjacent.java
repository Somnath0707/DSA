class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        // 1<->2 | 2 <->3 | 3 <->1
        // 1 : 2 , 3
        // 2 : 3 , 1 
        // 3 : 1 , 2 
        // we can do is make a adj list 
        // make a set and then for each we put a loop that goes from 1 to 4 to check if the number is taken by any other in that list of connected people 
        // if not we put that value 

        // we need a adj 1 and its set 2 and its set 3 and its set a4 and its set and one com

        // or may be just a adj list and a set that keep track of what that people have taken or not taken what would be time complexity 

        // the paths could be only 3 for each so 3 * for each in n length so the answer would be 3 * n which is not bad ig but but but for 4 folower we have to do that 
        // so the loop could like from check each so 4 * 3 * n 
        // 12*n where n = 2 * 10^4 so the answer could go ~24 * 10^4  fo if the that 4^3 or makybe 64 * 10^4 which could also be said as like 6.4 * 10^5 which is also not that bad ig 
        List<List<Integer>> list = new ArrayList<>(); 

        for(int i = 0 ; i <= n ; i++){
            list.add(new ArrayList<>());
        }

        for(int num[] : paths){
            int u = num[0]; 
            int v = num[1]; 

            list.get(u).add(v);
            list.get(v).add(u); 
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        int ans[] = new int[n]; 
        int ind = 0; 

        for(int i = 1 ; i <= n ; i++){
            List<Integer> temp = list.get(i);
            for(int j = 1 ; j <= 4 ; j++){
                boolean flag = false; 
                for(int k = 0 ; k < temp.size() ; k++){
                    int num = temp.get(k);
                    if(map.containsKey(num) && map.get(num) == j){
                        flag = true; 
                        break; 
                    }
                }
                if(flag == false){
                    ans[ind++] = j;
                    map.put(i , j); 
                    break; 
                }

            }
        }

        return ans; 
    }
}