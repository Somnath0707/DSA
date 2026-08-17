class Solution {

    Map<Integer, ArrayList<int[]>> map;

    public int bfs(int src, int tar, List<Integer> startBuses) {

        Map<Integer, Integer> dist = new HashMap<>();
        Deque<int[]> q = new ArrayDeque<>();

        for (int id : startBuses) {

            int state = src * 501 + id;

            dist.put(state, 1);

            q.offerLast(new int[]{src, id, 1});
        }

        while (!q.isEmpty()) {

            int[] curr = q.pollFirst();

            int val = curr[0];
            int uid = curr[1];
            int count = curr[2];

            int currState = val * 501 + uid;

            // stale state
            if (dist.get(currState) != count)
                continue;

            if (val == tar)
                return count;

            for (int[] num : map.get(val)) {

                int newVal = num[0];
                int newId = num[1];

                int newCount = count;

                if (newId != uid)
                    newCount++;

                int state = newVal * 501 + newId;

                int old = dist.getOrDefault(
                    state,
                    Integer.MAX_VALUE
                );

                if (newCount >= old)
                    continue;

                dist.put(state, newCount);

                if (newId == uid) {
                    // cost = 0
                    q.offerFirst(
                        new int[]{
                            newVal,
                            newId,
                            newCount
                        }
                    );
                } else {
                    // cost = 1
                    q.offerLast(
                        new int[]{
                            newVal,
                            newId,
                            newCount
                        }
                    );
                }
            }
        }

        return -1;
    }

    public int numBusesToDestination(
            int[][] routes,
            int source,
            int target) {

        if (source == target)
            return 0;

        map = new HashMap<>();

        int n = routes.length;

        List<Integer> startBuses = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int m = routes[i].length;

            for (int j = 0; j < m; j++) {

                int val = routes[i][j];

                if (val == source)
                    startBuses.add(i);

                int next;

                if (j == m - 1)
                    next = routes[i][0];
                else
                    next = routes[i][j + 1];

                map.putIfAbsent(
                    val,
                    new ArrayList<>()
                );

                map.get(val).add(
                    new int[]{next, i}
                );
            }
        }

        if (startBuses.isEmpty())
            return -1;

        return bfs(source, target, startBuses);
    }
}