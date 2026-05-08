class Solution {
    private List<Integer> getPrimeFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        if (n < 2) return factors;
        
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        if (n > 1) factors.add(n);
        return factors;
    }
    public int minJumps(int[] nums) {
        Queue<Integer> q = new LinkedList<>();
        int n = nums.length ;
        boolean vis[] = new boolean [n];


        // to check the visisted prime 
        Set<Integer> visPrime = new HashSet<>();
        Map<Integer, List<Integer>> primeToIndices = new HashMap<>();
        
        // Precomputation Step: 
        // For every number, find its prime factors and register its index under those primes.
        for (int i = 0; i < n; i++) {
            List<Integer> factors = getPrimeFactors(nums[i]);
            for (int prime : factors) {
                primeToIndices.computeIfAbsent(prime, k -> new ArrayList<>()).add(i);
            }
        }

        q.offer(0);
        vis[0] = true; 
        int steps = 0 ; 
        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                int i = q.poll();

                if(i == n-1) return steps;

                int next = i+1; 
                // normal adjcent 
                if(next < n && !vis[next]){
                    vis[next]= true; 
                    q.add(next);
                }

                int prev = i-1;
                if(prev >=0 && !vis[prev]){
                    vis[prev] = true; 
                    q.add(prev);
                }

                // if prime
                if(primeToIndices.containsKey(nums[i]) && !visPrime.contains(nums[i])){
                    visPrime.add(nums[i]);
                    for (int j : primeToIndices.get(nums[i])) {
                        if (!vis[j] && i != j) {
                            vis[j] = true;
                            q.add(j);
                        }
                    }
                }
            }
            steps++;
        }
        return -1 ;
    }
}