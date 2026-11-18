public class Assignment01Q05 {

    public static int findShortestPath(int[][] m, int i, int j) {
        if (i == j) {
            return 0; // Shortest path from a vertex to itself is 0
        }

        int n = m.length;
        boolean[] visited = new boolean[n];
        int[] queue = new int[n];
        int[] dist = new int[n];

        int head = 0;
        int tail = 0;

        // Enqueue the starting vertex i
        queue[tail] = i;
        visited[i] = true;
        dist[i] = 0;
        tail++;

        // Continue while the queue is not empty
        while (head < tail) {
            int curr = queue[head]; // Dequeue the front vertex
            head++;

            for (int next = 0; next < n; next++) {
                if (m[curr][next] == 1 && !visited[next]) {
                    if (next == j) {
                        return dist[curr] + 1;
                    }
                    visited[next] = true;
                    dist[next] = dist[curr] + 1;
                    queue[tail] = next; // Enqueue neighbor
                    tail++;
                }
            }
        }

        return -1; // No path exists from i to j
    }



    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}