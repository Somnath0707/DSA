public class DSU{
    private int[] parent; 

    public DSU(int n){
        parent = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i ; 
        }
    }

    public int find(int x){
        if(parent[x] == x){
            return x; 
        }

        return parent[x] = find(parent[x]);
    }

    public void union(int x , int y , Set<Integer> set ){
        int rootX = find(x);// gets the parent of x 
        int rootY = find(y);// get the parent of y

        if(rootX != rootY){

            if(set.contains(rootX)){
                parent[rootY] = rootX;
            }
            else if(set.contains(rootY)){
                parent[rootX] = rootY; 
            }
            else{
                parent[rootX] = rootY; 
            }
        }
    }

    public void reset(int x){
        parent[x] = x; 
    }
}
class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        // Arrays.sort(meetings , (a,b) -> a[2]-b[2]);

        // use a for loop from curr time to the last time in the array then for each time check  how many meeting are then take each meeting create a conntecd component here if any of those have a memeber that know a secreat or now knows a sercreat then w get that complete compononet 
        // and move for ward to next time stamp

        // or we can do is like use while(!pq.isEMpty()) and insde that int time = pq.poll[2] while(pq.peek()[2] == time) we pop and build a connected componnent for that after that while we check if any of the connected component has the secerte if so we keep that node as parnet and then we take that complete component in the list do it to all 
        Set<Integer> set = new HashSet<>(); 
        set.add(0);
        set.add(firstPerson);
        DSU dsu = new DSU(n);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(a[2],b[2]));

        for(int num[] : meetings){
            pq.offer(num);
        }


        while(!pq.isEmpty()){
            List<Integer> list = new ArrayList<>(); 
            int curr[] = pq.poll();
            int x = curr[0]; 
            int y = curr[1]; 
            int time = curr[2]; 
            list.add(x);
            list.add(y); 

            dsu.union(x , y ,set);
            
            while(!pq.isEmpty() && pq.peek()[2] == time){
                int temp[] = pq.poll(); 
                int tempX = temp[0]; 
                int tempY = temp[1]; 

                list.add(tempX);
                list.add(tempY);

                dsu.union(tempX , tempY , set); 
            }

            for(int num : list){
                int parent = dsu.find(num); 
                if(set.contains(parent)){
                    set.add(num); 
                }
            }

            for(int num : list){
                dsu.reset(num);
            }
        }


        List<Integer> list = new ArrayList<>(set); 

        return list ; 

    }
}