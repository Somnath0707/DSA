class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // we can do is like start from 10 and then do like statatinos take or skip suppose currFuel > stations we can either take it or and increase the fuel for the next or not take it and move if any any point our fuel become > target we return 0 as we got the answer 

        // suppose i reach station 1 if the fuel is smame as the as station then we can do is 0 + curr station fuel if curr fuel is low than station dist return max 
        // we just keep adding never remove the fuel suppose station
        //[[10,60],[20,30],[30,30],[60,40]] start is 10 
        // at station 0 we have fuel is 10 which is == our so we can either take curr or move we take total fuel 70 then 20 we can take or skip 
        // so on at 30 we have 70 so we can either take at this or skip if we deicde to take we get total fuel as 100 so we get the answer we return 0  or we can skip so total is 70 and we got to 60 here we can fuel or skip if we skip we reach end retunr max 

        // so base case are if we reach after last if fuel < target) return max if we reach a station where fuel is < station pos reutrn max 

        // else if we get at amy point fuel >= target return true; 

        // so the this is correct the only probelm here is the fuel is 10^9 so taking it as a state is not viable to use as the dp would become n * 10^9 

        // 

        int totalFuel = startFuel; 

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int ans = 0 ; 
        int n =stations.length ; 
        for(int i = 0 ; i < n ; i++){
            int curr = stations[i][0]; 
            int currFuel = stations[i][1];
            // pq.offer(currFuel); 
            // if(curr) 
            while(totalFuel < curr){
                if(pq.isEmpty() ) return -1; 
                int fuel = pq.poll(); 
                totalFuel+=fuel; 
                ans++; 
            }
            if(totalFuel >= target) break; 
            pq.offer(currFuel); 
        }

        while(totalFuel < target && !pq.isEmpty()){
            totalFuel+= pq.poll(); 
            ans++; 
        }
        if(totalFuel < target) return -1; 
        return ans; 
    }
}