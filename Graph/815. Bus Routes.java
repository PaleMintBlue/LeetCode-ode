import java.awt.Point;

class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S==T) return 0;
        int N = routes.length;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            Arrays.sort(routes[i]);
            graph.add(new ArrayList());
        }
        Set<Integer> seen = new HashSet<>();
        Set<Integer> targets = new HashSet<>();
        Deque<Point> queue = new ArrayDeque<>();

        // Build the graph.  Two buses are connected if
        // they share at least one bus stop.
        for (int i = 0; i < N; ++i)
            for (int j = i+1; j < N; ++j)
                if (intersect(routes[i], routes[j])) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }

        // Initialize seen, queue, targets.
        // seen represents whether a node has ever been enqueued to queue.
        // queue handles our breadth first search.
        // targets is the set of goal states we have.
        for (int i = 0; i < N; ++i) {
            if (Arrays.binarySearch(routes[i], S) >= 0) {
                seen.add(i);
                queue.offer(new Point(i, 0));
            }
            if (Arrays.binarySearch(routes[i], T) >= 0)
                targets.add(i);
        }

        while (!queue.isEmpty()) {
            Point info = queue.poll();
            int node = info.x, depth = info.y;
            if (targets.contains(node)) return depth+1;
            for (Integer i: graph.get(node)) {
                if (!seen.contains(i)) {
                    seen.add(i);
                    queue.offer(new Point(i, depth+1));
                }
            }
        }

        return -1;
    }

    public boolean intersect(int[] A, int[] B) {
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] == B[j]) return true;
            if (A[i] < B[j]) i++; else j++;
        }
        return false;
    }
}
// slower
// class Solution {
//     public int numBusesToDestination(int[][] routes, int S, int T) {
//         if (S == T) return 0;

//         Map<Integer, HashSet<Integer>> graph = new HashMap<>();

//         for (int i = 0; i < routes.length; i++) {
//             for (int stop : routes[i]) {
//                 graph.putIfAbsent(stop, new HashSet<Integer>());
//                 graph.get(stop).add(i);
//             }
//         }

//         Deque<Integer> dq = new ArrayDeque<>();
//         dq.offer(S);
//         int count = 0;
//         Set<Integer> taken = new HashSet<>();

//         while (!dq.isEmpty()) {
//             for (int i = dq.size(); i > 0; i--) {
//                 int stop = dq.poll();
//                 if (stop == T) return count;
//                 for (int bus : graph.get(stop)) {
//                     if (taken.add(bus)) {
//                         for (int nextStop : routes[bus])
//                             dq.offer(nextStop);
//                     }
//                 }
//             }
//             count++;
//         }
//         return -1;
//     }
// }
