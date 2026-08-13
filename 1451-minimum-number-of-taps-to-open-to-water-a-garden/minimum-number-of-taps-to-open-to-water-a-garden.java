class Solution {
    // public int bs(int nums[][] , int currEnd , int left , int right ){
    //     int right = nums.length-1; 

    //     while(left <= right){
    //         int mid = left + (right -left ) /2 ; 
    //         if(num[mid][0] <= currEnd ){
    //             ans = mid; 

    //         }
    //     }
    // }
    public int minTaps(int n, int[] ranges) {
        // get the interval for each if there is any intervals that are in the current like supose there were 1-2 3-4 and there comes and taps that does like 0-4 close all the taps in that range just keep current acitve 
        // 
        // 0 1 2 3 4 5 
        // at 0 how many are there 0 1 
        // at one  0 1 2 

        // i need in each range how many have contributed suppose specifiialy in that range like 2-6 how many are between these compltely not like 1-3, but like 3-4 3-5 like this so we can remove it 

        // get every inteval and then sort from the bigger to smaller and try to form 1 to n using that 

        // 0 3 , 0 5 , 1 3 , 2 4 , 4 4 , 5 5, 
        // 0 5 ,0 3 , 1 3 , 2 4 , 4 4 , 5 5 

        // if start == 0 and nd == n then return true and total till that thats it that the idea 

        int interval[][] = new int[n + 1][2];

        for (int i = 0; i < n + 1; i++) {
            int val = ranges[i];
            interval[i][0] = Math.max(i - val, 0);
            interval[i][1] = Math.min(i + val, n);
        }

        Arrays.sort(interval, (a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(b[1], a[1]);
        });

        int steps = 1;
        int prevEnd = interval[0][1];
        int farthest = prevEnd;
        if(prevEnd >= n) return steps ; 
        for (int i = 1; i < interval.length; i++) {
            int indx = i;
            for (int j = i; j < interval.length; j++) {
                int currStart = interval[j][0];
                int currEnd = interval[j][1];
                if (currStart <= prevEnd && currEnd > farthest) {
                    farthest = currEnd;
                    indx = j;
                }
            }

            if (prevEnd == farthest) {
                return -1;
            }

            i = indx;
            prevEnd = farthest;
            steps++;
            if(prevEnd>= n) break; 

            // find someone whoes start is <= currEnd and whoes end will be farthest 

        }
        if (farthest == n)
            return steps;
        return -1;
    }
}

// 1 2 1 0 2 1 0 1
// 0 2 , 0 3 , 1 4 , 3 3 , 2 6 , 4 6 , 6 6 , 6 7
// 2 6, 1 4, 0 2 ,1 3 , 4,6, 6 6 , 6 7
// make smaller to bigger tkae sort by the first start and then make and try mergeing the previous 
