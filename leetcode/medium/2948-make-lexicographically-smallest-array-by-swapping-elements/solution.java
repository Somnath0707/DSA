public class DSU {
    private final int[] parent;
    private final int[] rank;
    public int count;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        count = n;
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    public int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]); // Path compression
        }
        return parent[i];
    }

    public boolean union(int i, int j) {
        int rootI = find(i), rootJ = find(j);
        if (rootI == rootJ) return false;
        if (rank[rootI] < rank[rootJ]) { int t = rootI; rootI = rootJ; rootJ = t; }
        parent[rootJ] = rootI;
        if (rank[rootI] == rank[rootJ]) rank[rootI]++;
        count--;
        return true;
    }
}


class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        // So union find question 
        // When I see interconneted swaps where any can go any where is mostly union find 

        // here we can do is make connnected componenet of values who are like nums[i]-nums[j] <= limit if yes they can become componnenent

        // Steps we have to make an union find with a treemap 

        // First make an array with arr[nums[i]][index] and then sort them by the value then for each check if curr-prev <= limit if so make them a component each seperate 

        
        int n = nums.length ;
        DSU dsu = new DSU(n);  
        int arr[][] = new int[n][2]; 
        for(int i = 0 ; i < n ; i++){
            int curr = nums[i]; 
            arr[i][0] = nums[i]; 
            arr[i][1] = i; 
        }

        Arrays.sort(arr , (a,b)-> a[0]-b[0]);

        for(int i = 1 ; i < n ; i++){
            int curr = arr[i][0]; 
            int prev = arr[i-1][0]; 
            int preIndex = arr[i-1][1]; 

            if(Math.abs(curr-prev) <= limit){
                int parent = dsu.find(preIndex);
                dsu.union(parent , arr[i][1]);
            }
        }

        Map<Integer,TreeMap<Integer,Integer>> map = new HashMap<>(); 
        for(int i = 0 ; i < n ; i++){
            int parent = dsu.find(i); 
            int val = nums[i]; 
            map.putIfAbsent(parent , new TreeMap<>());
            map.putIfAbsent(parent, new TreeMap<>());
            TreeMap<Integer, Integer> temp = map.get(parent);
            temp.put(val, temp.getOrDefault(val, 0) + 1); 
        }

        int ans[] = new int[n]; 

        for(int i = 0 ; i < n ; i++){
            int parent = dsu.find(i); 
            int val = map.get(parent).firstKey();
            ans[i] = val; 
            map.get(parent).put(val , map.get(parent).get(val)-1);
            if(map.get(parent).get(val) == 0 ){
                map.get(parent).remove(val);
            }

        }

        return ans; 
    }
}

// 1->3->5
//3-> 1-> 5
// 5->1->3
// 5->3->1 

// so yes we can make connected componendted and any value of it can go any where in the that compnonnet so we can sort it 

// make all such connected components 

// For each index we can visit and see which component it belong and take the smallest value from that component 

// We can use tree map of it like map then treemap whre parent-> all the people in componet and then there freq and we alwasy take first key 